package com.nic.rs.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.nic.rs.qa.util.Constants;



public class BasePage {

	WebDriver driver;
	Properties prop;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();


	public WebDriver initialize_driver(Properties prop) {

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\DriverFiles\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-single-click-autofill");
			options.addArguments("--headless");
			tldriver.set(new ChromeDriver(options));
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "");
			tldriver.set(new FirefoxDriver());
		} else if (browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "");
			tldriver.set(new InternetExplorerDriver());
		} else {
			System.out.println("no browser is defined");
		}

		getDriver().manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		
		getDriver().manage().deleteAllCookies();
		
		if (prop.getProperty("fullscreenmode").equalsIgnoreCase("yes")) {
			

			getDriver().manage().window().maximize();
			
			
			
		}

		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}

	public Properties initialize_properties() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream((System.getProperty("user.dir")+"\\src\\test\\resources\\Config.properties"));
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}
	
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}

	
}
