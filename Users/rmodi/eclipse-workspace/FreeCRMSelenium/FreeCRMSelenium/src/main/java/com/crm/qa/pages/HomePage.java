package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath="//td[contains(text(),'Naveen K')]")
	WebElement userName;

	@FindBy(xpath="//a[contains(@title, 'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath="//a[contains(@title, 'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath="//a[contains(@title, 'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(@title, 'New Contact')]")
	WebElement newContactsLink;

	//Initialized the HomePage constructor to load WebElements. 

	public HomePage() {
		PageFactory.initElements(driver, this);//Here we are passing homePage object. 
		
	}
	//Home page methods
	public String verifyHomeTitle() {
		//currently driver will on home page hence calling driver.getTitle()
		return driver.getTitle();
	}
	
	public String verifyUserName() {
		return userName.getText();
	}
	
	//driver will land on home page or deals or Tasks page. 
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksPage() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public ContactsPage clickOnNewContactsLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
		return new ContactsPage();
}

}
