package com.OrangeHRM.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.Base.BaseClass;
import com.OrangeHRM.PageObjects.HomePage;
import com.OrangeHRM.PageObjects.LoginPage;

public class HomeTest extends BaseClass{
	
	WebDriver driver;
	HomePage home;
	LoginPage login;
	
	@BeforeMethod
	public void setup() throws IOException
	{		
		configpropertiesfile();
		driver = openBrowserandURL(configprop.getProperty("browser"));	
		
		login = new LoginPage(driver);
		login.enterUsername("Admin");
		login.enterPassword("admin123");
		login.clickOnLoginButton();
	}
	
	@Test(priority=1)
	public void timeAtWorkTextVerification()
	{
		home = new HomePage(driver);
		
		String actualText1 = home.timeAtWorkTextVerification();
		String expectedText1 = "Time at Work";
		Assert.assertEquals(actualText1, expectedText1);
	}
	
	@Test(priority=2)
	public void MyActionsTextVerification()
	{
		home = new HomePage(driver);
		
		String actualText2 = home.MyActionsTextVerification();
		String expectedText2 = "My Actions";
		Assert.assertEquals(actualText2, expectedText2);
	}
	
	@Test(priority=3)
	public void quickLaunchTextVerification()
	{
		home = new HomePage(driver);
		
		String actualText3 = home.quickLaunchTextVerification();
		String expectedText3 = "Quick Launch";
		Assert.assertEquals(actualText3, expectedText3);
	}
	
	@Test(priority=4)
	public void buzzPostsTextVerification()
	{
		home = new HomePage(driver);
		
		String actualText4 = home.buzzPostsTextVerification();
		String expectedText4 = "Buzz Latest Posts";
		Assert.assertEquals(actualText4, expectedText4);
	}
	
	@Test(priority=5)
	public void employeesLeaveTextVerification()
	{
		home = new HomePage(driver);
		
		String actualText5 = home.employeesLeaveTextVerification();
		String expectedText5 = "Employees on Leave Today";
		Assert.assertEquals(actualText5, expectedText5);
	}
	
	@Test(priority=6)
	public void EmployeeDistributionTextVerification()
	{
		home = new HomePage(driver);
		
		String actualText6 = home.EmployeeDistributionTextVerification();
		String expectedText6 = "Employee Distribution by Sub Unit";
		Assert.assertEquals(actualText6, expectedText6);
		
	}
	
	@Test(priority=7,dependsOnMethods= {"EmployeeDistributionTextVerification"})
	public void EmployeeLocationTextVerification()
	{
		home = new HomePage(driver);
		
		String actualText7 = home.EmployeeLocationTextVerification();
		String expectedText7 = "Employee Distribution by Location";
		Assert.assertEquals(actualText7, expectedText7);
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}


}
