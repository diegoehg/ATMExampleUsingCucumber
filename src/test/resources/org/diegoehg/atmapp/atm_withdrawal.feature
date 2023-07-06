Feature: ATM Withdrawal
  As a customer
  I want to be able to withdraw money from my ATM account
  So that I can access my money when I need it

  Scenario: Withdraw money
    Given I have an ATM card
    And I have a balance of $100
    When I withdraw $50
    Then my balance should be $50
