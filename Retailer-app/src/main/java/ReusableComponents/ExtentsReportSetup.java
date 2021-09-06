package ReusableComponents;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestBase.ObjectsRepo;

public class ExtentsReportSetup extends ObjectsRepo {
	
	public static ExtentReports Setup_Extents_Report() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
//		get current date
		Date date = new Date();
		String ActualDate = format.format(date);

		String reportPath = System.getProperty("user.dir") + "/Reports/ExecutionReport_" + ActualDate + ".html";

		ExtentSparkReporter spartReport = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();
		extent.attachReporter(spartReport);

		spartReport.config().setDocumentTitle("Document Title");
		spartReport.config().setTheme(Theme.DARK);
		spartReport.config().setReportName("Report NAME");

		return extent;

	}
}
