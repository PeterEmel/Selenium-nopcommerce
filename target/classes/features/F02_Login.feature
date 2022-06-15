@smoke
  Feature: F02_Login | Users could use login functionality to use their account
    Scenario: User login with valid username and Password
      Given User is in login page
      And User enters valid email "test8@example.com" and valid password "P@assword"
      And User clicks on login button
      Then User logs in