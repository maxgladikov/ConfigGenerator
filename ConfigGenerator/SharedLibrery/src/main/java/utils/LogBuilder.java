package utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilderFactory;
import org.apache.logging.log4j.core.config.builder.api.LayoutComponentBuilder;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;

public class LogBuilder {



public static Logger build(String logDir) {
ConfigurationBuilder< BuiltConfiguration > builder = ConfigurationBuilderFactory.newConfigurationBuilder();

builder.setStatusLevel( Level.ERROR);
builder.setConfigurationName("RollingBuilder");
// create a console appender
AppenderComponentBuilder appenderBuilder = builder.newAppender("Stdout", "CONSOLE").addAttribute("target",
    ConsoleAppender.Target.SYSTEM_OUT);
appenderBuilder.add(builder.newLayout("PatternLayout")
    .addAttribute("pattern", "%d [%t] %-5level: %msg%n%throwable"));
builder.add( appenderBuilder );
// create a rolling file appender
LayoutComponentBuilder layoutBuilder = builder.newLayout("PatternLayout")
    .addAttribute("pattern", "%d [%t] %-5level: %msg%n");
ComponentBuilder triggeringPolicy = builder.newComponent("Policies")
    .addComponent(builder.newComponent("CronTriggeringPolicy").addAttribute("schedule", "0 0 0 * * ?"))
    .addComponent(builder.newComponent("SizeBasedTriggeringPolicy").addAttribute("size", "1M"));
appenderBuilder = builder.newAppender("rolling", "RollingFile")
    .addAttribute("fileName", logDir+"rolling.log")
//    .addAttribute("fileName", "/home/max/log/rolling.log")
    .addAttribute("filePattern", logDir+"rolling-%d{dd-MM-yy}.log.gz")
//    .addAttribute("filePattern", "/home/max/log/rolling-%d{dd-MM-yy}.log.gz")
    .add(layoutBuilder)
    .addComponent(triggeringPolicy);
builder.add(appenderBuilder);

// create the new logger
builder.add( builder.newLogger( "RollingLogger", Level.DEBUG )
    .add( builder.newAppenderRef( "rolling" ) )
    .addAttribute( "additivity", false ) );

builder.add( builder.newRootLogger( Level.DEBUG )
    .add( builder.newAppenderRef( "rolling" ) ) );
LoggerContext ctx = Configurator.initialize(builder.build());

Logger logger=LogManager.getLogger("RollingLogger");
logger.info("HELLO!!!!!");
return logger;


}


}