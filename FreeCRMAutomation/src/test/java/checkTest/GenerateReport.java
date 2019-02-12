package checkTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class GenerateReport {
	@Test

	public void login() throws IOException {
		System.out.println("Login to FreeCRM");
		ExtentHtmlReporter HtmlReporter= new ExtentHtmlReporter("./Reports/FreeCrMLogin.html");
		
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(HtmlReporter);
		
		ExtentTest loger=extent.createTest("Login Test");
		loger.log(Status.INFO, "LoginTest");
		loger.log(Status.PASS, "Title Varified");
		loger.log(Status.FAIL, "Login Test Case is failed");
		extent.flush();
		ExtentTest loger2=extent.createTest("Logout Test");
		loger2.log(Status.INFO, "Logout test");
		loger2.log(Status.FAIL, "Fail to logout");
		loger2.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("H:\\Framework\\FreeCRMAutomation\\ScreenShot\\FreeCRM02_08_2019 21_30_52.png").build());
		
		//loger2.addScreenCaptureFromPath("H:\\Framework\\FreeCRMAutomation\\ScreenShot\\02_08_2019 06_15_37.png");
		
		extent.flush();
		
		 
		
	}

}
