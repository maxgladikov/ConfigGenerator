package com.gladikov.application.main;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gladikov.application.Project;
import com.gladikov.application.constants.Constants;
import utils.LogBuilder;
import com.gladikov.application.util.Processor;


import utils.ProcessorCSV;

//logger.info("this is info");
//logger.error("this is error");
//logger.warn("this is warn");
//logger.fatal("this is fatal");
public class Main {
	
	
	public static void main(String[] args)  {
		
		 
		
		System.out.println("***Reading properties*********");
		if(args.length!=0) {
		
			Constants.readProp(args[0]);
		}else {
			throw new RuntimeException("Next time use correct argument!!! Bye!!!");
		}
		Constants.setLogger(LogBuilder.build(Constants.getSourcePath()));
		Logger logger=Constants.getLogger();
		logger.info("HELLO!!!!! Logger is here!!! See the properties bellow ");
		
		
		
			
		try {
			Project project=Project.getProject(args[0]);
			project.writeResults();
		} catch (IOException e) {
			logger.debug(e);
		}
		
}
		
		

}
