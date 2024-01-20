package com.joy.suite.perf.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class saucelab_perf {

    public AndroidDriver driver;
    @BeforeSuite
    public void beforeAll() {
        //startAppiumServer();
    }

    @AfterSuite
    public void afterAll() {
        //stopAppiumServer();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {

    }

    @AfterMethod
    public void afterMethod(ITestResult result) {

    }

    @Test
    public void runAndoridAutomationperf() throws MalformedURLException, InterruptedException {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=app-perf-release.apk");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
        caps.setCapability("appium:platformVersion", "14.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("appiumVersion", "2.0.0");
        sauceOptions.setCapability("username", "Naveen_Kulkarni");
        sauceOptions.setCapability("accessKey", "e2188fcc-7696-4dee-bdfa-dae429bcabd8");
        sauceOptions.setCapability("build", "Perfbuild");
        sauceOptions.setCapability("name", "Perfname");
        sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
        caps.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, caps);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        WebElement el1 = driver.findElement(AppiumBy.accessibilityId("Log In"));
//        WebElement el1 = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Log In\"]"));

        el1.click();
        Thread.sleep(6000);
        WebElement el2 = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[1]"));
        el2.click();
        el2.sendKeys("joyapptestt+1234@gmail.com");

        Thread.sleep(1000);
        WebElement el3 =driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
        el3.click();
        el3.sendKeys("Raja@123");
        Thread.sleep(1000);
        WebElement el4=driver.findElement(AppiumBy.className("android.widget.Button"));
        el4.click();
        Thread.sleep(2000);
        driver.quit();
    }


}
