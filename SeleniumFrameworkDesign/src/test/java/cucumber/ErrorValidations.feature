
@tag
Feature: Error Validation
  I want to use this template for my feature file


  @ErrorValidation
  Scenario Outline: Error Validation on providing incorrect username password
    Given I landed on Ecommerce page
    When Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed.

    Examples: 
      | name  									| password 		|
      | jackreacher007@gmail.com| Jack@1111 	|
