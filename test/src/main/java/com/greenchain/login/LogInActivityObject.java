package com.greenchain.login;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LogInActivityObject {
    private AndroidDriver<MobileElement> driver;
    private MobileElement username;
    private MobileElement pass;
    private MobileElement button;


    public LogInActivityObject(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        username = driver.findElementById("io.grainchain.logintest:id/username");
        pass = driver.findElementById("io.grainchain.logintest:id/password");
        button = driver.findElementById("io.grainchain.logintest:id/login");
    }

    public void logIn(String user, String password) {
        username.sendKeys(user);
        pass.sendKeys(password);
        button.click();
    }

    public void typeInUser(String user) {
        username.sendKeys(user);
    }

    public void typeInPassword(String password) {
        pass.sendKeys(password);
    }

    public boolean isButtonEnabled() {
        return button.isEnabled();
    }
}
