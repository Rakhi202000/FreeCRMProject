package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase() {
		//Default constructor does not have return type. We are setting properties ion the default constructor.
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\rmodi\\eclipse-workspace\\FreeCRMSelenium\\FreeCRMSelenium\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")){
				
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\rmodi\\Chrome\\chromedriver.exe");
				driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\rmodi\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if (browserName.equals("safari")) {
			driver = new SafariDriver();	
		}
		else if (browserName.equals("ie")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\rmodi\\IEDriverServer_x64_3.9.0\\IEDriverServer.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
		driver.get(prop.getProperty("url"));
	}

}
