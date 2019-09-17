package com.crm.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.base.BaseTest;

public class RecordingsListPageTest extends BaseTest {
	
	@BeforeMethod
	public void setup(){
		openBrowser();
		navigate();
	}
	
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
}
