package com.joy.suite.framework;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BasePage {
    MutableCapabilities caps = new MutableCapabilities();
    //Instantiating the properties file
    Properties props = new Properties();
    private AndroidDriver driver;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void login()throws MalformedURLException, InterruptedException {

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
