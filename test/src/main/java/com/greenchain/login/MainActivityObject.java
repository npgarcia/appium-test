package com.greenchain.login;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MainActivityObject {
    private AndroidDriver<MobileElement> driver;
    private MobileElement text;

    public MainActivityObject(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        text = driver.findElementById("io.grainchain.logintest:id/textview_first");
    }

    public String getUserName() {
        String userName = text.getText().replace("Hello ","");
        return userName;
    }
}
