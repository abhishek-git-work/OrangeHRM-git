package com.OrangeHRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	private WebElement dashboardText;
	
	public String dashboardTextVerification()
	{
		String dashText = dashboardText.getText();
		return dashText;
	}
	
	@FindBy(xpath="//p[normalize-space()='My Actions']")
	private WebElement MyActionsText;
	
	public String MyActionsTextVerification()
	{
		String MyActions = MyActionsText.getText();
		return MyActions;
	}
	
	@FindBy(xpath="//p[normalize-space()='Time at Work']")
	private WebElement timeAtWorkText;
	
	public String timeAtWorkTextVerification()
	{
		String timeText = timeAtWorkText.getText();
		return timeText;
	}
	
	@FindBy(xpath="//p[normalize-space()='Quick Launch']")
	private WebElement quickLaunchText;
	
	public String quickLaunchTextVerification()
	{
		String quichText = quickLaunchText.getText();
		return quichText;
	}
	
	@FindBy(xpath="//p[normalize-space()='Buzz Latest Posts']")
	private WebElement buzzPostsText;
	
	public String buzzPostsTextVerification()
	{
		String buzzText = buzzPostsText.getText();
		return buzzText;
	}
	
	@FindBy(xpath="//p[normalize-space()='Employees on Leave Today']")
	private WebElement employeesLeaveText;
	
	public String employeesLeaveTextVerification()
	{
		String leaveText = employeesLeaveText.getText();
		return leaveText;
	}
	
	@FindBy(xpath="//p[normalize-space()='Employee Distribution by Sub Unit']")
	private WebElement EmployeeDistributionText;
	
	public String EmployeeDistributionTextVerification()
	{
		String distributionText = EmployeeDistributionText.getText();
		return distributionText;
	}
	
	@FindBy(xpath="//p[normalize-space()='Employee Distribution by Location']")
	private WebElement EmployeeLocationText;
	
	public String EmployeeLocationTextVerification()
	{
		String locationText = EmployeeLocationText.getText();
		return locationText;
	}
	

}
