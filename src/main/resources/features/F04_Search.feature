@smoke
  Feature: F04_Search | users will be able to search for products with different parameters
    Scenario: user could search using product name
      When User search for a product e.g. "Apple"
      And User Clicks on Search Button
      Then Website will show the products related to search


    Scenario: user could search using product SKU
      When User search for a product by SKU e.g. "AP_MBP_13"
      And User Clicks on Search Button again
      Then Website will show the products related to search SKU