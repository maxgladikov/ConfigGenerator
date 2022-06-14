package com.gladikov.application.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gladikov.application.constants.Constants;
import com.gladikov.application.entities.aux.ModbusItem;
import com.gladikov.application.entities.aux.Task;

import lombok.Data;
import utils.ProcessorCSV;

@Data
public class Processor {
	private static Logger logger;
	private String cfgPath;
	private String serverName;
	private List<String> patternsName;
	private String projectTitle=Constants.getServerName().contains("EMC2")?"SS-02":"SS-03";
	private String outputPath;
	private String rootPath;
	private Integer readReg;
	private Integer writeReg;
	private List<Task> tasks;
	private static Processor processor;
	private Map<String,Map<String,ModbusItem>> patterns=new HashMap<String,Map<String,ModbusItem>>();
	
	private Processor(String cfgPath) 	{
		this.cfgPath=cfgPath;
		readCfg();
		logger=Constants.getLogger();
		readAdapters();
		readMaps();
		Task.setRC(Constants.getRc());
		processTasks();
		
		
//		 for (String key : patterns.keySet()) {
//		        System.out.println(key + ":" + patterns.get(key)+'\n');
//		    }
//		 patternsName.stream().forEach(x->System.out.println(x));
		
	}
	
	private  void processTasks()  {
		try {
		tasks=new ArrayList<Task>();
		//Read task file
		List<List<String>> taskList = ProcessorCSV.read(rootPath+"tasks.csv");
		taskList.stream()
						.peek(System.out::println)
//						.peek(x->System.out.println(patterns.get(x.get(1))))
						.forEach(x->tasks.add(new Task(x,patterns.get(x.get(1) ))));
		logger.info("tasks were successfully read");
		}catch(IOException e) {
			logger.debug(e);
		}
	}
	
	
	private void readMaps()   {
		try {
		for(String name:patternsName) {
			List<List<String>> list=ProcessorCSV.read(rootPath+name+".csv");
			Map<String,ModbusItem> map=new HashMap<String,ModbusItem>();
			list.stream()
			.forEach(x->map.put(x.get(0), new ModbusItem(x)));
			patterns.put(name, map);
		}
//		patterns.values().stream().
//		peek(x->x).
//		forEach(System.out::println);
		}catch(IOException e) {
			logger.debug(e);
		}catch (NullPointerException e) {
			logger.debug(e);
		}
	}
	
	private void readCfg() {
		serverName=Constants.getServerName();
		projectTitle=serverName.contains("EMC2")?"SS-02":"SS-03";
		outputPath=Constants.getOutputPath();
		rootPath=Constants.getSourcePath();;
		patternsName=Constants.getPatternsName();
		
	}
	
	private void readAdapters() {
		try {
			Map<String,String> map=new HashMap<String,String>();
			
		List<List<String>> list=ProcessorCSV.read(rootPath+"adapters.csv");
		list.stream().
		filter(x->x.get(0).contains(serverName))
		.forEach(x->map.put(x.get(1),x.get(2).replaceAll("\"", "")   ));
		Collections.unmodifiableMap(map);
		Constants.setAdapters(map);
		
		}catch(IOException e) {
			logger.debug(e);
			logger.debug("read problem with "+rootPath+"adapters");
		}
	}
	
	
	public static Processor getCfg(String cfgPath) {
		if(processor==null)
			processor= new Processor(cfgPath);
		return processor;
	}
	
	
}
