package com.OrangeHRM.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public static WebDriver driver;
	public Properties configprop;
	
	public void configpropertiesfile() throws IOException
	{
		configprop = new Properties();
		File configFile = new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\OrangeHRM\\config\\config.properties");
		FileInputStream fis = new FileInputStream(configFile);
		configprop.load(fis);
	}
	
	public WebDriver openBrowserandURL(String browsername)
	{
		if(browsername.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		}
		if(browsername.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		if(browsername.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(configprop.getProperty("url"));
		
		return driver;
	}

}
