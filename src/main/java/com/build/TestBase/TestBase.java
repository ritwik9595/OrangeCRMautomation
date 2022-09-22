package com.build.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() throws FileNotFoundException {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:/Users/HP/eclipse-workspace/build/src/main/java/com/build/ConfigProp/config.properties"
					+ "");		
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));

	}

	public static void initialization() {

			String browserNamer = prop.getProperty("browser");
		if(browserNamer.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\eclipse\\chromedriver.exe");		
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(prop.getProperty("url"));

	}
}

