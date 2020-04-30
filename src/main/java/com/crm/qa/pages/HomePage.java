package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//PageFactory --- OR(Object Repository)
	@FindBy(xpath="//span[contains(text(),'nagendra g') and @class='user-display']")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts') and @class='item-text']")
    WebElement contactsLink;
	
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button")
    WebElement newContactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals') and @class='item-text']")
    WebElement dealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks') and @class='item-text']")
    WebElement tasksLink;
	
	//Initializing the Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitleOfHomePage() {
		return driver.getTitle();
	}
	
	public boolean verifyLoggedInUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink() {
		newContactsLink.click();
		
	}
	
}
