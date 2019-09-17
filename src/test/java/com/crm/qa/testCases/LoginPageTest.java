package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.ExtentManager;

public class LoginPageTest extends BaseTest{
		
//	@BeforeSuite
//	public void beforeSuite() throws Exception {
//		ExtentManager.initialize();
//	}
//	
//	@AfterSuite
//	public void afterSuite() throws Exception {
//		ExtentManager.report.flush();
//	}
	
	@BeforeMethod
	public void setup() {
		openBrowser();
		navigate();
	}
	
	@Test(priority=1)
	public void titleTest() {
	    loginPage = new LoginPage();
		Assert.assertEquals(loginPage.validateLoginPageTitle(), "Tegrity Lecture Capture");
	}
	
	@Test(priority=2)
	public void validateLogoTest() {
		loginPage = new LoginPage();
		Assert.assertTrue(loginPage.validateLogo());
	}
	
	@Test(priority=3)
	public void validateCopyrightTextTest() {
		loginPage = new LoginPage();
		try{
			Assert.assertEquals(loginPage.validateCotyrightText(), "© 2019 McGraw-Hill Education. "
					+"All Rights Reserved. U.S. Patent No. 8,276,077. Additional Patents Pending.");
			
		} catch(Throwable t){
			Assert.fail("validateCopyrightTextTest FAILED");
			t.printStackTrace();
		}
		
	}
	
	@Test(priority=4)
	public void userLoginTest() {
		loginPage = new LoginPage();
		coursesPage=loginPage.userLogin(prop.getProperty("instructorUsername"), prop.getProperty("instructorPassword"));
		Assert.assertEquals(coursesPage.validateCoursesPageHeading(),"Courses");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}








