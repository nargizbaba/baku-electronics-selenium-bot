@Checkout
Feature: Checkout Process
  As a user
  I want to proceed through the checkout process
  So that I can complete my purchase

  Scenario Outline: Completing the checkout process
    Given the user clicks on the Proceed to Checkout button
    When the user enters their phone number "<phone_number>"
    And the user selects the location to pick up the product
    Then the user chooses the payment method
    Then the user completes the order

    Examples:
      | phone_number    |
      | 506673459       |
