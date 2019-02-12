package com.FreeCRM.TestBase;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.FreeCRM.Utilities.DemoGetExcelData1;
import com.FreeCRM.Utilities.FreeCrmUtilities;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public WebDriver driver;
	public DemoGetExcelData1 excel;
	public FreeCrmUtilities utilitiesprovider;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void SetSuite() {
		 excel=new DemoGetExcelData1();
		 utilitiesprovider = new FreeCrmUtilities();
		 ExtentHtmlReporter extent= new ExtentHtmlReporter(new File("./Reports/freeCRM "+utilitiesprovider.getcurrentDateTime()+"  .html"));
		 report= new ExtentReports();
		 report.attachReporter(extent);
	}
	
	
@BeforeClass
	
	public void setUp() throws IOException {
		driver=BrowserUtilities.runApplication(driver, FreeCrmUtilities.getObject("Browser_Name"),FreeCrmUtilities.getObject("URL"));
	}
	@AfterClass
	public void shutDown() {
		BrowserUtilities.closeApplication(driver);
	}
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			//utilitiesprovider.captureScreenShot(driver);
			
			try {
				//when our test case will get fail it will capture the screen shot and add to your report
				logger.fail("Test Fail", MediaEntityBuilder.createScreenCaptureFromPath(utilitiesprovider.captureScreenShot(driver)).build());
				
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS) {
			
			try {
				logger.pass("Test pass", MediaEntityBuilder.createScreenCaptureFromPath(utilitiesprovider.captureScreenShot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		
		else if(result.getStatus()==ITestResult.SKIP) {
			
			try {
				logger.skip("Test skip", MediaEntityBuilder.createScreenCaptureFromPath(utilitiesprovider.captureScreenShot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		report.flush();
	}
}
