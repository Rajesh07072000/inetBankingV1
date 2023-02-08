package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		
	}
	@FindBy(how=How.XPATH,using="//a[text()='New Customer']")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how=How.XPATH,using="//td[text()='Customer Name']/following::input[1]")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how=How.NAME,using="rad1")
	@CacheLookup
	WebElement rdgender;
	
	@FindBy(how=How.NAME,using="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how=How.XPATH,using="//td[text()='Address']/following::textarea")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(how=How.XPATH,using="//td[text()='City']/following::input[1]")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(how=How.XPATH,using="//td[text()='State']/following::input[1]")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy(how=How.XPATH,using="//td[text()='PIN']/following::input[1]")
	@CacheLookup
	WebElement txtpinno;
	
	@FindBy(how=How.XPATH,using="//td[text()='Mobile Number']/following::input[1]")
	@CacheLookup
	WebElement txttelephone;
	
	@FindBy(how=How.XPATH,using="//td[text()='E-mail']/following::input[1]")
	@CacheLookup
	WebElement txtemailid;
	
	@FindBy(how=How.XPATH,using="//td[text()='Password']/following::input[1]")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(how=How.XPATH,using="//input[@type='submit']")
	@CacheLookup
	WebElement btnSubmit;
	
	public void clickAddNewCustomer()
	{
		lnkAddNewCustomer.click();;
	}
	
	public void custName(String cname)
	{
		txtCustomerName.sendKeys(cname);
	}
	
	public void custgender(String cgender)
	{
		rdgender.click();
	}
	public void custdob(String mm,String dd,String yy)
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void custaddress(String caddress)
	{
		txtaddress.sendKeys(caddress);
	}
	
	public void custcity(String ccity)
	{
		txtcity.sendKeys(ccity);
	}
	public void custstate(String cstate)
	{
		txtstate.sendKeys(cstate);
	}
	public void custpinno(int cpinno)
	{
		txtpinno.sendKeys(String.valueOf(cpinno));
	}
	
	public void custtelephoneno(String ctelephoneno)
	{
		txttelephone.sendKeys(ctelephoneno);
	}
	public void custemailid(String cemailid)
	{
		txtemailid.sendKeys(cemailid);
	}
	public void custpassword(String cpassword)
	{
		txtpassword.sendKeys(cpassword);
	}
	public void custsubmit() {
		btnSubmit.click();
	}
	
	

}
