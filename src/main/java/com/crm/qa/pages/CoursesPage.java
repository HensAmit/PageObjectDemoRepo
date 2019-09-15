package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.crm.qa.base.BaseTest;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CoursesPage extends BaseTest{
	
	//constructor
	public CoursesPage() {
//		this.eTest = eTest;
		PageFactory.initElements(driver, this);
	}
		
	//Objects****************************************
	@FindBy(id="CoursesHeading")
	public WebElement coursesPageHeading;
	
	@FindBy(id="ReportsLink")
	public WebElement reportsLink;
	
	@FindBy(id="SignOutLink")
	public WebElement signOutLink;
	
	@FindBy(id="ActiveCourses")
	public WebElement activeCoursesTab;
	
	@FindBy(id="PastCourses")
	public WebElement pastCoursesTab;
	
	@FindBy(id="PublicCourses")
	public WebElement publicCoursesTab;
	
	//Methods*****************************************
	public String validateCoursesPageTitle() {
		return driver.getTitle();
	}
	
	public String validateCoursesPageHeading() {
		return coursesPageHeading.getText();
	}
	
	public RecordingsListPage clickOnCourse(String courseName) {
		driver.findElement(By.xpath("//a[contains(text(),'"+courseName+"')]")).click();
//		eTest.log(LogStatus.INFO, "Clicked on the course: "+courseName);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("RecordingsTab")));
		try{
			Thread.sleep(5000);
		} catch(Throwable t){
			t.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(), "Tegrity - "+courseName);
		return new RecordingsListPage();
	}
	
	
	
	
	
	
	
	
	
}
