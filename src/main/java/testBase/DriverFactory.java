package testBase;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	// ThreadLoal ---> java.lang (Package) --->  threading

	// Design Pattern  --- represent best practices
	// singleton design pattern - only one instance exit ever, provide global access to that instance by creating getInstance method
	// Factory design pattern --- define separate factory methods for creating objects and create objects by calling that methods

	// private constructor so that no one else can create the object of this class
	private DriverFactory() {}

	private static DriverFactory instance = new DriverFactory();

	public static DriverFactory getInstance() {
		return instance;
	}

	ThreadLocal<WebDriver> thDriver = new ThreadLocal<>();

	public WebDriver getDriver() {
		return thDriver.get();
	}

	public void setDriver(WebDriver driverRef) {
		thDriver.set(driverRef);
	}

	public void closeBrowser() {
		thDriver.get().close();
		thDriver.remove();
	}

}
