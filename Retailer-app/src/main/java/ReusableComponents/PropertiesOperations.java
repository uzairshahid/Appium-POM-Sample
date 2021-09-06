package ReusableComponents;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

import TestBase.TestBase;

public class PropertiesOperations extends TestBase {

	public static String getPropertyValueByKey(String key) throws Exception {

		Properties prop = new Properties();
//		1- load data from properties file
//		location of file
//		String propFilePath = System.getProperty("user.dir")+"/src/test/resource/config.properties";
		String propFilePath = "C:\\Users\\Uzair Shahid\\eclipse-workspace\\Retailer-app\\src\\test\\resource\\config.properties";
		
		FileInputStream fs = new FileInputStream(propFilePath);
		prop.load(fs);

//		2- once data is loaded from property file then read data
		String value = prop.getProperty(key).toString();
		if (StringUtils.isEmpty(value)) {
			throw new Exception("Value is not specified for Key" + key + "In the property file");
		}	

		return value;
	}
}
