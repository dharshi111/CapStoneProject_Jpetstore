
@registrationpage
Feature: Registration
 
Background: 
   When I click enter store link
   And Its navigate to home page
   Then I click signin page
 #  @register 
  #Scenario: registering into that website
   #When I enter all details
   #Then I verify account is created
   @validlogin
   Scenario Outline: login with valid username and valid password
   And I enter valid username "<username>" 
   And I enter valid password "<password>" 
   Then I click login button
   
   Examples:
   |username  | password |
   |userid    |pass123   |
    @invalidlogin
   Scenario Outline: login with invalid username and invalid password
   And I enter invalid username "<username>"
   And I enter invalid password "<password>"
   Then I click login button
   
   Examples:
   |username  | password |
   |user_&    |123   |
     @invalidusername
   Scenario Outline: login with invalid username and valid password
    And I enter invalid username "<username>" 
    And I enter valid password "<password>" 
   Then  I click login button
   
   Examples:
   |username  | password |
   |user_@    |pass1234   |
      @invalidpassword
   Scenario Outline: login with valid username and invalid password
  And I enter valid username "<username>" 
  And I enter invalid password "<password>" 
   Then I click login button
   
   Examples:
   |username  | password |
   |userid    |  1_234   |
   
   @passwordrecovery
   Scenario: verify password recovery link
   Then I click password recovery link
   

 
