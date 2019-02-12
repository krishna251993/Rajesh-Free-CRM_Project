package com.FreeCRM.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FreeCRM.TestBase.BaseClass;
import com.FreeCRM.TestBase.BrowserUtilities;
import com.FreeCRM.Utilities.DemoGetExcelData1;
import com.FreeCRM.Utilities.FreeCrmUtilities;

public class LoginApplication extends BaseClass {
	
	
	
  @Test
  public void login() throws IOException {
	  
	 logger=report.createTest("login to CRM");
	  LoginTestCase login= new LoginTestCase(driver);
	  logger.info("starting the application");
	  
	  login.Login(excel.getExcelData("Login Credential", 1, 0),excel.getExcelData("Login Credential", 1, 1));
	  logger.pass("logging done successfully");
	
  }
  
  
  @Test
  public void logout() throws IOException {
	  
	 logger=report.createTest("logout to CRM");
	  
	  
	  
	
	  logger.fail("loggout fail");
	
  }
}
