#Author: Guillermo Velasquez - gvelasquez_24@live.com

@tag
Feature: QA Team Test
  
  @QATEAM
  Scenario: Orange HRM Login Test
    Given User open the Orange HRM Login page
    And User enter the username
    And User enter the password
    When User click the login button
    Then User is logged in the page

