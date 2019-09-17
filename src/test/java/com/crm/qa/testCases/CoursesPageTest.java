package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.LoginPage;

public class CoursesPageTest extends BaseTest{
	
	@BeforeMethod
	public void setup() {
		openBrowser();
		navigate();
	}
	
	@Test
	public void validateCoursesPageHeadingTest(){
		loginPage = new LoginPage();
		coursesPage=loginPage.userLogin(prop.getProperty("instructorUsername"), prop.getProperty("instructorPassword"));
		Assert.assertEquals(coursesPage.validateCoursesPageHeading(), "Courses");
	}
		
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}
