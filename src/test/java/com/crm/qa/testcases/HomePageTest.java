package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage=new LoginPage();
		contactsPage=new ContactsPage();
		homePage=new HomePage();
		homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyTitleOfHomePageTest() {
		String homePagetitle=homePage.verifyTitleOfHomePage();
		Assert.assertEquals(homePagetitle, "Cogmento CRM","Home page title is not matched ");
	}
	
	@Test(priority=2)
	public void verifyLoggedInUserNameTest() {
		Assert.assertTrue(homePage.verifyLoggedInUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		contactsPage=homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
