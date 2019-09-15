package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.crm.qa.pages.CoursesPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.RecordingsListPage;
import com.crm.qa.pages.adminLoginPages.AdminDashboardPage;
import com.crm.qa.util.DataUtil;
import com.crm.qa.util.ExtentManager;
import com.crm.qa.util.LogStatusExtent;
import com.crm.qa.util.MyXLSReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop;
//	public ExtentReports eReport;
//	public ExtentTest eTest;
	public static WebDriverWait wait;
	public MyXLSReader myXlsReader;
	public LoginPage loginPage;
	public CoursesPage coursesPage;
	public AdminDashboardPage adminDashboardPage;
	public RecordingsListPage recordingsListPage;
	//constructor
	public BaseTest() {
//		if(eReport==null) {
//			eReport = ExtentManager.getInstance();
//		}
		try {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src//test//resources//config.properties");
		prop.load(fis);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Methods
//	public static void initialization(){
//		openBrowser();
//	}
	
	public static void openBrowser() {
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver", "drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		} else if(browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "drivers//IEDdriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		wait = new WebDriverWait(driver,180);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWaitTime")), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTime")), TimeUnit.SECONDS);
//		LogStatusExtent.info(browserName+" browser is opened successfully");
	}
	
	public static void navigate() {
		String url=prop.getProperty("url");
		driver.get(url);
//		LogStatusExtent.info("Navigated to : "+url);
		try {
		Thread.sleep(3000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isElementPresent(WebElement element) {
		return element.isDisplayed();
	}
	
	public static void click(WebElement element){
		element.click();
		LogStatusExtent.info("Clicked on element: "+element.getText()+" ---> "+element.toString());
	}
	
//	public void reportPass(String testName){
//		eTest.log(LogStatus.PASS, testName+" GOT PASSED");
//	}
//	
//	public void reportFail(String message){		
//		eTest.log(LogStatus.FAIL, message);
//		takeScreenshot();
//		Assert.fail(message);		
//	}
	
	public static void takeScreenshot(){
		Date d = new Date();
		String fileName=d.toString().replaceAll(":", "_").replaceAll(" ", "_")+".png";
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(scrFile, new File("screenshots//"+fileName));
		} catch(Throwable t){
			t.printStackTrace();
		}
//		eTest.log(LogStatus.INFO, eTest.addScreenCapture(System.getProperty("user.dir")+"//screenshots//"+fileName));
		ExtentManager.logger.log(LogStatus.INFO, ExtentManager.logger.addScreenCapture(System.getProperty("user.dir")+"//screenshots//"+fileName));
	}
	
	public Object[][] dataProvider(String testcaseName, String sheetName){
		Object[][] obj = null;
		myXlsReader = new MyXLSReader(prop.getProperty("TestDataFilePath"));
		try {
			  obj = DataUtil.getTestData(myXlsReader, testcaseName, sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	
}
