package com.joy.suite.ios;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.MutableCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class saucelab_ios {
    @Test
    public void runIOSAutomation() throws MalformedURLException, InterruptedException {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:app", "storage:filename=joy_app_ios_dev-2.0.0+2023112801.ipa");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "iPhone 11");
        caps.setCapability("appium:platformVersion", "16");
        caps.setCapability("appium:automationName", "XCUITest");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", "Naveen_Kulkarni");
        sauceOptions.setCapability("accessKey", "e2188fcc-7696-4dee-bdfa-dae429bcabd8");
        sauceOptions.setCapability("build", "test-build");
        sauceOptions.setCapability("name", "test-name");
        caps.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
        IOSDriver driver = new IOSDriver(url, caps);

            Thread.sleep(2000);
            driver.quit();
        }}
//
//        MutableCapabilities caps = new MutableCapabilities();
//        caps.setCapability("platformName", "Android");
//        caps.setCapability("appium:app", "storage:filename=joy_app_ios_dev-2.0.0+2023112801.ipa");
//        caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
//        caps.setCapability("appium:platformVersion", "current_major");
//        caps.setCapability("appium:automationName", "UiAutomator2");
//        MutableCapabilities sauceOptions = new MutableCapabilities();
//        sauceOptions.setCapability("username", "Naveen_Kulkarni");
//        sauceOptions.setCapability("accessKey", "e2188fcc-7696-4dee-bdfa-dae429bcabd8");
//        sauceOptions.setCapability("build", "test-build");
//        sauceOptions.setCapability("name", "test-name");
//        sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
//        caps.setCapability("sauce:options", sauceOptions);
//
//        URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
//        AndroidDriver driver = new AndroidDriver(url, caps);


