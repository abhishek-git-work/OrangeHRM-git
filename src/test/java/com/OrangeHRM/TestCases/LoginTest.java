package com.OrangeHRM.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangeHRM.Base.BaseClass;
import com.OrangeHRM.PageObjects.HomePage;
import com.OrangeHRM.PageObjects.LoginPage;
import com.OrangeHRM.Utilities.ExcelMethod;

public class LoginTest extends BaseClass{
		
	WebDriver driver;
	LoginPage login;
	HomePage home;
	
	@BeforeMethod
	public void setup() throws IOException
	{		
		configpropertiesfile();
		driver = openBrowserandURL(configprop.getProperty("browser"));	
	}
	
	@Test(priority=1,dataProvider="excelDataForLogin")
	public void loginWithInvalidCredentials(String username, String password)
	{
		login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickOnLoginButton();
		
		String actualmssg = login.invalidredentialsWarningMssg();
		String expectedmssg = "Invalid credentials";
		Assert.assertEquals(actualmssg, expectedmssg);
	}
	
	@DataProvider(name="excelDataForLogin")
	public Object[][] exceldataprovider() throws IOException
	{
		Object[][] data = ExcelMethod.testDataFromExcelSheet("Login");
		return data;
	}
	
	@Test(priority=2)
	public void loginWithValidCredentials()
	{
		login = new LoginPage(driver);
		login.enterUsername("Admin");
		login.enterPassword("admin123");
		login.clickOnLoginButton();
		
		home = new HomePage(driver);
		String actualText = home.dashboardTextVerification();
		String expectedText = "Dashboard";
		Assert.assertEquals(actualText, expectedText);
	}
	
	@Test(priority=3)
	public void loginWithoutCredentials()
	{
		login = new LoginPage(driver);
		login.clickOnLoginButton();
		
		String Uactualmssg = login.usernameRequiredMssg();
		String Uexpectedmssg = "Required";
		Assert.assertEquals(Uactualmssg, Uexpectedmssg);
		
		String Pactualmssg = login.passwordRequiredMssg();
		String Pexpectedmssg = "Required";
		Assert.assertEquals(Pactualmssg, Pexpectedmssg);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}

}
