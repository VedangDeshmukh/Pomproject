package com.qa.demo.tests;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.demo.listeners.TestAllureListener;
import com.qa.demo.utils.Constants;
import com.qa.demo.utils.Error;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Epic("Login Page Featutre")
@Story("LP:101 Login to the application")
@Listeners(TestAllureListener.class)
public class LoginPageTest extends BaseTest {
	
	@Description("Login Page url test....")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 1)
	public void loginPageUrlTest() {
		String loginpaheurl = loginPage.getLoginPageUrl();
		System.out.println("login page url is:"+loginpaheurl);
		
		Assert.assertEquals(loginpaheurl, Constants.LOGINPAGE_URL,Error.URL_MISMATCH_ERROR);
	}
	
	
	@Description("Login Page title test....")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 2)
	public void loginPageTitleTest() {
		String logintitle = loginPage.getLoginPageTitle();
		System.out.println("login page title is:"+logintitle);
		
		Assert.assertEquals(logintitle, Constants.LOGINPAGE_TITLE, Error.TITLE_MISMATCH_ERROR);
	}
	
	
	@Description("Forget Link exist test....")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 3)
	public void isForgetLinkExistTest() {
		
		Assert.assertTrue(loginPage.isForgetLinkExist(), Error.ELEMENTNOTFOUND_ERROR);
	}
	
	
	@Description("Logo is exist test....")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 4)
	public void isLogoisExistTest() {
		Assert.assertTrue(loginPage.isLogoIsDisplayed(),Error.ELEMENTNOTFOUND_ERROR);
	}
	
	
	@Description("Login to the application test....")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 5)
	public void doLoginTest() {
		
		dashboardPage= loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		String header = dashboardPage.getDashboardPageHeader();
		System.out.println("Dashboard page header is :"+header);
		
		Assert.assertEquals(header, Constants.DASHBOARDPAGE_HEARDER, Error.HEADERMISMATCH_ERROR);
		
	}
	

}
