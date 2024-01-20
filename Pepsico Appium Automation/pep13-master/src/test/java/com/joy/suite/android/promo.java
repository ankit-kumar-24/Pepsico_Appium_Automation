package com.joy.suite.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class promo {

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
        WebElement login = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[1]"));
        login.click();
        login.sendKeys("joytest123@gmail.com");

        Thread.sleep(1000);
        WebElement password = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
        password.click();
        password.sendKeys("Testing#123@");
        // Press the "Enter" key
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        Thread.sleep(4000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Sign In\"]")).click();

        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("(//android.widget.Button[@content-desc=\"View All\"])[1]")).click();

        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"TAS12JAN24\n" + "Until January 30, 2024\"]")).click();

        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Participate\n" + "Tab 1 of 5\"]")).click();

        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Rankings\n" + "Tab 2 of 5\"]")).click();

        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Rewards\n" + "Tab 3 of 5\"]")).click();

        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Products\n" + "Tab 4 of 5\"]")).click();

        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Retailers\n" + "Tab 5 of 5\"]")).click();

        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.ImageView/android.widget.ImageView\n")).click();

        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button")).click();


        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button\n")).click();

        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Sign Out\"]")).click();

        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Yes\"]")).click();


    }

}
