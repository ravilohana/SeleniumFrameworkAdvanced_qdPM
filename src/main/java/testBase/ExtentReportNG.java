package testBase;

import java.text.SimpleDateFormat;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utilities.ReadConfig;




public class ExtentReportNG {
	
	
	static String timeStamps = new SimpleDateFormat("dd-MM-yyy HH-mm-ss").format(new Date());
	static String reportName = "MyStore Extent Report_" + timeStamps + ".html";
	static ExtentSparkReporter htmlSparkReport;
	
	ExtentTest extent_test;
	
	static ExtentReports extent;

	
	/*
	
	htmlSparkReport = new ExtentSparkReporter(
			System.getProperty("user.dir") + "//Reports//Extent_Reports//" + reportName);
	reports = new ExtentReports();
	reports.attachReporter(htmlSparkReport);

	// Add System info / environment info to report
	reports.setSystemInfo("Machine Name", "Ravi PC 2020");
	reports.setSystemInfo("OS", System.getProperty("os.name"));
	reports.setSystemInfo("Browser name", readConfig.getBrowser());
	reports.setSystemInfo("Env", readConfig.getEnv());
	reports.setSystemInfo("username", System.getProperty("user.name"));
	reports.setSystemInfo("URL of app", readConfig.getBaseUrl());

	// configuration to change look and feel

	htmlSparkReport.config().setDocumentTitle("My Store");
	htmlSparkReport.config().setReportName("My Store Extent reports");
	htmlSparkReport.config().setTheme(Theme.DARK);
	htmlSparkReport.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
*/
	public static synchronized ExtentReports setupExtentReport() throws Exception {
		htmlSparkReport = new ExtentSparkReporter(
				System.getProperty("user.dir") + "//Reports//Extent_Reports//" + reportName);
		extent = new ExtentReports();
		extent.attachReporter(htmlSparkReport);

		// Add System info / environment info to report
		extent.setSystemInfo("Machine Name", "Ravi PC 2020");
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Browser name",ReadConfig.getPropertyValueByKey("browser"));
		extent.setSystemInfo("Env", ReadConfig.getPropertyValueByKey("env"));
		extent.setSystemInfo("username", System.getProperty("user.name"));
		extent.setSystemInfo("Base URL of app", ReadConfig.getPropertyValueByKey("baseUrl"));

		// configuration to change look and feel

		htmlSparkReport.config().setDocumentTitle("My Store");
		htmlSparkReport.config().setReportName("My Store Extent reports");
		htmlSparkReport.config().setTheme(Theme.DARK);
		htmlSparkReport.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		return extent;
		
		
	}


}