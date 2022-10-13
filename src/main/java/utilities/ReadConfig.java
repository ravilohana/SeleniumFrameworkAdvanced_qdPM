package utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class ReadConfig {

	

	

	static Properties prop = new Properties();

	public static String getPropertyValueByKey(String key) {
		// 1. load data from properties file
		String propFilePath = System.getProperty("user.dir") + "\\Configurations\\config.properties";
		FileInputStream fis;
		try {
			fis = new FileInputStream(propFilePath);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		// 2. read data
		String value = prop.get(key).toString();

		if (StringUtils.isEmpty(value)) {
			try {
				throw new Exception("Value is not specified for key: " + key + " in properties file.");
			} catch (Exception e) {
			}
		}
		
		
		return value;
	}

	/*
	 * public String getBaseUrl() { String base_url = prop.getProperty("baseUrl");
	 * if(base_url != null) return base_url; else throw new
	 * RuntimeException("Base URL is not specified in config properties file"); }
	 * 
	 * public String getBrowser() { String browser = prop.getProperty("browser");
	 * if(browser != null) return browser; else throw new
	 * RuntimeException("Browser is not specified in config properties file"); }
	 * 
	 * public String getEnv() { String browser = prop.getProperty("env"); if(browser
	 * != null) return browser; else throw new
	 * RuntimeException("Env is not specified in config properties file"); }
	 * 
	 */

}
