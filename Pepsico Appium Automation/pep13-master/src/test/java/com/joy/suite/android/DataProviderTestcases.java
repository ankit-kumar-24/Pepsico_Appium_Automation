package com.joy.suite.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class DataProviderTestcases {
    public AndroidDriver driver;

    @Test
    public void Login() throws MalformedURLException, InterruptedException {
        MutableCapabilities caps = new MutableCapabilities();
        //Instantiating the properties file
        Properties props = new Properties();

        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=app-qa-release.aab");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "Google Pixel 4 GoogleAPI Emulator");
        caps.setCapability("appium:platformVersion", "14.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("appiumVersion", "2.0.0");
        sauceOptions.setCapability("username", "Naveen_Kulkarni");
        sauceOptions.setCapability("accessKey", "e2188fcc-7696-4dee-bdfa-dae429bcabd8");
        sauceOptions.setCapability("build", "Joy_build");
        sauceOptions.setCapability("name", "Joy_name");
        sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
        caps.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, caps);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        //    WebElement el1 = driver.findElement(AppiumBy.accessibilityId("Log In"));
        WebElement el1 = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Log In\"]"));

        el1.click();
        Thread.sleep(6000);
        WebElement el2 = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[1]"));
        el2.click();
        el2.sendKeys("joytest123@gmail.com");

        Thread.sleep(1000);
        WebElement el3 = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
        el3.click();
        el3.sendKeys("Testing#123@");

        //  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"WebView\").instance(0))").click();

        //  Thread.sleep(5000);

        Thread.sleep(1000);
        WebElement el4 = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Sign In\"]"));
        el4.click();

        Thread.sleep(2000);
        driver.quit();
        //login code
        //logout codw


    }

    @Test
    public void CreateAccount() throws MalformedURLException, InterruptedException {
        MutableCapabilities caps = new MutableCapabilities();
        //Instantiating the properties file
        Properties props = new Properties();

        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=app-qa-release.aab");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "Google Pixel 4 GoogleAPI Emulator");
        caps.setCapability("appium:platformVersion", "14.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("appiumVersion", "2.0.0");
        sauceOptions.setCapability("username", "Naveen_Kulkarni");
        sauceOptions.setCapability("accessKey", "e2188fcc-7696-4dee-bdfa-dae429bcabd8");
        sauceOptions.setCapability("build", "Joy_build");
        sauceOptions.setCapability("name", "Joy_name");
        sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
        caps.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, caps);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        //    WebElement el1 = driver.findElement(AppiumBy.accessibilityId("Log In"));
        WebElement el1 = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Log In\"]"));

        el1.click();
        Thread.sleep(6000);
        WebElement el2 = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[1]"));
        el2.click();
        el2.sendKeys("joytest123@gmail.com");

        Thread.sleep(1000);
        WebElement el3 = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
        el3.click();
        el3.sendKeys("Testing#123@");

        //  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"WebView\").instance(0))").click();

        //  Thread.sleep(5000);

        Thread.sleep(1000);
        WebElement el4 = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Sign In\"]"));
        el4.click();

        Thread.sleep(2000);
        driver.quit();


    }
}





