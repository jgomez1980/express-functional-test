@Browser @Express @MyAccount
Feature: My Account

  @Regression @MyAccount
  Scenario Outline: Validate My Account page as next user
    Given I am on the home page of Express.com
    When login as valid next user with <user> and <pass>  
    Then the site displays My account page

    Examples: 
      |user                        |pass|
      |"test_automation@email.com" |"Globant123"|
      
                