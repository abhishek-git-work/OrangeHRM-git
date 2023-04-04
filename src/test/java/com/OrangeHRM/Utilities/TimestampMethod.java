package com.OrangeHRM.Utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampMethod {
	
	public static  String getLocalDateTime()
	{
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
		LocalDateTime now = LocalDateTime.now();
		String date = dateformat.format(now);
		
		return date;
	}

}
