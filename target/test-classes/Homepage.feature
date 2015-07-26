Feature: Testing for Signin

Scenario: Checking for Successful login action.
         Given I am in Sign in page
         When I am entering with valid credentials
         Then I am able to see the Inbox