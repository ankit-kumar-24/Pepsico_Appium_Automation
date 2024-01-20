package com.joy.suite.ios;

import com.joy.suite.framework.BaseTest;
import com.joy.suite.pageObject.LoginPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

class TestCasesExtendsBase_run extends BaseTest {
    private static final String ANDROID_APP = "storage:filename=joy_app.ipa";
    private static final String ANDROID_DEVICE_NAME = "iPhone_XR_14_7_real_us";
    private static final String ANDROID_PLATFORMNAME = "iOS";
    private static final String AUTOMATION_NAME = "XCUITest";
    private static final String APPIUM_PLATFORMVERSION = "14.0";
    private static final String NEW_COMMAND_TIMEOUT = "60";
    protected AppiumDriver driver;


   @DataProvider(name = "testDataForSignInTest")
   public Object[][] getDataForSignInTest() {
       return new Object[][] { { "joytest123@gmail.com", "Testing#123@" }, };

   }

    @BeforeSuite
    public void setupDriver() throws MalformedURLException {
        driver =  setUp(ANDROID_APP,ANDROID_DEVICE_NAME, ANDROID_PLATFORMNAME, AUTOMATION_NAME, NEW_COMMAND_TIMEOUT, APPIUM_PLATFORMVERSION);
    }

    @Test(enabled = true, groups = { "signIn", "critical" }, dataProvider = "testDataForSignInTest")
    public void Login(String email, String password) throws MalformedURLException, InterruptedException {
       // driver = new AndroidDriver()
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    //@Test
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
        WebElement el1 = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Create an account\"]"));

        el1.click();
        Thread.sleep(2000);
        WebElement el2 = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[1]"));
        el2.click();
        el2.sendKeys("joytest123@gmail.com");

        Thread.sleep(1000);
        WebElement el3 = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
        el3.click();
        el3.sendKeys("Testing#123@");

        Thread.sleep(1000);
        WebElement el5 = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[3]"));
        el5.click();
        el5.sendKeys("Testing#123@");

        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

               // Use TouchAction to perform a tap at the element's center coordinates
        new io.appium.java_client.TouchAction<>(driver)
                .tap(TapOptions.tapOptions().withPosition(PointOption.point(123, 1393)))
                .perform();

        WebElement ageConfirmation = driver.findElement(AppiumBy.xpath("//android.widget.CheckBox[@content-desc=\"*I confirm that I am at least 18 years old\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(ageConfirmation));
        ageConfirmation.click();

        if (ageConfirmation.isSelected()) {
            System.out.println("Checkbox is selected");
        } else {
            System.out.println("Checkbox is not selected");
        }

        Thread.sleep(1000);
        WebElement createAccount = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Create Account\"]s"));
        createAccount.click();

        Thread.sleep(2000);
        driver.quit();


    }

    //@Test
    public void ProfileUpdate() throws MalformedURLException, InterruptedException {
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
        driver.quit();



        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        //    WebElement el1 = driver.findElement(AppiumBy.accessibilityId("Log In"));
        WebElement el2 = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button]"));

        el1.click();
        Thread.sleep(2000);
        WebElement el3 = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Profile\"]"));
        el2.click();


        Thread.sleep(1000);
        WebElement el4 = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
        el3.click();
        el3.sendKeys("Testing#123@");

        Thread.sleep(1000);
        WebElement el5 = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[3]"));
        el5.click();
        el5.sendKeys("Testing#123@");

        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement TermsConditionPrivacy = driver.findElement(AppiumBy.xpath("//android.widget.CheckBox[@content-desc=\"*I accept & terms & conditions privacy policy\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(TermsConditionPrivacy));
        TermsConditionPrivacy.click();

        if (TermsConditionPrivacy.isSelected()) {
            System.out.println("Checkbox is selected");
        } else {
            System.out.println("Checkbox is not selected");
        }


        WebElement ageConfirmation = driver.findElement(AppiumBy.xpath("//android.widget.CheckBox[@content-desc=\"*I confirm that I am at least 18 years old\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(ageConfirmation));
        ageConfirmation.click();

        if (ageConfirmation.isSelected()) {
            System.out.println("Checkbox is selected");
        } else {
            System.out.println("Checkbox is not selected");
        }



//        Thread.sleep(1000);
//        WebElement el4 = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Sign In\"]"));
//        el4.click();

        Thread.sleep(2000);
        driver.quit();


    }
}





