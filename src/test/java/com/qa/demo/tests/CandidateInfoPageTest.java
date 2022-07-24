package com.qa.demo.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.demo.listeners.TestAllureListener;
import com.qa.demo.utils.Constants;
import com.qa.demo.utils.Error;
import com.qa.demo.utils.ExcelUtil;


@Listeners(TestAllureListener.class)
public class CandidateInfoPageTest extends BaseTest {

	
	@BeforeTest
	public void CandidateInfoPageTestSetup() {
		dashboardPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}
	
	@Test(priority = 1)
	public void CandiateInfoPageHeaderTest() {
		candidatesInfoPage = dashboardPage.navigateToCandidatesPage();
		String header = candidatesInfoPage.getCandidateInfoPageHeader();
		System.out.println("CandidateInfo page header is :"+header);
		
		Assert.assertEquals(header, Constants.CANDIDATEINFOPAGE_HEARDER, Error.HEADERMISMATCH_ERROR);
	}
	
	@Test(priority = 2)
	public void addBtnExistTest() {
		candidatesInfoPage = dashboardPage.navigateToCandidatesPage();
		Assert.assertTrue(candidatesInfoPage.isAddButtonisExist(),Error.ELEMENTNOTFOUND_ERROR);
	}
	
	@Test(priority = 3)
	public void candidateInfoTableExistTest() {
		candidatesInfoPage = dashboardPage.navigateToCandidatesPage();
		Assert.assertTrue(candidatesInfoPage.isCandidateInfoTableIsExist(), Error.ELEMENTNOTFOUND_ERROR);
	}
	
	
	public String getEmail() {
		Random random = new Random();
		String email = "autouser" + random.nextInt(4000) + "@gmail.com";
		return email;
	}
	
//	@DataProvider
//	public Object[][] getCandidateData(){
//		return new Object[][] {
//			{"ram","dev","78987657"},
//			{"shan","samu","78978987657"},
//			{"rohit","patle","78988887657"},
//
//		};
//	}
	
	
	/*@DataProvider
	public Object[][] getCandidateData(){
		return ExcelUtil.getTestData("candidateregisterdata");
	}*/
	
	@DataProvider
	public Object[][] getCandidateData(){
		return ExcelUtil.getTestData("candidateregisterdata");
	}
	
	@Test(priority = 4 , dataProvider = "getCandidateData")
	public void addCandiateInfoTest(String name , String lastname,String mobile) {
		candidatesInfoPage = dashboardPage.navigateToCandidatesPage();
		addCandidatePage = candidatesInfoPage.navigateToAddCandidatePage();
		
		Assert.assertTrue(addCandidatePage.addCandidateInfo(name, lastname, getEmail() , mobile));
		
		
	}
	
}
