package io.grainchain.logintest;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private WebDriver driver;

    @Before
    public void launchApp() {
        DesiredCapabilities capability = DesiredCapabilities.android();
        capability.setCapability("appPackage","io.grainchain.logintest");
        capability.setCapability("appActivity", ".ui.login.MainActivity");

        try {
            URL url = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver<>(url, capability);
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("io.grainchain.logintest", appContext.getPackageName());
    }

    @Test
    public void validEmail() {
        System.out.println("here");
    }
}
