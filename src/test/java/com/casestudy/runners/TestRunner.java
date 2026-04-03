package com.casestudy.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.casestudy.stepdefinitions",
        plugin = {
                "pretty",
                "html:target/default-cucumber-report.html",
                "json:target/cucumber.json", // Raporlayıcının ihtiyaç duyduğu ana dosya
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {
}