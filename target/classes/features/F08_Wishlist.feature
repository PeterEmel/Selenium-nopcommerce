@smoke
  Feature: F08_Wishlist | user could add products to wishlist
    Scenario: User adds HTC to wishlist
      When User clicks on add to wishlist button
      Then success message "The product has been added to your wishlist" with green background color "rgba(75, 176, 122, 1)" will be displayed

    Scenario: Check that product is added in wishlist page
      When User clicks on product wishlist button
      And User is redirected to wishlist page after success message disappear
      Then The added product is displayed in the wishlist page

