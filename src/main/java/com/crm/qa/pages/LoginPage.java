package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//span[contains(text(),'Log In')]")
	WebElement preLoginBtn;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	@FindBy(xpath="/html/body/div[1]/header/div/nav/div[2]/div/div[2]/ul/li[1]/a")
	WebElement Signupbtn;
	
	@FindBy(xpath="/html/body/div[1]/header/div/nav/div[2]/div/div[1]/div/a/span[2]") 
	WebElement crmlogo;
	//Initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
		 
	}
	
	public boolean validateCRMImage() {
		return crmlogo.isDisplayed();
		
	}
	public HomePage login(String mail,String pwd) {
		preLoginBtn.click();
		email.sendKeys(mail);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
		
	}

}
