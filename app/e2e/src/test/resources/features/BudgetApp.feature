@all
Feature: BudgetApp Testing

  Background:
    Given open Budgeting App web

  Scenario: Check that Budget functionality exist on page
    When page is loaded - check navigation buttons
    And check that Budget grid exist and contains 3 elements
    And check Balance Container
    And check active fields for adding in budget changes

  Scenario: Check Reports functionality exist on page
    When page is loaded - check navigation buttons
    And open Reports page
    And check that Reports page contain 2 Panels

  Scenario: Check Budget functionality with Adding different categoryId
    When page is loaded - check navigation buttons
    And check that Budget grid exist and contains 3 elements
    And click on category field
#    And store Total Inflow sum
    Then click on category selector and choose inflow category Income
    Then click on description field and enter "Test"
    And enter value 100
    And click on Add button

  Scenario: Failed scenario. It will fail because button Add wil be disabled
    When page is loaded - check navigation buttons
    And check that Budget grid exist and contains 3 elements
    And click on category field
#    And store Total Inflow sum
    Then click on category selector and choose inflow category Income
    Then click on description field and enter "Test"

    And click on Add button


