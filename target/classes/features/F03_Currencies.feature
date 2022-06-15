@smoke
  Feature: F03_currencies | User could switch between currencies
    Scenario: User moves between currencies
      When User select random currency
      Then currency is changed in Home Page correctly

