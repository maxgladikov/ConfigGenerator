package com.gladikov.application.constants;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.stream.Collectors;

import javax.swing.text.rtf.RTFEditorKit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gladikov.application.entities.kep.Channel;
import utils.LogBuilder;
import com.gladikov.application.main.Main;
import com.gladikov.application.util.Processor;
import com.gladikov.application.util.RegCounter;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Constants {
	//Cfg data
	@Getter
	private static Properties prop ;
	//Logger
	@Getter
	@Setter
	private  static Logger logger;
	
	
	@Getter
	private static String serverName;
	@Getter
	private static String osName;
	@Getter
	private static List<String> patternsName;
	@Getter
	private String projectTitle;
	@Getter
	private static String sourcePath;
	@Getter
	private static String outputPath;
	@Getter
	private static RegCounter rc;
	
	@Getter
	private final static String MACHINE_NAME = "Local Machine";
	@Getter
	private final static String SERVER_NAME = "KepWare.KEPServerEX.V6";
	@Getter
	private  static Map<String,String> adapters;;
	@Getter
	@Setter
	private static Channel dcsChannel;
	@Getter
	private static Random random=new Random();
	
	public static void setAdapters(Map<String,String> ads) {
		adapters=ads;
	}
	
	public static Properties readProp(String path) {
		try {
		InputStream input = new FileInputStream(path);
        Properties prop = new Properties();
            prop.load(input);
           
		serverName=prop.getProperty("name");
		osName=System.getProperty("os.name");
		rc=new RegCounter(new Integer(prop.getProperty("readReg")), new Integer(prop.getProperty("writeReg")));
		sourcePath=prop.getProperty("DIR");
		System.out.println("OS type**********************"+System.getProperty("os.name").contains("indows"));
		outputPath=sourcePath+(osName.toLowerCase().contains("windows")?"output\\":"output/");
		patternsName=Arrays.asList(prop.getProperty("patternList").split(","))
        		.stream().collect(Collectors.toList());
		//********************
		System.out.println("***************");
		prop.list(System.out);
		
		System.out.println("1.) serverName="+serverName);
		System.out.println("***************");
		System.out.println("2.) sourcePath="+sourcePath);
		System.out.println("***************");
		System.out.println("***************");
		System.out.println("2.) outputPath="+outputPath);
		System.out.println("***************");
		System.out.println("3.) patternList="+patternsName);
		System.out.println("***************");
		//*******************
	
		
		if(serverName!=null&&rc!=null&&sourcePath!=null&&patternsName!=null)
			System.out.println("initials were assined properely");
		}catch(IOException e) {
			System.out.println(e);
		}
		return prop;
	}
	
	public static void init() {
		 LogBuilder.build(System.getProperty("DIR"));
		  Logger log=LogManager.getLogger("TestLogger");
		  log.debug("************Hello from Logger!!!***************");
		 logger=LogManager.getLogger("***************************************");
		 
	}
	
	
}
