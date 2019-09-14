package com.crm.qa.util;

import com.relevantcodes.extentreports.LogStatus;

public class LogStatusExtent {
	private LogStatusExtent(){
		
	}
	
	public static void pass(String message){
		ExtentManager.logger.log(LogStatus.PASS, message);
	}
	
	public static void fail(String message){
		ExtentManager.logger.log(LogStatus.FAIL, message);
		
	}
	
	public static void info(String message){
		ExtentManager.logger.log(LogStatus.INFO, message);
	}
	
	public static void skip(String message){
		ExtentManager.logger.log(LogStatus.SKIP, message);
	}

}
