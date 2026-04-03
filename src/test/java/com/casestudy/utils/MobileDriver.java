package com.casestudy.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MobileDriver {
    private static AndroidDriver driver;

    public static AndroidDriver getMobileDriver() {
        if (driver == null) {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName("Android")
                    .setAutomationName("UiAutomator2")
                    .setDeviceName("Pixel_7_API_29") // Emülatör isminizle aynı olmalı
                    .setApp(System.getProperty("user.dir") + "/src/test/resources/apps/ApiDemos-debug.apk")
                    .setNoReset(false);

            try {
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            } catch (MalformedURLException e) {
                throw new RuntimeException("Appium Server URL hatalı!");
            }
        }
        return driver;
    }

    public static void quitMobileDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}