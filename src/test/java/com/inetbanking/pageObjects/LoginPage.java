package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	@FindBy(xpath="//td[text()='UserID']/following::input[1]")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(xpath="//td[text()='Password']/following::input[1]")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//a[text()='Log out']")
	@CacheLookup
	WebElement lnkLogout;
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void clickSubmit()
	{
		btnLogin.click();
	}
	public void clickLogout() 
	{
		lnkLogout.click();
		
	}

}
