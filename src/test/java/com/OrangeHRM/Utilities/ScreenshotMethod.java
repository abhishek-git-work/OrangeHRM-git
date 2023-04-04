package com.OrangeHRM.Utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.OrangeHRM.Base.BaseClass;

public class ScreenshotMethod extends BaseClass{

	public static String takeScreenshotMethod(String testname) throws IOException
	{	
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination = ("Screenshots//Test-"+testname+" "+TimestampMethod.getLocalDateTime()+".jpeg");
		FileHandler.copy(source, new File(destination));
		
		return destination;		
	}
}
