package com.OrangeHRM.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.Base.BaseClass;
import com.OrangeHRM.PageObjects.AdminPage;
import com.OrangeHRM.PageObjects.LoginPage;

public class AdminTest extends BaseClass{

	WebDriver driver;
	LoginPage login;
	AdminPage admin;
	
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
	public void systemUserFields()
	{
		admin = new AdminPage(driver);
		admin.clickOnAdminTab();
		
		String actualmssg = admin.userManagementTextVerification();
		String expectedmssg = "User Management";
		Assert.assertEquals(actualmssg, expectedmssg);
		
		admin.enterempUsername("Admin");
		
		admin.enterEmpName("Paul Collings");
		
		admin.clickOnResetButton();
	}
	
	@Test(priority=2)
	public void verifyDeleteRecord()
	{
		admin = new AdminPage(driver);
		admin.clickOnAdminTab();
		
		admin = new AdminPage(driver);
		admin.clickOnDeleteRecordButton();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	

	
	
	
	
}
