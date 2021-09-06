package TestBase;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import ReusableComponents.PropertiesOperations;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AndroidSetup {
	AppiumDriver driver;
	public void prepareAndroidForAppium() throws Exception
    {
		DesiredCapabilities capabalities = new DesiredCapabilities();
		capabalities.setCapability("deviceName", PropertiesOperations.getPropertyValueByKey("deviceName"));
		capabalities.setCapability("udid", PropertiesOperations.getPropertyValueByKey("udid"));
		capabalities.setCapability("platformName", PropertiesOperations.getPropertyValueByKey("platformName"));
		capabalities.setCapability("platformVersion", PropertiesOperations.getPropertyValueByKey("platformVersion"));
		capabalities.setCapability("appPackage", PropertiesOperations.getPropertyValueByKey("appPackage"));
		capabalities.setCapability("appActivity", PropertiesOperations.getPropertyValueByKey("appActivity"));
//		capabalities.setCapability("noReset", PropertiesOperations.getPropertyValueByKey("noReset"));
		capabalities.setCapability("autoGrantPermissions", true);
		capabalities.setCapability("autoAcceptAlerts", true);
		
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabalities);
		String sessionID = driver.getSessionId().toString();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		 
		 
		 
    }


}
