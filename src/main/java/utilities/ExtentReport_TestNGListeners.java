package utilities;

import java.io.File;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;

import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.DriverFactory;
import testBase.ExtentFactory;

public class ExtentReport_TestNGListeners implements ITestListener {

	String timeStamps = new SimpleDateFormat("dd-MM-yyy HH-mm-ss").format(new Date());
	String reportName = "MyStore Extent Report_" + timeStamps + ".html";
	ExtentSparkReporter htmlSparkReport;
	ExtentReports reports;
	ExtentTest extent_test;
	WebDriver driver = null;

	public void configureExtentReport() {

		htmlSparkReport = new ExtentSparkReporter(
				System.getProperty("user.dir") + "//Reports//Extent_Reports//" + reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlSparkReport);

		// Add System info / environment info to report
		reports.setSystemInfo("Machine Name", "Ravi PC 2020");
		reports.setSystemInfo("OS", System.getProperty("os.name"));
		reports.setSystemInfo("Browser name", ReadConfig.getPropertyValueByKey("browser"));
		reports.setSystemInfo("Env", ReadConfig.getPropertyValueByKey("env"));
		reports.setSystemInfo("username", System.getProperty("user.name"));
		reports.setSystemInfo("URL of app", ReadConfig.getPropertyValueByKey("baseURL"));

		// configuration to change look and feel

		htmlSparkReport.config().setDocumentTitle("My Store");
		htmlSparkReport.config().setReportName("My Store Extent reports");
		htmlSparkReport.config().setTheme(Theme.DARK);
		htmlSparkReport.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

	}

	// Class Level

	// onStart() method will execute before all the test case means onStart() will
	// run before all @Test
	@Override
	public void onStart(ITestContext results) {
		configureExtentReport();
		System.out.println("On START method inovoke..");
	}

	@Override
	public void onFinish(ITestContext results) {
		System.out.println("On FINISH method invoke...");
		reports.flush();

	}

	// Test Level
	// onTestStart() will execute before every @Test
	@Override
	public void onTestStart(ITestResult results) {
		System.out.println("On TEST START method invoke..");
		//before each test case
		extent_test = reports.createTest(results.getMethod().getMethodName());
		ExtentFactory.getInstance().setExtent(extent_test);
	}

	@Override
	public void onTestSuccess(ITestResult results) {
		System.out.println("On TEST SUCCESS method invoke..");
		//extent_test = reports.createTest(results.getName());
		ExtentFactory.getInstance().getExtent().log(Status.PASS,
				MarkupHelper.createLabel("Name of the Pass test case is: " + results.getName(), ExtentColor.GREEN));
		ExtentFactory.getInstance().removeExtentObject();
	}

	@Override
	public void onTestSkipped(ITestResult results) {

		System.out.println("On TEST SKIPPED method invoke..");
		extent_test = reports.createTest(results.getName());
		extent_test.log(Status.SKIP,
				MarkupHelper.createLabel("Name of the Skipped test case is: " + results.getName(), ExtentColor.YELLOW));
		ExtentFactory.getInstance().removeExtentObject();
	}

	@Override
	public void onTestFailure(ITestResult results) {
		String screenshotsFileName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date()) + "_" + results.getName();
		System.out.println("On TEST FAILURE method invoke..");
		System.out.println("Name of Failed test case: " + results.getName());
		//extent_test = reports.createTest(results.getName());
		ExtentFactory.getInstance().getExtent().log(Status.FAIL,
				MarkupHelper.createLabel("Name of the failed test case is: " + results.getName(), ExtentColor.RED));

		String screenShotPath = System.getProperty("user.dir") + "\\Screenshots\\" + screenshotsFileName + ".png";

		File screenShotFile = new File(screenShotPath);
		try {
			Utils.captureScreenShot(DriverFactory.getInstance().getDriver(), results.getName());
			
		} catch (IOException e) {

			e.printStackTrace();
		}

		if (screenShotFile.exists()) {
			ExtentFactory.getInstance().getExtent().fail("Captured Screenshot is below:" + extent_test.addScreenCaptureFromPath(screenShotPath,results.getName()));
			ExtentFactory.getInstance().getExtent().fail(results.getThrowable());
			ExtentFactory.getInstance().removeExtentObject();
		}

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult results) {

	}
}
