package com.qa.pom.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.demo.utils.Constants;
import com.qa.demo.utils.ElementUtil;

public class DashboardPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By dashboardheader = By.xpath("//h1[text()='Dashboard']");
	private By quicklaunclist = By.xpath("//div[@class='quickLaunge']//span");

	private By quicklaunchicon = By.xpath("//div[@class='quickLaunge']//img");
	private By mainmenus = By
			.xpath("//ul[@id='mainMenuFirstLevelUnorderedList']//li[@class='main-menu-first-level-list-item']/a");

	private By recruitement = By.linkText("Recruitment");

	private By candidate = By.id("menu_recruitment_viewCandidates");

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	
	public String getDashboardPageHeader() {
		return elementUtil.doGetText(dashboardheader);
	}
	
	public String getDashboardPageUrl() {
		return elementUtil.waitForUrlIs(Constants.DEFAULTIMEOUT, Constants.DASHBOARDPAGE_URL);
	}

	public List<String> getQuickLaunchesLinks() {
		return elementUtil.getLinksTextList(quicklaunclist);
	}

	public boolean checkQuickLaunchesIconsAreDisplayed() {

		boolean flag = false;
		List<WebElement> ele = elementUtil.getElements(quicklaunchicon);
		for (WebElement e : ele) {
			flag = e.isDisplayed();
		}

		if (flag == true) {
			return flag;
		} else {
			return false;
		}

	}

	public List<String> getMainMenuList() {
		return elementUtil.getLinksTextList(mainmenus);
	}

	
	public CandidatesInfoPage navigateToCandidatesPage() {

		elementUtil.twoLevelMenuhandel(recruitement, candidate);

		return new CandidatesInfoPage(driver);
	}

}
