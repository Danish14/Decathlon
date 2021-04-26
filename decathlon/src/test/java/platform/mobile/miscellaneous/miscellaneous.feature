Feature: miscellaneous
  Background:
    Given Open Decathlon Mobile Applications
    And Allow Permissions
    And Skip Tour
    And Skip Login
    And Skip Navigation Tour

  Scenario Outline: Search for a product. Verify the list
    When Search For The "<Product>"
    Then Verify The List
    Examples:
      | Product |
      |Glove    |

  Scenario Outline: Add a product to the cart. Verify that the added product is in the cart.
    When Search For The "<Product>"
    And Open The Product
    And Add To Bag
    And Select "<Size>"
    And View Cart
    Then Verify The "<ProductName>" In Cart

    Examples:
      | Product |Size|ProductName|
      |Glove    |XS/S|Adult Mountain Trekking Recycled Polyester Liner Gloves - TREK 100 Black|
  Scenario Outline: Increase the number of items in the cart to 10. Verify that the total price changed.
    When Search For The "<Product>"
    And Open The Product
    And Add To Bag
    And Select "<Size>"
    And View Cart
    And Increase The Items
    Then Verify The "<Price>"
    Examples:
      | Product |Size|Price|
      |Glove    |XS/S|₹ 1,119.00|

  Scenario Outline: Add another product. Verify cart change.
    When Search For The "<Product>"
    And Open The Product
    And Add To Bag
    And Select "<Size>"
    And View Cart
    And Navigate Back To List
    And Open Second Product
    And Add To Bag
    And Select "<Size2>"
    And View Cart
    Then Verify The "<UpdatedPrice>"
    Examples:
      | Product |Size|Size2|UpdatedPrice|
      |Glove    |XS/S|M|₹ 1027.00     |

  Scenario Outline: Remove a product from the cart. Verify the change.
    When Search For The "<Product>"
    And Open The Product
    And Add To Bag
    And Select "<Size>"
    And Open Cart
    And Navigate Back To List
    And Open Second Product
    And Add To Bag
    And Select "<Size2>"
    And View Cart
    And Remove Product
    Then Verify The "<UpdatedPrice>"
    Examples:
      | Product |Size|Size2|UpdatedPrice|
      |Glove    |XS/S|M|₹ 228.00     |