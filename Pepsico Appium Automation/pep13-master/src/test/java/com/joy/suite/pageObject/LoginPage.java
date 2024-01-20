package com.joy.suite.pageObject;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    protected AppiumDriver driver;

    @AndroidFindBy(id = "//android.widget.Button[@content-desc=\"Log In\"]")
    private WebElement LogInButton;

    // Android Locators
    @AndroidFindBy(id = "//android.widget.ScrollView/android.widget.EditText[1]")
    private WebElement androidUserNameField;

    @AndroidFindBy(id = "//android.widget.ScrollView/android.widget.EditText[2]")
    private WebElement androidPasswordField;

    @AndroidFindBy(id = "//android.widget.Button[@content-desc=\"Sign In\"]")
    private WebElement androidLoginButton;

    // iOS Locators
    @iOSXCUITFindBy(id = "username")
    private WebElement iOSUsernameField;

    @iOSXCUITFindBy(id = "password")
    private WebElement iOSPasswordField;

    @iOSXCUITFindBy(id = "loginButton")
    private WebElement iOSLoginButton;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    // Methods to interact with the elements
    public void LogInButton() {
        if (isAndroid()) {
            LogInButton.click();
        } else if (isIOS()) {
            LogInButton.click();
        }
    }

    // Methods to interact with the elements
    public void enterUsername(String username) {
        if (isAndroid()) {
            androidUserNameField.sendKeys(username);
        } else if (isIOS()) {
            iOSUsernameField.sendKeys(username);
        }
    }

    public void enterPassword(String password) {
        if (isAndroid()) {
            androidPasswordField.sendKeys(password);
        } else if (isIOS()) {
            iOSPasswordField.sendKeys(password);
        }
    }

    public void clickLoginButton() {
        if (isAndroid()) {
            androidLoginButton.click();
        } else if (isIOS()) {
            iOSLoginButton.click();
        }
    }

    private boolean isAndroid() {
        return driver instanceof AndroidDriver;
    }

    private boolean isIOS() {
        return driver instanceof IOSDriver;
    }
}

