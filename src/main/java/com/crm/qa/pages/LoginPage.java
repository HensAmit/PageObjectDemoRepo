package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.adminLoginPages.AdminDashboardPage;
import com.relevantcodes.extentreports.ExtentTest;

public class LoginPage extends BaseTest{
	//constructor
	public LoginPage(ExtentTest eTest) {
		this.eTest=eTest;
		PageFactory.initElements(driver, this);
	}
	//Object repository
	@FindBy(id="TextFieldUserName")
	public WebElement userNameField;
	
	@FindBy(id="TextFieldPassword")
	public WebElement passwordField;
	
	@FindBy(id="ButtonLogin")
	public WebElement loginButton;
	
	@FindBy(xpath="//button[text()='Login as guest']")
	public WebElement guestLoginButton;
	
	@FindBy(id="CopyrightInfo")
	public WebElement copyrightInfo;
	
	@FindBy(id="TegrityLogo")
	public WebElement tegrityLogo;
	
	//Methods
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLogo() {
		return tegrityLogo.isDisplayed();
	}
	
	public String validateCotyrightText() {
		return copyrightInfo.getText();
	}
	
	public CoursesPage userLogin(String username, String password) {
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		click(loginButton);
		return new CoursesPage(eTest);
	}
	
	public AdminDashboardPage adminLogin(String username, String password) {
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		click(loginButton);
		return new AdminDashboardPage(eTest);
	}
	
}
