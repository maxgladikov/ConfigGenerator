package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeStamp {
	
    
    
    
    

	
	
	public static String getTime() {
		LocalTime time = LocalTime.now();
		return time.toString();
	}
	public static String getDateAndTime() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("_dd-MM-yyyy_HH:mm:ss");
		return dateTime.format(format);
	}
	public static String getDate() {
		LocalDate date = LocalDate.now(); 
		return date.toString();
	}

}
