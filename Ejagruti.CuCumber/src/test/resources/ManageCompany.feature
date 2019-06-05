
@CreateComapny
Feature: Create Company
 Background: user is successfully logged in
  	When user opens the "firefox" browser
  	And user enter the url "http://192.168.0.222:90/finsys/login.html#"
  	Then user is on the application login page
    When user enters "dummyfm" as username
    And user enters "passw0rd" as password
    And user clicks on login button
    Then user is on the application home page
    And user gets the message starting with "Welcome" on the top

    
@SmokeTest1 
 Scenario: Create Company with all valid inputs
  When I click on manage company 
  And  I click on New button 
When i enter company name as "MPTEK"
And i select company type as "IT"
And i select company subtype as "SUPPORT"
And i select company address as "shree nagar"
And i select company phone as "9423138805"
And i select company Email  as "boriwale.n@gmail.com"
And i select company pan details as "APCPB441213"
And  i select company Tin details as "8282827272"
And  i select company mobile as "98989898"  
And i select company country as "INDIA"
And  i select company state as "MAHARASHTRA"
And  i select company city as "NANDED"
And  i select company website as "mobiextend.com"
And  i select company total employee as "456"

And i click on Save button 
#Then I should see saved name "" in the first row of table


@SmokeTest2
 Scenario: Create Company with blank inputs
  When I click on manage company 
  And  I click on New button 
 When i enter company name as "" 
And i select company type as ""
And i select company subtype as ""
And i select company address as ""
And i select company phone as ""
And i select company Email  as ""
And i select company pan details as ""
And  i select company Tin details as ""
And  i select company mobile as "" 
And i select company country as ""
And  i select company state as ""
And  i select company city as ""
And  i select company website as ""
And  i select company total employee as ""

And i click on Save button 
#Then I should see Please enter all filed data.


 @SmokeTest3
 Scenario: Create Company with partial valid & partial invalid inputs
  When I click on manage company 
  And  I click on New button 
When i enter company name as "mobiextend" 
And i select company type as "IT"
And i select company subtype as " mobile application"
And i select company address as " viman nagar"
And i select company phone as " 88884"
And i select company Email  as "n@gmail.com"
And i select company pan details as "123"
And  i select company Tin details as "124"
And  i select company mobile as "123"
And i select company country as "INDIA"
And  i select company state as "MAHARASHTRA"
And  i select company city as "NANDED"
And  i select company website as "mobiextend.com"
And  i select company total employee as "99"

And i click on Save button 
#Then I should see error message Please enter Correct 10 digit mobile number.

 
 @SmokeTest4
 Scenario: Create Company by passing only mandatory details
  When I click on manage company 
  And  I click on New button 
When i enter company name as "Select company name" 
And i select company type as "IT"
And i select company subtype as " mobile application"
And i select company address as " viman nagar"
And i select company phone as " 88884"
And i select company Email  as "n@gmail.com"
And i select company pan details as "54635"
And  i select company Tin details as "456"
And  i select company mobile as "Enter Mobile number"
And  i select company state as "MAHARASHTRA"
And  i select company city as "NANDED"
And  i select company country as "INDIA"
And  i select company website as "mobiextend.com"
And  i select company total employee as "99"

And i click on Save button 
#Then I should see error message Please enter Correct 10 digit mobile number And Company name .


@SmokeTest5
Scenario: Create company using duplicate company name and valid details 

  When I click on manage company 
  And  I click on New button 
   When I click on manage company 
   And  I click on New button 
   When i enter company name as "TCS"
And i select company type as "IT"
  And i select company subtype as "SUPPORT"
And i select company address as "shree nagar"
And i select company phone as "9423138805"
And i select company Email  as "boriwale.n@gmail.com"
And i select company pan details as "123234"
And  i select company Tin details as "4546"
And  i select company mobile as "98989898"  
And i select company country as "INDIA"
And  i select company state as "MAHARASHTRA"
And  i select company city as "NANDED"
And  i select company website as "mobiextend.com"
And  i select company total employee as "456"
And i click on Save button 
#Then I should see error message as "Company Already Exists.Please Select different Company Name!!!"
 