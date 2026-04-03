package com.casestudy.stepdefinitions;

import com.casestudy.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) {
        // Eğer senaryo başarısız (fail) olursa ekran görüntüsü al ve rapora ekle
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName() + " - Fail Screenshot");
        }
        // Test bittiğinde driver'ı kapat
        Driver.quitDriver();
    }
}