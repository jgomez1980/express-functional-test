@Browser @Express @EarnPoints
Feature: My Account - Earn Points

  @Regression @EarnPoints
  Scenario Outline: Validate Earn Points as next user
    Given I am on the home page of Express.com
    When login as valid next user with <user> and <pass>
    And select Earn Points navigation item  
    Then the site displays Earn Points section

    Examples: 
      |user                        |pass|
      |"test_automation@email.com" |"Globant123"|      
      
      
  @Regression @EarnPoints
  Scenario Outline: Validate "Be Social. Earn Rewards." label as next user
    Given I am on the home page of Express.com
    When login as valid next user with <user> and <pass>
    And select Earn Points navigation item  
    Then the site displays Earn Rewards label with text <labelText>

    Examples: 
      |user                        |pass        |labelText|
      |"test_automation@email.com" |"Globant123"|"Be Social. Earn Rewards."|   
      
      
  @Regression @EarnPoints
  Scenario Outline: Validate each Earn card displays Earn Rewards modal with rewards information as next user
    Given I am on the home page of Express.com
    When login as valid next user with <user> and <pass>
    And select Earn Points navigation item  
    Then select each Earns cards the site displays Earn Rewards modal with rewards information

    Examples: 
      |user                        |pass        |
      |"test_automation@email.com" |"Globant123"|  
  
   