@Browser @Express @AccountOverview
Feature: My Account - Account Overview

      
  @Regression @AccountOverview
  Scenario Outline: Validate Points Progress Bar in Account Overview as next user
    Given I am on the home page of Express.com
    When login as valid next user with <user> and <pass>  
    Then the site displays the progress bar within the Account Overview section.

    Examples: 
      |user                        |pass|
      |"test_automation@email.com" |"Globant123"|     

  @Regression @AccountOverview  
  Scenario Outline: Validate Account Overview section as next user
    Given I am on the home page of Express.com
    When login as valid next user with <user> and <pass>  
    Then the site displays Account Overview section

    Examples: 
      |user                        |pass|
      |"test_automation@email.com" |"Globant123"|

      
                     