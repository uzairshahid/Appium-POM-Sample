package TestBase;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ReusableComponents.PropertiesOperations;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestBase extends ObjectsRepo {
//	AndroidDriver<MobileElement> driver = null;
//	DesiredCapabilities capabalities = new DesiredCapabilities();

	public void LaunchApplication() throws Exception {
		AndroidDriver<MobileElement> driver = null;
//		DesiredCapabilities capabalities = new DesiredCapabilities();
//    	String deviceName = PropertiesOperations.getPropertyValueByKey("deviceName");
//    	String udid = PropertiesOperations.getPropertyValueByKey("udid");
//    	String platformName =PropertiesOperations.getPropertyValueByKey("deviceName");
//    	String platformVersion = PropertiesOperations.getPropertyValueByKey("platformVersion");
//    	String appPackage =PropertiesOperations.getPropertyValueByKey("appPackage");
//    	String appActivity =PropertiesOperations.getPropertyValueByKey("appActivity");
//    	String noReset = PropertiesOperations.getPropertyValueByKey("noReset");
		capabalities.setCapability("deviceName", PropertiesOperations.getPropertyValueByKey("deviceName"));
		capabalities.setCapability("udid", PropertiesOperations.getPropertyValueByKey("udid"));
		capabalities.setCapability("platformName", PropertiesOperations.getPropertyValueByKey("deviceName"));
		capabalities.setCapability("platformVersion", PropertiesOperations.getPropertyValueByKey("platformVersion"));
		capabalities.setCapability("appPackage", PropertiesOperations.getPropertyValueByKey("appPackage"));
		capabalities.setCapability("appActivity", PropertiesOperations.getPropertyValueByKey("appActivity"));
		capabalities.setCapability("automationName", PropertiesOperations.getPropertyValueByKey("automationName"));
		capabalities.setCapability("noReset", PropertiesOperations.getPropertyValueByKey("noReset"));
		capabalities.setCapability("skipDeviceInitialization", true);
		capabalities.setCapability("skipServerInstallation", true);

		

//		read property file and get browser name and url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver = new AndroidDriver<>(new URL(PropertiesOperations.getPropertyValueByKey("appiumURL")), capabalities);

	}

	@BeforeSuite // it will excecute before each test method with in current class
	public void setupMethod() throws Exception {
		LaunchApplication();
	}

	@AfterSuite
	public void cleanUp() {
		driver.quit();

	}

}
