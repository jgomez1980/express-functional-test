@Browser @Express @Settings
Feature: My Account - Settings
 
  @Regression @Settings
  Scenario Outline: Validate settings page as next user
    Given I am on the home page of Express.com
    When login as valid next user with <user> and <pass>
    And select setting navigation item  
    Then the site displays settings page

    Examples: 
      |user                        |pass|
      |"test_automation@email.com" |"Globant123"|   
  
      
               