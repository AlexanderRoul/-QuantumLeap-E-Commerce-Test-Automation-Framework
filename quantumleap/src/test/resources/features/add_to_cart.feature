@ui @add_to_cart
Feature: Add Item to Cart
  As a shopper
  I want to add an item to my cart
  So that I can purchase it later

  Scenario: Add backpack to cart
    Given I am on the Sauce Demo login page
    When I login as "standard_user" with password "secret_sauce"
    And I add the Sauce Labs Backpack to the cart
    Then the cart badge should show "1"