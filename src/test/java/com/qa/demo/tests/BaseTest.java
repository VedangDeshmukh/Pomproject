package com.qa.demo.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.demo.factory.DriverFactory;
import com.qa.pom.pages.AddCandidatePage;
import com.qa.pom.pages.CandidatesInfoPage;
import com.qa.pom.pages.DashboardPage;
import com.qa.pom.pages.LoginPage;

public class BaseTest {
	
	
	WebDriver driver;
	DriverFactory df;
	Properties prop;
	
	
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	CandidatesInfoPage candidatesInfoPage;
	AddCandidatePage addCandidatePage;
	
	@BeforeTest
	public void setup() {
		
		df= new DriverFactory();
		prop = df.initProperties();
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
		
	}
	
	
//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}

}
