package com.FreeCRM.Utilities;

import java.io.File;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;




//capture the screen shot,frame handle,new Window handle,alert handle
public class FreeCrmUtilities {
	public static Properties pro;
	public static void LoadData() throws IOException {
		pro= new Properties();
		File f= new File("./Element Locator/Locator.properties");
		FileReader fr= new FileReader(f);
		pro.load(fr);
		
		
	}
	public static String getObject(String Data) throws IOException {
		LoadData();
		String data=pro.getProperty(Data);
		return data;
	}
	
	public String captureScreenShot(WebDriver driver) {
		String screenShotPath=System.getProperty("user.dir")+"/ScreenShot/FreeCRM"+getcurrentDateTime()+".png";
		
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(screenShotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("unable to capture  screenShot"+e.getMessage());
		}
		return screenShotPath;
	}
	
	public String getcurrentDateTime() {
		DateFormat custom_format= new SimpleDateFormat("MM_dd_yyyy HH_mm_ss");
		Date currentDate= new Date();
		return custom_format.format(currentDate);
	}

	
	
	
	
	
	
	
	
	
}
