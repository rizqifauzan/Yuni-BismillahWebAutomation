@web
Feature: Demoblaze Home Page Functionality

  As a user, I want to be able to navigate and interact with the Demoblaze home page
  So that I can browse products and access login/signup options

  @positive @smoke
  Scenario: Verify Home Page Loads Correctly
    Given I am on the "https://www.demoblaze.com/" homepage
    Then the "Login" link should be visible
    And the "Sign up" link should be visible
    And the carousel should be displayed

  @positive @navigation
  Scenario: Navigate to Login page
    Given I am on the "https://www.demoblaze.com/" homepage
    When I click on the "Login" link
    Then I should be on the login page


  @negative @login
  Scenario: Login with invalid credentials
    Given I am on the "https://www.demoblaze.com/" homepage
    And I click on the "Login" link
    And I should be on the login page
    When I attempt to login with username "invalid_user" and password "wrong_pass"
    Then I should see an alert with message "Wrong password."

  @boundary @login
  Scenario: Login with very long username (conceptual boundary test)
    Given I am on the "https://www.demoblaze.com/" homepage
    And I click on the "Login" link
    And I should be on the login page
    # Menggunakan placeholder untuk username yang sangat panjang
    When I attempt to login with a very long username and password "password"
    Then I should see an alert with message "User does not exist."