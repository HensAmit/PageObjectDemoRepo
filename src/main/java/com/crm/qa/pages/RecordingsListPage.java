package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.BaseTest;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RecordingsListPage extends BaseTest{
	//constructor
	public RecordingsListPage() {
//		this.eTest = eTest;
		PageFactory.initElements(driver, this);
	}
	
	//Objects*****************************************************************************************
	@FindBy(xpath="//a[@title='Courses']")
	public WebElement coursesBreadcrumb;
	
	@FindBy(id="RecordingsTab")
	public WebElement recordingsTab;
	
	@FindBy(id="AdditionalContentTab")
	public WebElement additionalContentTab;
	
	@FindBy(id="TestsTab")
	public WebElement testsTab;
	
	@FindBy(id="CheckAll")
	public WebElement checkAllRecordings;
	
	@FindBy(id="CourseTask")
	public WebElement courseTaskDropdown;
	
	@FindBy(id="RecordingTasks")
	public WebElement recordingTaskDropdown;
	
	@FindBy(id="AddAdditionalContentFile")
	public WebElement addAdditionalContentFile;
	
	@FindBy(id="AddAdditionalContentLink")
	public WebElement addAdditionalContentLink;
	
	@FindBy(id="SortingTasks")
	public WebElement viewDropdown;
	
	@FindBy(id="MoveTask2")
	public WebElement moveRecordingTask;
	
	@FindBy(id="courseSearchText")
	public WebElement courseSearchTextbox;
	
	@FindBy(xpath="//input[@value='Search']")
	public WebElement searchButton;
	
	@FindBy(id="MoveButton")
	public WebElement moveButton;

	@FindBy(id="CancelButton")
	public WebElement cancelButton;
	
	@FindBy(id="CopyTask2")
	public WebElement copyRecordingTask;
	
	@FindBy(id="CopyButton")
	public WebElement copyButton;
	
	@FindBy(id="ModalDialogHeader")
	public WebElement popupHeading;

	@FindBy(xpath="//button[text()='Ok']")
	public WebElement okButton;
	
	
	
	//Methods******************************************************************************************
	public void checkAnyRecording(String recordingTitle) {
		driver.findElement(By.xpath("//input[@title='Select recording "+recordingTitle+"']")).click();
//		eTest.log(LogStatus.INFO, "Selected the recording: "+recordingTitle);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
