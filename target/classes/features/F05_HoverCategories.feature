@smoke
  Feature: F05_hoverCategories | user could hover categories and select sub category
    Scenario: user could hover categories
      When User hovers on category and select subcategory
      Then User should be redirected to the chosen category or subcategory
