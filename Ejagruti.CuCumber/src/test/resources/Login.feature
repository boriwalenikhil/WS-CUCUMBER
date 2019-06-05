
@Login
Feature: Login Feature

  Background:user is successfully logged in
  When user opens the "firefox" browser
  And user enter the url "http://192.168.0.222:90/finsys/login.html#"

  @SmokeTest 
  Scenario: Login Functionality for valid username and password
    When user enters "dummyfm" as username
    And user enters "passw0rd" as password
    And user clicks on login button
    Then user is on the application home page
    And user gets the message starting with "Welcome" on the top
    
    

  @smok1
  Scenario: Login Functionality for valid username and invalid password
  Given user is on the application login page
  When user enters "dummyfm" as username
  And user enters  "Password" invalid as password
  And user clicks on login button
  Then user is on the same login page
  And user get the message starting with "wrong" username

@smok2

  Scenario: Login Functionality for invalid username and valid password
  Given user is on the application login page
  When user enter "dummyFM" as username 
  And user enters "passw0rd" as password
  And user clicks on login button
  Then user is on the same login page
  And user get the message starting with "wrong" username
   


  @smok3
  Scenario: Login Functionality for blank username and  password
  Given user is on the application login page 
  When user enters "" as username
  And user enters "" as password
  And user clicks on login button
  Then user is on the same login page
  And user get the message starting with "wrong" username

  
  @smok4
  Scenario: Login Functionality by passing special characters in username and invalid   password
  Given user is on the application login page 
  When user enter "dummyfm" as username 
  And user enters "passw0rd" as password
  And user clicks on login button
  Then user is on the same login page
  And user get the message starting with "wrong" username



  
 
  