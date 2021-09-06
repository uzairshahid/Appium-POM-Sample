package TestBase;


import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ObjectsRepo {

	public static AndroidDriver<MobileElement> driver;
	public static DesiredCapabilities capabalities ;
	public static ExtentReports extent;
	public static ExtentTest test;

}
