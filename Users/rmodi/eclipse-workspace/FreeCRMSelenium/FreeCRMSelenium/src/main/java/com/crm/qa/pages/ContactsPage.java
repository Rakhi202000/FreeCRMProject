package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends TestBase {
	
	ContactsPage contactsPage;
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;

	@FindBy(xpath="//input[@name='cs_name']")
	WebElement nameTextBox;

	@FindBy(xpath="//input[@name='cs_submit' and @value='Search']")
	WebElement seatchButton;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement setCompany;
	
	@FindBy(xpath="//form[@name='contactForm']/table//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	//constructor for ContactsPage, will call initi method to initialize all the WebElements. 
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel() {

		return contactsLabel.isDisplayed(); //Verify if system is on contacts page. 
	}
	
	public String compareNameCase(String name) {
		String actualName = null;
		List<WebElement> uiName =driver.findElements(By.xpath("//a[@context='contact']"));
		for(int i = 0; i < uiName.size(); i++) {
				actualName = uiName.get(i).getText();
				System.out.println(actualName);
			if(actualName.equalsIgnoreCase(name)) {
				break;
			}
			
		}
		System.out.println(actualName);
		return actualName;
	}
	
	
	public void enterName(String name) 
	{
		nameTextBox.sendKeys(name);
	}

	public void selectNameInitials(String name) {
		char c = name.toUpperCase().charAt(0);
		driver.findElement(By.xpath("//td[@class='a2z' and text()='"+c+"']"));
	}

	public void selectNameCheckbox(String uiName) {
		
		driver.findElement(By.xpath("//a[text()='"+uiName+"']/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
	}

	public void clickSearchButton() {
		seatchButton.click();
	}

	public void createNewContact(String title, String fName, String lName, String company) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		setCompany.sendKeys(company);
		saveBtn.click();
	}



}
