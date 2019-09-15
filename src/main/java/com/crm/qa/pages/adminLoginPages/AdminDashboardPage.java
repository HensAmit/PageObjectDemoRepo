package com.crm.qa.pages.adminLoginPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.BaseTest;
import com.relevantcodes.extentreports.ExtentTest;

public class AdminDashboardPage extends BaseTest{
	//constructor
	public AdminDashboardPage() {
//		this.eTest = eTest;
		PageFactory.initElements(driver, this);
	}
	
	//objects
	@FindBy(id="Admin Dashboard")
	public WebElement adminPageHeading;
	
	@FindBy(xpath="//a[text()='Caption Requests']")
	public WebElement captionRequestsLink;
	
	@FindBy(xpath="//a[text()='Impersonate User']")
	public WebElement impersonateUserLink;
	
	@FindBy(xpath="//a[text()='View Course List']")
	public WebElement viewCourseListLink;
	
	@FindBy(xpath="//a[text()='Advanced Service Settings']")
	public WebElement advancedServiceSettingsLink;
	
	//Methods
	public String validateAdminPageHeading() {
		return adminPageHeading.getText();
	}
	
	
	
	
	
	
	
}
