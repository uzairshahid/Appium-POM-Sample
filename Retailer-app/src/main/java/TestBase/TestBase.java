package TestBase;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ReusableComponents.PropertiesOperations;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestBase  extends AndroidSetup{

	@BeforeClass // it will excecute before each test method with in current class
	public void setupMethod() throws Exception {
		prepareAndroidForAppium();
	}

	@Test
	public void f() throws InterruptedException
	{
		driver.findElement(By.xpath(".//android.widget.Button[@text='Allow']")).click();
		System.out.println("1232323");
		Thread.sleep(5000);

	}
	 @AfterClass
	    public void tearDown() throws Exception {
	        driver.quit();
	    }
	 

}
