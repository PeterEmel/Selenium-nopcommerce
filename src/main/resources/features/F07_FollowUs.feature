@smoke
  Feature: F07_followUs | users could open followUs links
    Scenario: User click on Facebook button to follow nopCommerce
      When User opens Facebook link
      Then "https://www.facebook.com/nopCommerce" opens Facebook page in new tab

    Scenario: User click on Twitter button to follow nopCommerce
      When User opens Twitter link
      Then "https://twitter.com/nopCommerce" opens Twitter page in new tab

    Scenario: User click on rss button to follow nopCommerce
      When User opens rss link
      Then "https://demo.nopcommerce.com/new-online-store-is-open" opens rss page in new tab

    Scenario: User click on Youtube button to follow nopCommerce
      When User opens Youtube link
      Then "https://www.youtube.com/user/nopCommerce" opens Youtube page in new tab