package com.crm.qa.util;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	public static ExtentReports getInstance(){
		Date date = new Date();
		String modifiedDate=date.toString().replaceAll(":", "_").replaceAll(" ", "_");
		String fileName=modifiedDate+".html";
		String filePath="reports//"+fileName;
		ExtentReports report = new ExtentReports(filePath,false,DisplayOrder.NEWEST_FIRST);
		File configFile = new File("ReportsConfig.xml");
		report.loadConfig(configFile);		
		report.addSystemInfo("Environment", "QALive").addSystemInfo("TestNG Version", "6.14.3");		
		return report;
	}
}
