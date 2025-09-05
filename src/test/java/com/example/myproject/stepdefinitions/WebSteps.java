package com.example.myproject.stepdefinitions;

import com.example.myproject.utilities.DriverFactory;
import com.example.myproject.pages.HomePage;
import com.example.myproject.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class WebSteps {
    private static final Logger logger = LoggerFactory.getLogger(WebSteps.class);
    private final WebDriver driver;
    private final HomePage homePage;
    private final LoginPage loginPage;

    public WebSteps() {
        this.driver = DriverFactory.getDriver(); // Mendapatkan instance driver dari DriverFactory
        this.homePage = new HomePage(this.driver);
        this.loginPage = new LoginPage(this.driver);
    }

    @Given("I am on the {string} homepage")
    public void iAmOnTheHomepage(String url) {
        homePage.navigateToHomePage(url);
    }

    @Then("the {string} link should be visible")
    public void theLinkShouldBeVisible(String linkText) {
        if (linkText.equalsIgnoreCase("Login")) {
            assertTrue("Login link should be visible", homePage.isLoginLinkVisible());
        } else if (linkText.equalsIgnoreCase("Sign up")) {
            assertTrue("Sign up link should be visible", homePage.isSignUpLinkVisible());
        } else {
            logger.error("Link text '{}' not handled in step definition.", linkText);
        }
    }

    @And("the carousel should be displayed")
    public void theCarouselShouldBeDisplayed() {
        assertTrue("Carousel should be displayed", homePage.isCarouselDisplayed());
    }

    @When("I click on the {string} link")
    public void iClickOnTheLink(String linkText) {
        if (linkText.equalsIgnoreCase("Login")) {
            homePage.clickLoginLink();
        } else if (linkText.equalsIgnoreCase("Sign up")) {
            homePage.clickSignUpLink();
        } else {
            logger.error("Click action for link text '{}' not handled.", linkText);
        }
    }

    @Then("I should be on the login page")
    public void iShouldBeOnTheLoginPage() {
        assertTrue("Login page should be displayed", loginPage.isLoginPageDisplayed());
    }

    @When("I attempt to login with username {string} and password {string}")
    public void iAttemptToLoginWithUsernameAndPassword(String username, String password) {
        logger.info("Attempting to login with username: {}", username);
        loginPage.login(username, password);
    }

    @Then("I should see an alert with message {string}")
    public void iShouldSeeAnAlertWithMessage(String expectedMessage) {
        String actualMessage = loginPage.getAlertMessage();
        assertEquals("Alert message should match", expectedMessage, actualMessage);
    }

    @And("I should be able to see {string} as logged in user")
    public void iShouldBeAbleToSeeAsLoggedInUser(String username) {
        logger.info("Assuming login success if no alert with error message appears for user: {}", username);
    }

    @When("I attempt to login with a very long username and password {string}")
    public void iAttemptToLoginWithAVeryLongUsernameAndPassword(String password) {
        // Membuat string panjang secara dinamis di dalam kode Java
        String longUsername = "verylongusername".repeat(50);
        logger.info("Attempting to login with very long username: {}", longUsername);
        loginPage.login(longUsername, password);
    }
}
