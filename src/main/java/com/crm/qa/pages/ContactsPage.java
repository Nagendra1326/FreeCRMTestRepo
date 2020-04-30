package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	

	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[1]/div/div/input")
	WebElement firstName;
	
	@FindBy(xpath = "//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[2]/div/div/input")
	WebElement lastName;
	
	@FindBy(xpath = "//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/div/div/input")
	WebElement company;
	
	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")
	WebElement saveBtn;
	
	
	//Initializing the Page Objects
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel(){
		
		return contactsLabel.isDisplayed();
		
	}
	
	public void clickOnView() {
		
		driver.findElement(By.xpath("//button[contains(text(),'Show Filters')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Hide Filters')]")).click();
	}
	
	public void selectContactsByName(String name)   {
		
		driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]")).click();
	}
	

	
	public void createNewContact(String title,String ftName,String ltName,String comp) {
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		//Select select=new Select(driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[4]/div[2]/div/div")));
		//select.selectByVisibleText(title);
		
		driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[4]/div[2]/div/div/div[1]")).click();
		List<WebElement> list= driver.findElements(By.xpath("//div[@name='category']//div//div//span"));
		   System.out.println(list.size());
		   
		   for(int i=0;i<list.size();i++)
		   {
			   
			   System.out.println(list.get(i).getText());
			   if(list.get(i).getText().equals(title))
			   {
				   list.get(i).click();
			   }
		   }
		saveBtn.click();
	}
	
	
}