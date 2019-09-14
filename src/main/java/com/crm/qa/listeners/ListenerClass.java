package com.crm.qa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.crm.qa.util.ExtentManager;
import com.crm.qa.util.LogStatusExtent;

public class ListenerClass implements ITestListener{
	public static String testcaseName;

	public void onTestStart(ITestResult result) {
		testcaseName = result.getName();
		ExtentManager.logger = ExtentManager.report.startTest(testcaseName);
		LogStatusExtent.info("Testcase "+testcaseName+" is started successfully");
	}

	public void onTestSuccess(ITestResult result) {
		LogStatusExtent.pass(testcaseName+" passed successfully");
		ExtentManager.report.endTest(ExtentManager.logger);		
	}

	public void onTestFailure(ITestResult result) {
		LogStatusExtent.fail(testcaseName+" HAS FAILED");
		ExtentManager.report.endTest(ExtentManager.logger);
	}

	public void onTestSkipped(ITestResult result) {
		LogStatusExtent.skip(testcaseName+" has been skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
