package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException {
//		driver.get(baseURL);
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(user);
		lp.setPassword(pwd);
		Thread.sleep(3000);
		lp.clickSubmit();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			captureScreen(driver, "loginDDT");
			driver.switchTo().alert().accept();  //invalid alert
		
			driver.switchTo().defaultContent();
			
			Assert.assertTrue(false);
		}
		else {
			
			Assert.assertTrue(true);
			lp.clickLogout();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();  //logout alert
			driver.switchTo().defaultContent();
		}
		
			
	}
	public boolean isAlertPresent()
	{
		try {
		driver.switchTo().alert();
		return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
			
		}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		int rownum=XLUtils.getrowCount(path, "Sheet1");
		int colcount=XLUtils.getcellCount(path, "Sheet1", rownum);
		String logindata[][]=new String[rownum][colcount];
		for(int i=1;i<rownum+1;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1",i, j);
				
			}
		}
		return logindata;
	}

}
