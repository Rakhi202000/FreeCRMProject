package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	//child class constructor calling parent class constructor. 
	public LoginPageTest() {
		super();
		
	}
	
	@BeforeMethod 
	public void setup() {
		initialization();
		loginPage  = new LoginPage();
		
	}
	
	@Test
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@Test
	public void logoImageTest() {
		boolean flag = loginPage.validateCRMLogo();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void logInTest() throws Exception {
		
		/*Returns home-page object*/
		
		homePage = loginPage.login(prop.getProperty("username"), (prop.getProperty("password")) );	
	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
