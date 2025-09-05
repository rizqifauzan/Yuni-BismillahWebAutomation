package com.example.myproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class HomePage {
    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);
    private final WebDriver driver;
    private final WebDriverWait wait;
    // Locators
    @FindBy(id = "login2")
    public WebElement loginLink;

    @FindBy(id = "signin2")
    public WebElement signUpLink;

    @FindBy(id = "nava") // Brand link (HOME)
    public WebElement homeBrandLink;

    @FindBy(className = "carousel-inner") // Carousel utama
    public WebElement carousel;

    @FindBy(xpath = "//a[contains(text(),'Phones')]")
    public WebElement phonesCategory;

    @FindBy(xpath = "//a[contains(text(),'Laptops')]")
    public WebElement laptopsCategory;

    @FindBy(xpath = "//a[contains(text(),'Monitors')]")
    public WebElement monitorsCategory;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Tunggu eksplisit
        PageFactory.initElements(driver, this); // Inisialisasi elemen halaman
        logger.info("HomePage Page Object initialized.");
    }

    public void navigateToHomePage(String url) {
        logger.info("Navigating to Home Page: " + url);
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOf(homeBrandLink)); // Tunggu elemen kunci muncul
    }

    public boolean isLoginLinkVisible() {
        return wait.until(ExpectedConditions.visibilityOf(loginLink)).isDisplayed();
    }

    public boolean isSignUpLinkVisible() {
        return wait.until(ExpectedConditions.visibilityOf(signUpLink)).isDisplayed();
    }

    public boolean isCarouselDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(carousel)).isDisplayed();
    }

    public void clickLoginLink() {
        logger.info("Clicking Login link.");
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
    }

    public void clickSignUpLink() {
        logger.info("Clicking Sign Up link.");
        wait.until(ExpectedConditions.elementToBeClickable(signUpLink)).click();
    }

    public void clickCategory(String category) {
        logger.info("Clicking category: " + category);
        switch (category.toLowerCase()) {
            case "phones":
                wait.until(ExpectedConditions.elementToBeClickable(phonesCategory)).click();
                break;
            case "laptops":
                wait.until(ExpectedConditions.elementToBeClickable(laptopsCategory)).click();
                break;
            case "monitors":
                wait.until(ExpectedConditions.elementToBeClickable(monitorsCategory)).click();
                break;
            default:
                logger.error("Category '{}' not recognized.", category);
                throw new IllegalArgumentException("Invalid category: " + category);
        }
    }
}
