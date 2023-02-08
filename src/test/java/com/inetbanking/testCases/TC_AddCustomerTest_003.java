package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException{
		
	LoginPage lp=new LoginPage(driver);
	
	//jp.clickAddNewCustomer();
	lp.setUserName(username);
	lp.setPassword(password);
	lp.clickSubmit();
	Thread.sleep(2000);
	
	AddCustomerPage addcust=new AddCustomerPage(driver);
	addcust.clickAddNewCustomer();
	addcust.custName("rajesh");
	addcust.custgender("male");
	addcust.custdob("07", "07", "2000");
	Thread.sleep(2000);
	addcust.custaddress("India");
	addcust.custcity("bangalore");
	addcust.custstate("Karnataka");
	addcust.custpinno(560020);
	addcust.custtelephoneno("1234567897");
	String email=randomString()+"@gmail.com";
	addcust.custemailid(email);
	addcust.custpassword("abcdef");
	addcust.custsubmit();
	Thread.sleep(2000);
	
	boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
	if(res==true)
	{
		Assert.assertTrue(true);
	}
	else
	{
		captureScreen(driver, "addNewCustomer");
		Assert.assertTrue(false);
	}
	
	}
			
}
