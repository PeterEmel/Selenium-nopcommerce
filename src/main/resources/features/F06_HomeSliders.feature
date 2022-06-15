@smoke
  Feature: F06_homeSliders | users will be able to open sliders in home page
    Scenario: First slider is clickable on home page
      When First Slider is clicked
      Then Relative product for first slider is displayed

    Scenario: Second slider is clickable on home page
      When Second Slider is clicked
      Then Relative product for second slider is displayed
