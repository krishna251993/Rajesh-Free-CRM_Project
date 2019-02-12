package com.FreeCRM.TestCases;

import java.io.IOException;

import javax.swing.text.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.FreeCRM.Utilities.FreeCrmUtilities;

public class LoginTestCase {
	WebDriver driver;
	
	LoginTestCase(WebDriver driver){
		this.driver= driver;
	
		
	}
	
	/*
	@FindBy(name="username")  WebElement uname;

	@FindBy(name="password")  WebElement pw;
	
	@FindBy(xpath="//input[@type='submit']")  WebElement loginbtn;
	*/
	public void Login(String username,String password) throws IOException {
		//driver.findElement(By.xpath(FreeCrmUtilities.getObject("Logg_in_xpath"))).click();
		 driver.findElement(By.name(FreeCrmUtilities.getObject("LoginUsername_name"))).sendKeys(username);
		  driver.findElement(By.name(FreeCrmUtilities.getObject("LoginPassword_name"))).sendKeys(password);
		  driver.findElement(By.xpath(FreeCrmUtilities.getObject("LoginButton_Xpath"))).click();
		
	}

	
}
