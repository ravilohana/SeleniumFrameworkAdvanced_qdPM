package reuseableComponents;

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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import testBase.DriverFactory;
import testBase.ExtentFactory;
import testBase.ExtentReportNG;




public class ListenersImplementation implements ITestListener{
	//JiraOperations jiraOps = new JiraOperations();
	static ExtentReports report;
		   ExtentTest test;
		   
	public void onTestStart(ITestResult result) {
		//before each test case
		test = report.createTest(result.getMethod().getMethodName());
		ExtentFactory.getInstance().setExtent(test);
		System.out.println("onTestStart() ==> test level when test start");
	}

	public void onTestSuccess(ITestResult result) {
		//ExtentFactory.getInstance().getExtent().log(Status.PASS, "Test Case: "+result.getMethod().getMethodName()+ " is Passed.");
		ExtentFactory.getInstance().getExtent().log(Status.PASS,MarkupHelper.createLabel("Name of the Pass test case is: " + result.getName(), ExtentColor.GREEN));
		System.out.println("onTestSuccess() ==> test level when test passed or success");
		ExtentFactory.getInstance().removeExtentObject();
	}

	public void onTestFailure(ITestResult result) {
		//ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Test Case: "+result.getMethod().getMethodName()+ " is Failed.");
		ExtentFactory.getInstance().getExtent().log(Status.FAIL,MarkupHelper.createLabel("Name of the Pass test case is: " + result.getName(), ExtentColor.RED));
		System.out.println("onTestFailure() ==> test level when test falied");
		ExtentFactory.getInstance().getExtent().log(Status.FAIL, result.getThrowable());
		
		//add screenshot for failed test.
		File src = ((TakesScreenshot)DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);
		
		String screenshotPath = System.getProperty("user.dir")+
				"/Reports/Screenshots/"+actualDate+".jpeg";
		File dest = new File(screenshotPath);
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			ExtentFactory.getInstance().getExtent().addScreenCaptureFromPath(screenshotPath, "Test case failure screenshot");
			ExtentFactory.getInstance().removeExtentObject();

		
		
		/*
		///////JIRA defect creation part
		String automaticJIRAcreation = PropertiesOperations.getPropertyValueByKey("automatic_Issue_Creation_In_JIRA");
		if(automaticJIRAcreation.trim().equalsIgnoreCase("ON")) {
			String issueS = "Automation Test Failed - "+result.getMethod().getMethodName();
			String issueD = "Test Data to be passed here.";
			String issueNumber = null;
			try {
				issueNumber = jiraOps.createJiraIssue("QDPM", issueS, issueD, "10000", "5", "QDPM", "SIT", "5f782c4b95fe8e0069705791");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				jiraOps.addAttachmentToJiraIssue(issueNumber, screenshotPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/

	}

	public void onTestSkipped(ITestResult result) {
		//ExtentFactory.getInstance().getExtent().log(Status.SKIP, "Test Case: "+result.getMethod().getMethodName()+ " is skipped.");
		
		
		ExtentFactory.getInstance().getExtent().log(Status.SKIP,MarkupHelper.createLabel("Name of the Pass test case is: " + result.getName(), ExtentColor.YELLOW));
		System.out.println("onTestSkipped() ==> test level when test skipped!!");
		ExtentFactory.getInstance().getExtent().log(Status.FAIL, result.getThrowable());
		ExtentFactory.getInstance().removeExtentObject();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		try {
			 report = ExtentReportNG.setupExtentReport();
			 System.out.println("onStart() ==> class level before tests");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onFinish(ITestContext context) {
		//close extent
		System.out.println("onFinish() ==> class level after tests");
		report.flush();
	}

}