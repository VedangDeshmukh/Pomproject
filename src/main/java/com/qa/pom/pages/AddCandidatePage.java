package com.qa.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.demo.utils.Constants;
import com.qa.demo.utils.ElementUtil;

public class AddCandidatePage {
	
	private WebDriver driver ;
	private ElementUtil elementUtil;
	
	
	
	private By name = By.id("addCandidate_firstName");
	private By lastname = By.id("addCandidate_lastName");
	private By email = By.id("addCandidate_email");
	private By contact = By.id("addCandidate_contactNo");
	private By savebtn = By.id("btnSave");
	
	private By backbtn = By.id("btnBack");
	private By addbtn = By.id("btnAdd");
	
	private By successmessage = By.xpath("//div[@class='message success fadable']");
	
	public AddCandidatePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	
	public boolean addCandidateInfo(String name, String lastname, String email, String contact) {
		elementUtil.doSendKeys(this.name, name);
		elementUtil.doSendKeys(this.lastname, lastname);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.contact, contact);
		
		elementUtil.doClick(savebtn);
		
		String successmessage = elementUtil.doGetText(this.successmessage);
		System.out.println("create candidate success message is :"+successmessage);
		
		if(successmessage.equals(Constants.CREATECANDIDATE_SUCCESS_MESSAGE)) {
			elementUtil.doClick(backbtn);
			elementUtil.doClick(addbtn);
			return true;
		}else {
			return false;
		}
	}
	

}
