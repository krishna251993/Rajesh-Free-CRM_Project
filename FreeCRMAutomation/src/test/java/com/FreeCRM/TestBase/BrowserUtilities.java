package com.FreeCRM.TestBase;

import java.util.concurrent.TimeUnit;

import javax.sql.rowset.WebRowSet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserUtilities {
	public static WebDriver runApplication(WebDriver driver,String browserName,String URL) {
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			 driver= new ChromeDriver();
			
			
		}
		
		else if(browserName.equals("firefoxdriver")) {
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			 driver= new FirefoxDriver();
			
			
		}
		
		else if(browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "./Driver/IEDriverServer.exe");
			 driver= new InternetExplorerDriver();
			
			
		}
		
		else {
			System.out.println("unable to open the driver");
		}
		
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void closeApplication(WebDriver driver) {
	
		driver.quit();
	}

}
