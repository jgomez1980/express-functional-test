@Browser @Express @Search
Feature: Search funcionality

  @Regression @Search
  Scenario Outline: Validate search functionality from header section
    Given I am on search page
    When I search a <item> on the serch box  
    Then The site displays all items that match with the criteria
    And the number of results of the search is <Amount Result>

    Examples: 
      |item       |Amount Result|
      |"metallic" |"1168"       |
      |"07920883" |"1"          |
      |"jump suit"|"1518"       |
      
  @Regression @Search
  Scenario Outline: Validate search for SKU functionality from header section
    Given I am on search page
    When I search a <item> on the serch box  
    And select the first item found
    Then the number of results of the search is <Amount Result>
    And the item found contains the SKU <item>

    Examples: 
      |item       |Amount Result|
      |"07920883" |"1"          |      
      
##################################

  @Regression @Search 
  Scenario Outline: Search in the main screen
    Given I am on main screen page
    When I search a <item> on the serch box  
    Then The site displays all items that match with the criteria
    And the number of results of the search is <Amount Result>

    Examples: 
      |item       |Amount Result|
      |"metallic" |"1168"       |
      |"07920883" |"1"          |
      |"jump suit"|"1518"       |             
 
   @Regression @Search
  Scenario Outline: Search from main page and add a item to bag
    Given I am on main screen page
    When I search a <item> on the serch box
    And select the first item found
    And select color <Color> and size <Size> 
    And add to bag selected item  
    And go to view my bag 
		Then Shopping Bag page is displayed

    Examples: 
      |item      |Amount Result|Color|Size|
      |"07920883"|"1"          |"Black"|"00"|
      |"09390005"|"1"          |"Black"|"38"|  
      
   @Regression @Search
  Scenario Outline: Search from main page and add a item to bag and validate bag item section
    Given I am on main screen page
    When I search a <item> on the serch box
    And select the first item found
    And select color <Color> and size <Size> 
    And add to bag selected item  
    And go to view my bag 
    Then the bag item displays the name <ItemName> the quantity <Qty> and price <Price>

    Examples: 
      |item      |Amount Result|Color  |Size|ItemName                            |Qty|Price    |
      |"07920883"|"1"          |"Black"|"00"|"Strapless Sweetheart Neck Jumpsuit"|"1"|"$88.00" |
      |"09390005"|"1"          |"Black"|"38"|"Slim Atlanta Hawks NBA Performance"|"1"|"$278.00"|  
      
  @Regression @Search 
  Scenario Outline: Search from main page and add a item to bag and validate bag item section and bag summary
    Given I am on main screen page
    When I search a <item> on the serch box
    And select the first item found
    And select color <Color> and size <Size> 
    And add to bag selected item  
    And go to view my bag 
    Then the bag item displays the name <ItemName> the quantity <Qty> and price <Price>
		And bag summary displays subtotal <Price> the shipping <Shipping> and tax <Tax>

    Examples: 
      |item      |Amount Result|Color  |Size|ItemName                            |Qty|Price    |Shipping|Tax|
      |"07920883"|"1"          |"Black"|"00"|"Strapless Sweetheart Neck Jumpsuit"|"1"|"$88.00" |"$0"    |"" |
      |"09390005"|"1"          |"Black"|"38"|"Slim Atlanta Hawks NBA Performance"|"1"|"$278.00"|"$0"    |"" |  
      
 @Regression @Search @Ongoing
  Scenario Outline: Search from main page and add two diferent items to bag and validate bag item section and bag summary
    Given I am on main screen page
    When I search a <item> on the serch box
    And select the first item found
    And select color <Color> and size <Size> 
    And add to bag selected item
    And I search a <item2> on the serch box
    And select the first item found
    And select color <Color2> and size <Size2>
    And add to bag selected item  
    And go to view my bag 
    Then Shopping Bag page is displayed
    And the bag item displays for the item <ItemName> the quantity <Qty> and price <Price>
    And the bag item displays for the item <ItemName2> the quantity <Qty2> and price <Price2>
		And bag summary displays subtotal <Total> the shipping <Shipping> and tax <Tax>

    Examples: 
      |item      |Color  |Size|ItemName                            |Qty|Price    |Total    |Shipping|Tax|item2     |Color2 |Size2|ItemName2                           |Qty2|Price2   |
      |"07920883"|"Black"|"00"|"Strapless Sweetheart Neck Jumpsuit"|"1"|"$88.00" |"$366.00"|"$0"    |"" |"09390005"|"Black"|"38" |"Slim Atlanta Hawks NBA Performance"|"1" |"$278.00"|                         