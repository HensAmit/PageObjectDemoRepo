package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.LoginPage;

public class AdminDashboardPageTest extends BaseTest {	
	
	@BeforeMethod
	public void setup() {
		openBrowser();
		navigate();
	}
	
	@Test(priority=1)
	public void validateAdminPageHeadingTest() {
		loginPage = new LoginPage();
		adminDashboardPage=loginPage.adminLogin(prop.getProperty("adminUsername"), prop.getProperty("adminPassword"));
		Assert.assertEquals(adminDashboardPage.validateAdminPageHeading(), "Admin Dashboard");
	}
	
	@Test(priority=2)
	public void verifyElementPresense() {
		loginPage = new LoginPage();
		adminDashboardPage=loginPage.adminLogin(prop.getProperty("adminUsername"), prop.getProperty("adminPassword"));		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(isElementPresent(adminDashboardPage.advancedServiceSettingsLink));
		Assert.assertTrue(isElementPresent(adminDashboardPage.captionRequestsLink));
		Assert.assertTrue(isElementPresent(adminDashboardPage.impersonateUserLink));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
