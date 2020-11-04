package com.greenchain.login;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class TestLogin {
    private LogInActivityObject logInActivityObject;
    private AndroidDriver<MobileElement> driver;

    @Before
    public void setUp() {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        capability.setCapability("appPackage","io.grainchain.logintest");
        capability.setCapability("appActivity", ".ui.login.LoginActivity");

        try {
            driver = new AndroidDriver<MobileElement>(
                    new URL("http://localhost:4723/wd/hub"), capability);
            logInActivityObject = new LogInActivityObject(driver);
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @After
    public void quit() {
        driver.quit();
    }

    @Test
    public void sameName() {
        String name = "nadia@me.com";
        logInActivityObject.logIn(name, "123456");

        MainActivityObject mainActivity = new MainActivityObject(driver);
        Assert.assertEquals(name,mainActivity.getUserName());
    }

    @Test
    public void inactiveButton() {
        String password = "123456";

        logInActivityObject.typeInUser("nadia@me.com");

        for (int i = 0; i < password.length()-1; i++) {
            logInActivityObject.typeInPassword(password.substring(0, i+1));
            Assert.assertFalse(logInActivityObject.isButtonEnabled());
        }

        logInActivityObject.typeInPassword(password);
        Assert.assertTrue(logInActivityObject.isButtonEnabled());
    }
}
