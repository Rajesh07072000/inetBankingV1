package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	//mngr472422
	//AvehUsU
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	
	@BeforeClass
	public void setup()
	{	
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers//chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\rajeshr7\\eclipse-workspace\\inetBankingV1\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		
		driver=new ChromeDriver();
		driver.get(baseURL);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	public void captureScreen(WebDriver driver,String tname) throws IOException 
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
		
	}


}
