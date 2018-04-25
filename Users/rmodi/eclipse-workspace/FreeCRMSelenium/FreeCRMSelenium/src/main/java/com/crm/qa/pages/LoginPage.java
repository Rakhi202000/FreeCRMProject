package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
//Page factory 
	@FindBy(name="username")
	@CacheLookup
	WebElement username;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	@CacheLookup
	WebElement submit;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	@CacheLookup
	WebElement signUp;
	
	@FindBy (xpath="//img[contains(@class, 'img-responsive')]")
	@CacheLookup
	WebElement pageImage;
	
	//Create default constructor of the LoginPage
	//Initialize the page objects. 
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	
	public boolean validateCRMLogo() {
		return pageImage.isDisplayed();
	}
	
	//We are landing on home page hence the Method is returning homepage class object
	public HomePage login(String un, String pw) throws InterruptedException {
		
		username.sendKeys(un);
		password.sendKeys(pw);
	
		Thread.sleep(2000);
		submit.click();
		
		return new HomePage();
		
	}


}


