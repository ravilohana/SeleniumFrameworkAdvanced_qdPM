package utilities;

import java.io.File;




import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testBase.DriverFactory;

public class Utils{

	/**
	 * select value from DropDown by using selectByIndex
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param index       : Index of value wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 * 
	 */

	public static boolean selectByIndex(WebElement element, int index) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByIndex(index);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by Index: " + index);
			} else {
				System.out.println("Option not selected by Index: " + index);
			}
		}
	}

	public static boolean selectByValue(WebElement element, String value) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByValue(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by Value: " + value);
			} else {
				System.out.println("Option not selected by Value: " + value);
			}
		}
	}

	/**
	 * select value from DropDown by using selectByVisibleText
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param visibletext : VisibleText wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 */

	public static boolean selectByVisibleText(String visibletext, WebElement ele) {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(visibletext);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by VisibleText: " + visibletext);
			} else {
				System.out.println("Option not selected by VisibleText: " + visibletext);
			}
		}
	}

	// take screenshots and save to ScreenShot folder
//		public static String CaptureScreenshot(WebDriver driver,String testName) throws IOException {
//			String FileSeparator = System.getProperty("file.separator");
//			String ScreenshotPath = "." + FileSeparator + "ScreenShots";
//			
//
//			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			String logFileName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
//			//String screenshotName = "screenshot" + Math.random() + ".png";
//			String screenshotName = testName + logFileName + ".png";
//			//String screenshotName = "screenshot" + logFileName + ".png";
//			
//			
//			String screenshotpath = ScreenshotPath + FileSeparator + screenshotName;
//
//			FileUtils.copyFile(src, new File(screenshotpath));
//			return "." + FileSeparator + screenshotpath + FileSeparator + screenshotName;
//
//		}

	// user method to capture screen shot
	public static void captureScreenShot(WebDriver driver, String testName) throws IOException {
		String screenshotsFileName =new SimpleDateFormat("yyyyMMddHHmm").format(new Date()) + "_" +testName;
		// step1: convert webdriver object to TakesScreenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot) DriverFactory.getInstance().getDriver());

		
		// step2: call getScreenshotAs method to create image file

		File src_file = screenshot.getScreenshotAs(OutputType.FILE);

		File screenshot_File = new File(System.getProperty("user.dir") + "//Screenshots//" + screenshotsFileName + ".png");

		// step3: copy image file to destination
		FileUtils.copyFile(src_file, screenshot_File);
	}

}
