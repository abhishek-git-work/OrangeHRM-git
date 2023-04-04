package com.OrangeHRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement giveusername;
	
	public void enterUsername(String username)
	{
		giveusername.sendKeys(username);
	}

	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement givepassword;
	
	public void enterPassword(String password)
	{
		givepassword.sendKeys(password);
	}
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	private WebElement loginbutton;
	
	public void clickOnLoginButton()
	{
		loginbutton.click();
	}
	
	@FindBy(xpath="//p[text()='Invalid credentials']")
	private WebElement warningmssg;
	
	public String invalidredentialsWarningMssg()
	{
		String warning = warningmssg.getText();
		return warning;
	}
	
	@FindBy(xpath="(//span[text()='Required'])[1]")
	private WebElement usernameReqMssg;
	
	public String usernameRequiredMssg()
	{
		String reqmssg1 = usernameReqMssg.getText();
		return reqmssg1;
	}
	
	@FindBy(xpath="(//span[text()='Required'])[2]")
	private WebElement passwordReqMssg;
	
	public String passwordRequiredMssg()
	{
		String reqmssg2 = passwordReqMssg.getText();
		return reqmssg2;
	}
	
}
