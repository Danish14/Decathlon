Feature: Validate Order Page
  Scenario Outline: Validate Order summary - Price & Quantity
    Given Launch Browser
    When Open Decathlon Application
    And Search For "<Product>"
    And Open Product
    And Select "<Size>" And Add To Cart
    And Go To Cart
    Then Validate Order "<Price>" and "<Quantity>" Details
    And Proceed To Checkout And Take ScreenShot
    Then Close Browser

    Examples:
      | Product | Size | Price|Quantity|
      | Boxing glove | 8oz |  ₹ 1,299    |  1 |





