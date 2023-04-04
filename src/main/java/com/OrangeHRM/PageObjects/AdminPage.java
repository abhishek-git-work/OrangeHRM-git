package com.OrangeHRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

WebDriver driver;
	
	public AdminPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[normalize-space()='Admin']")
	private WebElement adminTab;
	
	public void clickOnAdminTab()
	{
		adminTab.click();	
	}
	
	@FindBy(xpath="//h6[normalize-space()='User Management']")
	private WebElement userManagementText;
	
	public String userManagementTextVerification()
	{
		String userText = userManagementText.getText();
		return userText;
	}
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement empUsername;
	
	public void enterempUsername(String user)
	{
		empUsername.sendKeys(user);
	}
	
	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[1]")
	private WebElement roledropdown;
	
	public void userRoleDropdownMenu()
	{
		roledropdown.click();
	}
	
	@FindBy(xpath="(//span[text()='Admin'])[2]")
	private WebElement adminselect;
	
	public void selectAdminoption()
	{
		adminselect.click();
	}
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement empName;
	
	public void enterEmpName(String empUserName)
	{
		empName.sendKeys(empUserName);
	}
	
	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[2]")
	private WebElement statusdropdown;
	
	public void statusDropdownMenu()
	{
		statusdropdown.click();
	}
	
	@FindBy(xpath="//button[normalize-space()='Reset']")
	private WebElement resetButton;
	
	public void clickOnResetButton()
	{
		resetButton.click();
	}
	
	@FindBy(xpath="//i[@class='oxd-icon bi-trash']")
	private WebElement deleteRecord;
	
	public void clickOnDeleteRecordButton()
	{
		deleteRecord.click();
	}
	
	
}
