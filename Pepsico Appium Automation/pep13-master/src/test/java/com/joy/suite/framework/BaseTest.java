package com.joy.suite.framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class BaseTest {
    MutableCapabilities caps = new MutableCapabilities();
    //Instantiating the properties file
    Properties props = new Properties();
    protected AppiumDriver driver;
    public static URL url;
    public static DesiredCapabilities capabilities;
    //protected AndroidDriver driver;
    //protected IOSDriver iOSdriver;

    @BeforeClass
    public AppiumDriver setUp(String AndroidApp, String AndroidDeviceName, String platformName, String automationName, String newCommandTimeout, String platformVersion) throws MalformedURLException {
        MutableCapabilities sauceOptions = new MutableCapabilities();
            // Initialize the driver
        if (platformName.equals("Android")) {
            caps.setCapability("platformName", platformName);
            caps.setCapability("appium:app",AndroidApp );  // The filename of the mobile app
            caps.setCapability("appium:deviceName", AndroidDeviceName);
            caps.setCapability("appium:platformVersion", "14.0");
            caps.setCapability("appium:automationName", automationName);
            sauceOptions.setCapability("appiumVersion", "2.0.0");
            sauceOptions.setCapability("username", "Naveen_Kulkarni");
            sauceOptions.setCapability("accessKey", "e2188fcc-7696-4dee-bdfa-dae429bcabd8");
            sauceOptions.setCapability("build", "Joy_build");
            sauceOptions.setCapability("name", "Joy_name");
            sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
            caps.setCapability("sauce:options", sauceOptions);
            driver = new AndroidDriver(new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub"), caps);
        }  if (platformName.equals("iOS")) {
            caps.setCapability("platformName", platformName);
            caps.setCapability("appium:app", AndroidApp);  // The filename of the mobile app
            caps.setCapability("appium:deviceName", AndroidDeviceName);
            caps.setCapability("appium:platformVersion", "14.0");
            caps.setCapability("appium:automationName", automationName);
            sauceOptions.setCapability("appiumVersion", "2.0.0");
            sauceOptions.setCapability("username", "Naveen_Kulkarni");
            sauceOptions.setCapability("accessKey", "e2188fcc-7696-4dee-bdfa-dae429bcabd8");
            sauceOptions.setCapability("build", "Joy_build");
            sauceOptions.setCapability("name", "Joy_name");
            sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
            caps.setCapability("sauce:options", sauceOptions);
            driver = new AndroidDriver(new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub"), caps);
        }  else {
            throw new IllegalArgumentException("Unsupported platform: " + platformName);
        }

        // Print some logs for debugging
        System.out.println("Driver initialized successfully.");
        System.out.println("Platform: " + sauceOptions.getCapability(MobileCapabilityType.PLATFORM_NAME));

        return driver;
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
