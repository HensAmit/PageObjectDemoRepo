package com.crm.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.base.BaseTest;

public class RecordingsListPageTest extends BaseTest {
	
	public RecordingsListPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		navigate();
	}
	
	
	
	@AfterMethod
	public void teardown(){
		eReport.endTest(eTest);
		eReport.flush();
		driver.quit();
	}
	
}
