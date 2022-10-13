package testBase;

import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {
	
	// ThreadLoal ---> java.lang (Package) --->  threading

	// Design Pattern  --- represent best practices
	// singleton design pattern - only one instance exit ever, provide global access to that instance by creating getInstance method
	// Factory design pattern --- define separate factory methods for creating objects and create objects by calling that methods

	// private constructor so that no one else can create the object of this class
	private ExtentFactory() {
		
	}
	
	
	private static ExtentFactory instance = new ExtentFactory();
	
	public static ExtentFactory getInstance() {
		return instance;
	}
	
	
	ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();
	
	public ExtentTest getExtent() {
		return extent.get();
		
	}

	public void setExtent(ExtentTest extentTestObject) {
		extent.set(extentTestObject);
		
	}
	
	public void removeExtentObject() {
		extent.remove();
	}
}
