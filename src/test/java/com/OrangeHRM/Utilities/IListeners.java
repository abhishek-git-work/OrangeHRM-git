package com.OrangeHRM.Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class IListeners implements ITestListener{
	
	ExtentReports exreport;
	ExtentTest test;
	
	@Override
	public void onStart(ITestContext context) 
	{	
		exreport = ExtentSparkReport.generateExtentReport();
	}

	@Override
	public void onTestStart(ITestResult result) 
	{	
		test = exreport.createTest(result.getName());
		test.log(Status.INFO,result.getName()+ "test execution started");		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{		
		test.log(Status.PASS,result.getName()+ "test execution succeessful");
	}

	@Override
	public void onTestFailure(ITestResult result)
	{		
		String destination=null;
		try {
			destination = ScreenshotMethod.takeScreenshotMethod(result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(destination);
		test.log(Status.FAIL,result.getName()+ "test execution failed");
		test.log(Status.INFO, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{		
		test.log(Status.SKIP,result.getName()+ "test execution skipped");
		test.log(Status.INFO, result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) 
	{	
		test.log(Status.INFO, "project finish");
		exreport.flush();
		
		try {
			Desktop.getDesktop().browse(new File("extentReport.html").toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
