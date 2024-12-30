Feature: Search hotel
  Scenario: Looking for 'Akra Kemer'
    Given booking search page is opened
    When user searches for "Akra Kemer" hotel
    Then "Akra Kemer - Ultra All Inclusive" hotel is shown
    And "Akra Kemer - Ultra All Inclusive" hotel has rating "Scored 9.1"

  Scenario Outline: Looking for specific hotel
    Given booking search page is opened
    When user searches for "<hotel>" hotel
    Then "<expectedResult>" hotel is shown
    And "<expectedResult>" hotel has rating "<rating>"
    Examples:
      | hotel | expectedResult | rating
      | Akra Kemer |  Akra Kemer - Ultra All Inclusive | Scored 9.1
      | Meraki | Meraki Resort - Adults Only | Scored 9.0