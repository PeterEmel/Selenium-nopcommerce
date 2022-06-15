@smoke
Feature: F01_Register | users could register with new accounts


  Scenario: Guest user could register with valid data successfully
    Given user go to register page
    When user choose gender type
    And User enters first name "automation" and last name "tester"
    And User enters date of birth
    And User Enter email "test7@example.com"
    And user fills password field "P@assword" and confirm the password
    And User clicks on register button
    Then Success message is displayed