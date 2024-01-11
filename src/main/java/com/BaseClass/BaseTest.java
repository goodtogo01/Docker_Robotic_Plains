package com.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.System.Logger;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.Capabilities.CapabilityFactory;
import com.Utility.TestUtils;

public class BaseTest {

	public static Properties prop;
	public String projectPath = System.getProperty("user.dir");
	 

	// Declare ThreadLocal Driver (ThreadLocalMap) for ThreadSafe Tests
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	public CapabilityFactory capabilityFactory = new CapabilityFactory();

	public BaseTest() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(projectPath + "/" + "config.properties");
			//InputStream fis = BaseTest.class.getResourceAsStream("/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	@BeforeClass
	@Parameters(value = { "browser"})
	public void setup(String browser) throws IOException, InterruptedException {
		
		// Set Browser to ThreadLocalMap
		String envName = prop.getProperty("environment");
			if(envName.equals("awsEnv")) {
				//TestUtils.start_Docker(); Only if aws is running
			driver.set(new RemoteWebDriver(new URL("http://"+prop.getProperty("awsEnv")+":4444/wd/hub"), 
					capabilityFactory.getCapabilities(browser)));
			getDriver().navigate().to(prop.getProperty("url"));
		}else {
	TestUtils.start_Docker();

			driver.set(new RemoteWebDriver(new URL(prop.getProperty("localEnv")), // Local execution with docker
					capabilityFactory.getCapabilities(browser)));
			getDriver().navigate().to(prop.getProperty("url"));
		}

	}

	public static WebDriver getDriver() {
		// Get driver from ThreadLocalMap
		return driver.get();
	}


	@AfterClass
	public void tearDown() throws IOException, InterruptedException {
		TestUtils.stop_Docker();
	}

	//@AfterClass
	void terminate() throws IOException, InterruptedException {
		// Remove the ThreadLocalMap element
		driver.remove();

	}
}
