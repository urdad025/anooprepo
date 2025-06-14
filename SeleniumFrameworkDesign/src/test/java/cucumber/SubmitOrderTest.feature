
@tag 
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file



	Background:
	Given I landed on Ecommerce page

  @Regression
  Scenario Outline: Positive test of Submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> from cart
    And Checkout <productName> and submit the order
    Then "Thankyou for the order." message is displayed on confirmarion page

    Examples: 
      | name  									| password 		| productName |
      | jackreacher007@gmail.com| Jack@1234 	|	ZARA COAT 3	|