package ReusableComponents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import TestBase.ObjectsRepo;

public class ListnersImplementation extends ObjectsRepo implements ITestListener {
	public void onTestStart(ITestResult result) {
//		before each testcase start it will execute

		test = extent.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
//		on each testcase pass it will execute

		test.log(Status.PASS, "Test Case" + result.getMethod().getMethodName() + "Is Paassed");
	}

	public void onTestFailure(ITestResult result) {
//		on each testcase fail it will execute
		test.log(Status.FAIL, "Test Case" + result.getMethod().getMethodName() + "Is Failed");
		test.log(Status.FAIL, result.getThrowable());

//		add screenshot if fail
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
//		get current date
		Date date = new Date();
		String ActualDate = format.format(date);
		String screenshotPath = System.getProperty("user.dir") + "/Reports/ScreenShots/" + ActualDate + ".jpeg";

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(screenshotPath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			test.addScreenCaptureFromPath(screenshotPath,"Test Case failure Screenshot");
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {
//	setup method call
		extent = ExtentsReportSetup.Setup_Extents_Report();

	}

	public void onFinish(ITestContext context) {
// close extents
		extent.flush();
	}

}
