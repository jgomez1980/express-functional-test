@Browser @Express @ShoppingBag
Feature: Shopping Bag
                           
  @Regression
  Scenario Outline: Validate Shopping bag page 
    Given I am on search page
    When navigate to shopping bag page for <bagId>   
    Then Shopping Bag page is displayed

    Examples: 
      |bagId                                  |
      |"6bfb4ef8-699b-450c-9829-1dcb812a6bd0" |
      |"a54982d1-846d-4683-a7f8-283ca143e56a" |  
      
  @Regression 
  Scenario Outline: Validate bag item section 
    Given I am on search page
    When navigate to shopping bag page for <bagId>   
    Then the bag item displays the name <ItemName> the quantity <Qty> and price <Price>

    Examples: 
      |ItemName                         |Qty|Price    |bagId                                  |
      |"BLACK BOMBERAK RAINCOAT"        |"7"|"$426.65"|"6bfb4ef8-699b-450c-9829-1dcb812a6bd0" |
      |"Frayed Shortie Denim Jacket"    |"4"|"$97"    |"a54982d1-846d-4683-a7f8-283ca143e56a" |                 
      
  @Regression 
  Scenario Outline: Validate bag item section and bag summary 
    Given I am on search page
    When navigate to shopping bag page for <bagId>   
    Then the bag item displays the name <ItemName> the quantity <Qty> and price <Price>
    And bag summary displays subtotal <Price> the shipping <Shipping> and tax <Tax>

    Examples: 
      |ItemName                         |Qty|Price    |Shipping     |Tax|bagId                            |
      |"BLACK BOMBERAK RAINCOAT"        |"8"|"$487.6"|"FREE Change"|"0"|"6bfb4ef8-699b-450c-9829-1dcb812a6bd0" |
      |"Frayed Shortie Denim Jacket"    |"4"|"$97"    |"FREE Change"|"0"|"a54982d1-846d-4683-a7f8-283ca143e56a" |




  @Regression
  Scenario Outline: Validate Shopping bag page 
    Given I create a bag
    When add the bag to cart  
    Then Shopping Bag page is displayed for <bagId>

    Examples: 
      |bagId                                  |
      |"6bfb4ef8-699b-450c-9829-1dcb812a6bd0" |
      |"a54982d1-846d-4683-a7f8-283ca143e56a" |           