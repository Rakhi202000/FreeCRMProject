package com.LiveSafe.events.page;



import com.LiveSafe.qa.base.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListEvents extends TestBase {

	//Page factory for Add and refresh
	@FindBy(xpath="//button/mat-icon[contains(text(),'add')]")
	@CacheLookup
	WebElement addButton;
	
	@FindBy(xpath="//button/mat-icon[contains(text(),'refresh')]")
	@CacheLookup
	WebElement refreshButton;
	
	@FindBy(css="input#mat-input-0")
	@CacheLookup
	WebElement titleEntry;
	
	@FindBy(css="input#mat-input-1")
	@CacheLookup
	WebElement subTitleEntry;
	
	@FindBy(css="textarea#mat-input-2")
	@CacheLookup
	WebElement descriptionEntry;
	
	@FindBy(xpath="//div/button[contains(text(),'Ok')]")
	@CacheLookup
	WebElement okButton;
	
	@FindBy(xpath="//div/button[contains(text(),'Cancel')]")
	@CacheLookup
	WebElement cancelButton;
	
	
	
	//Initialized the pageObject
	public ListEvents() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Add events 
	public void addEvents() {
		addButton.click();
	}
	
	
	//Pass records in the eventUI. 
	public void addEvents(String title, String subTitle, String description) throws InterruptedException {
		titleEntry.sendKeys(title);
		Thread.sleep(1000);
		subTitleEntry.sendKeys(subTitle);
		Thread.sleep(1000);
		descriptionEntry.sendKeys(description);
		Thread.sleep(1000);
		okButton.click();
		
	}

	
}
