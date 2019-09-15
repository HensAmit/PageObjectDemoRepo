package com.crm.qa.mintTestCases;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class MINT1234 extends BaseTest{
	
	public MINT1234(){
		super();
	}
		
	@DataProvider
	public Object[][] dataProvider(){
		return dataProvider("MINT1234", "TESTDATA");
	}
	
	@Test(dataProvider="dataProvider")
	public void mint1234(HashMap<String,String> map){
		
//		eTest = eReport.startTest("MINT1234");
		openBrowser();
//		eTest.log(LogStatus.INFO, "Browser opened");
		navigate();
//		eTest.log(LogStatus.INFO, "Navigated to "+prop.getProperty("url"));
		
		loginPage = new LoginPage();
		coursesPage = loginPage.userLogin(prop.getProperty("instructorUsername"), prop.getProperty("instructorPassword"));
		recordingsListPage = coursesPage.clickOnCourse(map.get("CopyFromCourse"));
		recordingsListPage.checkAnyRecording(map.get("RecordingToCopy"));
		click(recordingsListPage.recordingTaskDropdown);
		click(recordingsListPage.copyRecordingTask);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[text()='"+map.get("CopyToCourse")+"']")));
		recordingsListPage.courseSearchTextbox.sendKeys(map.get("CopyToCourse"));
//		eTest.log(LogStatus.INFO, "Destination course entered in searchbox");
		click(recordingsListPage.searchButton);
		click(driver.findElement(By.xpath("//option[text()='"+map.get("CopyToCourse")+"']")));
		click(recordingsListPage.copyButton);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Ok']")));
		if(recordingsListPage.popupHeading.getText().equals("Success")) {
			click(recordingsListPage.okButton);
//			reportPass("MINT1234");
		} else {
//			reportFail("MINT1234 FAILED");
		}		
	}
	@AfterMethod
	public void tearDown(){
//		eReport.endTest(eTest);
//		eReport.flush();
		driver.quit();
	}
}
