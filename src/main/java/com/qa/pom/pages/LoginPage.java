package com.qa.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.demo.utils.Constants;
import com.qa.demo.utils.ElementUtil;

import io.qameta.allure.Step;



public class LoginPage {
	
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	
	private By usernamefiled = By.id("txtUsername");
	private By passwordfiled = By.id("txtPassword");
	private By loginbtn = By.id("btnLogin");
	private By forgetLink = By.id("forgotPasswordLink");
	
	private By logo = By.id("divLogo");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	
	@Step("getting the login page url....")
	public String getLoginPageUrl() {
		return elementUtil.waitForUrlConatain(Constants.LOGINPAGE_URL, Constants.DEFAULTIMEOUT);
	}
	
	@Step("getting the login page title....")
	public String getLoginPageTitle() {
		return elementUtil.waitForTitleIs(Constants.DEFAULTIMEOUT, Constants.LOGINPAGE_TITLE);
	}
	
	@Step("checking forget link is available on UI")
	public boolean isForgetLinkExist() {
		return elementUtil.doCheckIsDisplayed(forgetLink);
	}
	
	@Step("checking logo is displayed on UI")
	public boolean isLogoIsDisplayed() {
		return elementUtil.doCheckIsDisplayed(logo);
	}
	
	@Step("login to the application with username:{0} and password:{1}")
	public DashboardPage doLogin(String username, String password) {
		
		elementUtil.doSendKeys(usernamefiled, "Admin");
		elementUtil.doSendKeys(passwordfiled, "admin123");
		elementUtil.doClick(loginbtn);
		
		return new DashboardPage(driver);

	}
	

}
