package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	String sheetName="contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = new HomePage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
       
	}

	@Test(priority = 1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}

	@Test(priority = 2)
	public void selectSingleContactTest() {
		e_driver.navigate().refresh();
		e_driver.navigate().refresh();

		contactsPage.selectContactsByName("Tanshi Sunanda");

	}

	@Test(priority = 3)
	public void selectMultipleContactsTest() {
		e_driver.navigate().refresh();
		e_driver.navigate().refresh();

		contactsPage.selectContactsByName("Bhavik Surya");
		contactsPage.selectContactsByName("Tanshi Sunanda");
	}
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String category,String firstname,String lastname,String company)  {
		
		homePage.clickOnNewContactLink();
		e_driver.navigate().refresh();
		e_driver.navigate().refresh();
		e_driver.navigate().refresh();
        //contactsPage.createNewContact("Customer", "K", "Narayana", "Google");
		contactsPage.createNewContact(category,firstname,lastname,company);
	}

	
	
	 @AfterMethod 
	 public void tearDown() { 
		 driver.quit(); 
		 
	 }
	 
	  
	 
}
