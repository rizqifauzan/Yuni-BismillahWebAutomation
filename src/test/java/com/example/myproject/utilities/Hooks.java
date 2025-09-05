package com.example.myproject.utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);
    private WebDriver driver;

    // Hook untuk Web UI Tests
    @Before("@web") // Hanya jalankan hook ini untuk skenario dengan tag @web
    public void setupWeb(Scenario scenario) {
        logger.info("Setting up WebDriver for Web UI scenario: " + scenario.getName());
        driver = DriverFactory.getDriver();
    }

    @After("@web") // Hanya jalankan hook ini untuk skenario dengan tag @web
    public void tearDownWeb(Scenario scenario) {
        if (scenario.isFailed()) {
            logger.error("Scenario failed, taking screenshot: " + scenario.getName());
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        logger.info("Quitting WebDriver after Web UI scenario: " + scenario.getName());
        DriverFactory.quitDriver();
    }
}
