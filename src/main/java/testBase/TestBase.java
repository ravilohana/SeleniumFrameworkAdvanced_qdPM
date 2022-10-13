package testBase;

import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ReadConfig;


public class TestBase {
	
	
	//public static Logger logger;
	//ReadConfig readConfig = new ReadConfig();
	private String baseURL = ReadConfig.getPropertyValueByKey("baseUrl");
	private String browser = ReadConfig.getPropertyValueByKey("browser");
	BrowserFactory bf = new BrowserFactory();

	@BeforeMethod
	public void lauchApplication() {
		DriverFactory.getInstance().setDriver(bf.createBrowserInstance(browser));
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		DriverFactory.getInstance().getDriver().manage().deleteAllCookies();
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		DriverFactory.getInstance().getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		//DriverFactory.getInstance().getDriver().navigate().to(baseURL);
	}
	
	@AfterMethod
	public void tearDown(){
		DriverFactory.getInstance().closeBrowser();
	}

}
