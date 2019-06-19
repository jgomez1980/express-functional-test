@Browser @Express
Feature: Navigate to landing page

  @Regre_ssion 
  Scenario Outline: Validate search funcionality
    Given I am on the home page of Express.com
    When I search a <item> on the serch box  
    Then The page show all items that match with the criterion

    Examples: 
      | item|
      | "jeans" |
			| "skirt" |
