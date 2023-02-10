package config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class URLsFile {

	public String getUser() {
		try {
			Properties prop = new Properties();
			InputStream input = new FileInputStream("./src/test/java/config/config.properties");
			prop.load(input);
			String getUserEndpoint = prop.getProperty("getUser");

			return getUserEndpoint;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public String getInvalidUser() {
		try {
			Properties prop = new Properties();
			InputStream input = new FileInputStream("./src/test/java/config/config.properties");
			prop.load(input);
			String getUserInvalidEndpoint = prop.getProperty("getInvalidUser");

			return getUserInvalidEndpoint;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String postUserWithEmail() {
		try {
			Properties prop = new Properties();
			InputStream input = new FileInputStream("./src/test/java/config/config.properties");
			prop.load(input);
			String postUserWithEndpoint = prop.getProperty("postUserWithEmail");

			return postUserWithEndpoint;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
