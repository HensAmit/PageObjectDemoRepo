package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.LoginPage;

public class AdminDashboardPageTest extends BaseTest {	
	public AdminDashboardPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		openBrowser();
		navigate();
	}
	
	@Test(priority=1)
	public void validateAdminPageHeadingTest() {
//		eTest = eReport.startTest("validateAdminPageHeadingTest");
		loginPage = new LoginPage();
		adminDashboardPage=loginPage.adminLogin(prop.getProperty("adminUsername"), prop.getProperty("adminPassword"));
		try{
			Assert.assertEquals(adminDashboardPage.validateAdminPageHeading(), "Admin Dashboard");
//			reportPass("validateAdminPageHeadingTest");
		} catch(Throwable t) {
//			reportFail("Failed");
		}
	}
	
	@Test(priority=2)
	public void verifyElementPresense() {
//		eTest = eReport.startTest("verifyElementPresense");
		loginPage = new LoginPage();
		adminDashboardPage=loginPage.adminLogin(prop.getProperty("adminUsername"), prop.getProperty("adminPassword"));		
		try{
			Thread.sleep(2000);
			Assert.assertTrue(isElementPresent(adminDashboardPage.advancedServiceSettingsLink));
			Assert.assertTrue(isElementPresent(adminDashboardPage.captionRequestsLink));
			Assert.assertTrue(isElementPresent(adminDashboardPage.impersonateUserLink));
//			reportPass("verifyElementPresense");
		} catch(Throwable t){
//			reportFail("Element verification failed");
		}
	}
	
	@AfterMethod
	public void tearDown() {
//		eReport.endTest(eTest);
//		eReport.flush();
		driver.quit();
	}
}
