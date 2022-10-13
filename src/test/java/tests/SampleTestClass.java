package tests;





import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.DriverFactory;
import testBase.MyLogger;
import testBase.TestBase;


public class SampleTestClass extends TestBase {

	@Test
	public void google() {
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		DriverFactory.getInstance().getDriver().get("https://www.google.com");
		MyLogger.info("Google page lauched....");
		String title = DriverFactory.getInstance().getDriver().getTitle();
		MyLogger.info("Google page title retrieve....");
		Assert.assertEquals(title, "Google");
		MyLogger.info("Assertion done for google");
	}
	
	
	@Test
	public void facebook() {
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		DriverFactory.getInstance().getDriver().get("https://www.facebook.com");
		MyLogger.info("Facebook page lauched....");
		String title = DriverFactory.getInstance().getDriver().getTitle();
		MyLogger.info("Facebook page title retrieve....");
		Assert.assertEquals(title, "Facebook – log in or sign up");
		MyLogger.info("Assertion done for facebook");
	}
	@Test
	public void twitter() {
		DriverFactory.getInstance().getDriver().get("https://www.twitter.com");
		String title = DriverFactory.getInstance().getDriver().getTitle();
		Assert.assertEquals(title, "Twitter");
	}
	
	
	@Test
	public void amazon() {
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		DriverFactory.getInstance().getDriver().get("https://www.amazon.in");
		MyLogger.info("Amazone page lauched....");
		String title = DriverFactory.getInstance().getDriver().getTitle();
		MyLogger.info("Amazon page title retrieve....");
		Assert.assertEquals(title, "1Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		MyLogger.info("Assertion done for Amazon");
	
	}
}
