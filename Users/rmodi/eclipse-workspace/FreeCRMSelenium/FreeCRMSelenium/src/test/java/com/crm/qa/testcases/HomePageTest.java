package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil = new TestUtil();;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	public HomePageTest() {
		super();
	}

	@BeforeMethod 
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToMainFrame();
		//Since extends TestBase prop property are inherited by TestBase class. 
	}

	//Note how everything is chained. 
	@Test(priority=1)
	public void verifyHomePageTitletest() {
		String homePageTitle = homePage.verifyHomeTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home Page Title not matched");
	}
	@Test(priority=2)
	public void verifyUserNameTest() {
		String uName = homePage.verifyUserName();
		Assert.assertEquals(uName, "User: Naveen K", "User name is not present");
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		
		contactsPage = homePage.clickOnContactsLink(); //This will give you control over contacts page
	}
	
	@Test(priority=4)
	public void verifyDealsLinkTest() {
		
		dealsPage = homePage.clickOnDealsLink();
	}
	
	@Test(priority=5)
	public void verifyTasksLinkTest() {
		
		tasksPage = homePage.clickOnTasksPage();
	}

	@AfterMethod 
	public void tearDown() 
	{ 
		driver.quit();
	}


}
