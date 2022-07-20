package com.qa.demo.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.demo.listeners.TestAllureListener;
import com.qa.demo.utils.Constants;
import com.qa.demo.utils.Error;

@Listeners(TestAllureListener.class)
public class DashboardPageTest extends BaseTest {

	@BeforeClass
	public void DashboardPageTestSetup() {
		dashboardPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}
	
	
	@Test(priority = 1)
	public void dashbaordPageUrlTest() {
		String dashboardpageurl = dashboardPage.getDashboardPageUrl();
		System.out.println("Dashbaord page url is :"+dashboardpageurl);
		
		Assert.assertEquals(dashboardpageurl, Constants.DASHBOARDPAGE_URL, Error.URL_MISMATCH_ERROR);
	}
	
	@Test(priority = 2)
	public void dashbaordPageHeaserTest() {
		 String header = dashboardPage.getDashboardPageHeader();
		 System.out.println("Dashboard page header is:"+header);
	}
	
	@Test(priority = 3)
	public void mainMenuListTest() {
		List<String> menulist = dashboardPage.getMainMenuList();
		System.out.println("main menu list is :"+menulist);
		
		Assert.assertEquals(menulist, Constants.MAINMENULIST);
	}
	
	@Test(priority = 4)
	public void quickLaunchListTest() {
		List<String> quicklist = dashboardPage.getQuickLaunchesLinks();
		System.out.println("quick launc list is :"+quicklist);
		
		Assert.assertEquals(quicklist, Constants.QUCIKLAUNCHLIST);
	}
	
	

}
