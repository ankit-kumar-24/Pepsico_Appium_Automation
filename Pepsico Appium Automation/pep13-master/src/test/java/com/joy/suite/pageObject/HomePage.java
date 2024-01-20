package com.joy.suite.pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageObject{

    public HomePage(AppiumDriver driver) {
       super(driver);
    }

    @AndroidFindBy(id="com.sourcey.materialloginexample:id/action_bar")
    private WebElement actionBar;


    public boolean isInitialized() {
        return actionBar.isDisplayed();
    }

}