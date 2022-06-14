package com.gladikov.application;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.gladikov.application.constants.Constants;
import com.gladikov.application.entities.MyObject;
import com.gladikov.application.entities.aux.Task;
import com.gladikov.application.entities.kep.Channel;
import com.gladikov.application.entities.linkMaster.LinkGroup;
import com.gladikov.application.entities.linkMaster.LinkItemInput;
import com.gladikov.application.entities.linkMaster.LinkItemOutput;
import com.gladikov.application.util.DCSmap;
import com.gladikov.application.util.Processor;
import com.gladikov.application.util.RegCounter;
import utils.TimeStamp;
import utils.ProcessorCSV;
import utils.RegEx;

@JsonRootName(value = "project") 
public class Project {
	@JsonIgnore
	private DCSmap dcsMap=new DCSmap();
	@JsonIgnore
	private static Project project;
	@JsonIgnore
	private List<Task> tasks;
	@JsonIgnore
	private String rootPath;
	@JsonIgnore
	private List<MyObject> objects=new ArrayList<MyObject>();
	@JsonIgnore
	private String linkMasterConfig;
	@JsonProperty("common.ALLTYPES_DESCRIPTION")
	private final String description="";
	@JsonProperty("servermain.PROJECT_TITLE")
	private final String title;
	@JsonProperty("channels")
	private List<Channel> channels=new ArrayList<Channel>();
	private ObjectMapper objectMapper = new ObjectMapper();
	private String outputPath; 
	
	
	private Project(String cfgPath) throws IOException {
		Processor cfg=Processor.getCfg(cfgPath);
		title=cfg.getProjectTitle();
		rootPath=Constants.getSourcePath();
		outputPath=Constants.getOutputPath();
		tasks=cfg.getTasks();
		tasks.stream().forEach(x->objects.add(new MyObject(x)));
		objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE); 
		
		fillLinkMasterConfig();
		objects.stream().forEach(x->dcsMap.add(x.getLinkItemInputs()));
		String dcs=Constants.getAdapters().keySet().stream().filter(x->x.contains("DCS")).findFirst().get();
		Constants.setDcsChannel(new Channel(Constants.getRandom(),"DCS",Constants.getAdapters().get(dcs),"DCS",RegEx.getIP(Constants.getAdapters().get(dcs)),false));
		channels.add(Constants.getDcsChannel());
		for(MyObject element:objects) {
			channels.add(element.getChannel());
		}
		project=this;
	}
	
	public static Project getProject(String cfg) throws IOException {
		if(project==null)
			project=new Project(cfg);
		return project;
	}
		
	public void writeResults() throws StreamWriteException, DatabindException, IOException {
		ProcessorCSV.write(outputPath+"linkMasterCfg_"+TimeStamp.getDateAndTime().replace(":", "-")+".csv",linkMasterConfig);
		dcsMap.getMap(outputPath+"dcsMap"+TimeStamp.getDateAndTime().replace(":", "-")+".csv");
		objectMapper.writeValue(new File(outputPath+"kepCfg"+TimeStamp.getDateAndTime().replace(":", "-")+".json"),project );
	}
	
	private void fillLinkMasterConfig(){
		StringBuilder sb1=new StringBuilder();
		StringBuilder sb2=new StringBuilder();
		StringBuilder sb3=new StringBuilder();
		StringBuilder sb4=new StringBuilder();
		sb1.append(LinkGroup.getTitle());
		sb2.append(LinkItemInput.getTitle());
		sb3.append(LinkItemOutput.getTitle());
	
	for (MyObject object : objects) {
		sb1.append(object.getLinkGroupString());
		sb2.append(object.getLinkInputsString());
		sb3.append(object.getLinkOutputsString());
		}
		sb4.append(sb1.toString());
		sb4.append(sb2.toString());
		sb4.append(sb3.toString());
		linkMasterConfig=sb4.toString();
	}
	
}
