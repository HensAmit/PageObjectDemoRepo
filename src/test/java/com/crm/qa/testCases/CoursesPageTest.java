package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.LoginPage;

public class CoursesPageTest extends BaseTest{
	//constructor
	public CoursesPageTest() {
		super();
	}
	
	@BeforeTest
	public void setup() {
		initialization();
		navigate();
	}
	
	@Test
	public void validateCoursesPageHeadingTest(){
		eTest = eReport.startTest("validateCoursesPageHeading");
		loginPage = new LoginPage(eTest);
		coursesPage=loginPage.userLogin(prop.getProperty("instructorUsername"), prop.getProperty("instructorPassword"));
		Assert.assertEquals(coursesPage.validateCoursesPageHeading(), "Courses");
		reportPass("validateCoursesPageHeadingTest");
	}
		
	@AfterTest
	public void tearDown(){
		eReport.endTest(eTest);
		eReport.flush();
		driver.quit();
	}
}
