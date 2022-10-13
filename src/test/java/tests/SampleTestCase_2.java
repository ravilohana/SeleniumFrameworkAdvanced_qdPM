package tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import testBase.DriverFactory;
import testBase.MyLogger;
import testBase.TestBase;

public class SampleTestCase_2  extends TestBase{

	
	
	@Test(groups = "Smoke")
	public void openCart() {
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		DriverFactory.getInstance().getDriver().get("https://demo.opencart.com/");
		MyLogger.info("Opencart page lauched....");
		String title = DriverFactory.getInstance().getDriver().getTitle();
		MyLogger.info("OpenCart page title retrieve....");
		Assert.assertEquals(title, "1Your Store");
		MyLogger.info("Assertion done for Opencart");
	}
	
	
	@Test
	public void orangeHRM() {
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		DriverFactory.getInstance().getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		MyLogger.info("OrangeHRM page lauched....");
		String title = DriverFactory.getInstance().getDriver().getTitle();
		MyLogger.info("OrangeHRM page title retrieve....");
		Assert.assertEquals(title, "OrangeHRM");
		MyLogger.info("Assertion done for OrangeHRM");
	}
	
	
	@Test
	public void prestashop() {
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		DriverFactory.getInstance().getDriver().get("https://demo.prestashop.com/#/en/front");
		MyLogger.info("Prestashop page lauched....");
		String title = DriverFactory.getInstance().getDriver().getTitle();
		MyLogger.info("Prestashop page title retrieve....");
		Assert.assertEquals(title, "PrestaShop Live Demo");
		MyLogger.info("Assertion done for PrestaShop");
	}

}
