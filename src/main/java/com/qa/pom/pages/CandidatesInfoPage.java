package com.qa.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.demo.utils.ElementUtil;

public class CandidatesInfoPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By header = By.xpath("//div[@class='head']/h1");
	private By addbtn = By.id("btnAdd");
	
	private By candidateinfotable = By.id("resultTable");
	
	
	
	public CandidatesInfoPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	
	public String getCandidateInfoPageHeader() {
		return elementUtil.doGetText(header);
	}
	
	public boolean isAddButtonisExist() {
		return elementUtil.doCheckIsDisplayed(addbtn);
	}
	
	public boolean isCandidateInfoTableIsExist() {
		return elementUtil.doCheckIsDisplayed(candidateinfotable);
	}
	
	public AddCandidatePage navigateToAddCandidatePage() {
		elementUtil.doClick(addbtn);
		return new AddCandidatePage(driver);
	}
	
}
