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
	//We are extending from TestBase, as parent class. 
	//Initialized the variables
	HomePage homePage;
	TestUtil testUtil; 
	ContactsPage contactsPage;
	LoginPage loginPage;

	//we need to call superclass constructor hence test cases are failing. 
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		homePage = new HomePage();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//we need to switch to a frame in order to get to contacts page. 
		testUtil.switchToMainFrame();
		contactsPage = homePage.clickOnContactsLink();
	}

	@Test(enabled=false)
	public void verifyContactsLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}

	@Test(enabled=false)
	public void searchName() {
		String name = prop.getProperty("name");
		System.out.println(name);
		
		contactsPage.enterName(name);
		contactsPage.clickSearchButton();
		String uiName = contactsPage.compareNameCase(name);
		System.out.println(uiName);
		contactsPage.selectNameCheckbox(uiName);
	}
	
	@DataProvider
	public Object [][] getCRMTestData() {
		Object data [] [] = TestUtil.getTestData(prop.getProperty("sheetname"));
		return data;
	}
	
	@Test(priority=1, dataProvider="getCRMTestData")
	public void addNewContactTest(String titile, String fName, String lName, String comp) {
		contactsPage = homePage.clickOnNewContactsLink();
		//contactsPage.createNewContact("Mrs.", "Rakhi", "Kotmel", "Google");
		contactsPage.createNewContact(titile, fName, lName, comp);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
