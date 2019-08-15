package com.crm.qa.pages.adminLoginPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.BaseTest;
import com.relevantcodes.extentreports.ExtentTest;

public class CaptionRequestsPage extends BaseTest{
	
	public CaptionRequestsPage(ExtentTest eTest) {
		this.eTest = eTest;
		PageFactory.initElements(driver, this);
	}
	
	//Objects
	@FindBy(xpath="//h1[text()='Caption Requests']")
	public WebElement captionRequestsPageHeading;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
