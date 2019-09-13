package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPageTest extends BaseTest{
	//constructor
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		navigate();
	}
	
	@Test(priority=1)
	public void titleTest() {
	    eTest = eReport.startTest("Title Test");
	    loginPage = new LoginPage(eTest);
		Assert.assertEquals(loginPage.validateLoginPageTitle(), "Tegrity Lecture Capture");
		eTest.log(LogStatus.INFO, "Expected title found");
//		reportPass("Title Test");
	}
	
	@Test(priority=2)
	public void validateLogoTest() {
		eTest = eReport.startTest("Validate Logo Test");
		loginPage = new LoginPage(eTest);
		Assert.assertTrue(loginPage.validateLogo());
		eTest.log(LogStatus.INFO, "Expected logo found");
//		reportPass("Validate Logo Test");
	}
	
	@Test(priority=3)
	public void validateCopyrightTextTest() {
		eTest = eReport.startTest("validateCopyrightTextTest");
		loginPage = new LoginPage(eTest);
		try{
			Assert.assertEquals(loginPage.validateCotyrightText(), "© 2019 McGraw-Hill Education. "
					+"All Rights Reserved. U.S. Patent No. 8,276,077. Additional Patents Pending.");
//			reportPass("validateCopyrightTextTest");
		} catch(Throwable t){
//			reportFail("validateCopyrightTextTest FAILED");
			Assert.fail("validateCopyrightTextTest FAILED");
			t.printStackTrace();
		}
		
	}
	
	@Test(priority=4)
	public void userLoginTest() {
		eTest = eReport.startTest("Login Test");
		loginPage = new LoginPage(eTest);
		coursesPage=loginPage.userLogin(prop.getProperty("instructorUsername"), prop.getProperty("instructorPassword"));
		Assert.assertEquals(coursesPage.validateCoursesPageHeading(),"Courses");
		eTest.log(LogStatus.INFO, "Login successful");
//		reportPass("Login Test");
	}
	
	@AfterMethod
	public void tearDown() {
		eReport.endTest(eTest);
		eReport.flush();
		driver.quit();
	}
}








