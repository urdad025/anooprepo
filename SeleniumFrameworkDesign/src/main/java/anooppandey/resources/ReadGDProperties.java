package anooppandey.resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadGDProperties {

	public static Properties getProperties() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//anooppandey//resources//GlobalData.properties");

		prop.load(fis);

		return prop;
	}
}
