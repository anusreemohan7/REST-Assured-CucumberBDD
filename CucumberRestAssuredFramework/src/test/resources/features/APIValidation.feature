Feature: API Validation for different methods

  @test
  Scenario: Get method validation 
  
    Given I want to execute getUserList endpoint
    When I submit the GET request
    Then I should get 200 success status code
    
  @test
  Scenario: Get method validation for error code
  
    Given I want to execute getUserList endpoint
    When i submit the GET request for invalid user
    Then I should get 404 success status code for invalid user
    
  @test
  Scenario: POST method validation for success status code
  
    Given I want to execute createUser endpoint
    When i submit the POST request for create user
    Then I should get 200 success status code along with the response body
    
  @test
  Scenario: POST method validation for error status code
  
    Given I want to execute createUser endpoint
    When i submit the POST request for create user with only email 
    Then I should get 400 error status code along with the response body
  @test
  Scenario: PUT method validation for success status code
  
   Given I want to execute createUser endpoint
    When i submit the PUT request to update user
    Then I should get 200 success status code in the put response 

 @test
  Scenario: Delete method validation 
  
   Given I want to delete createUser endpoint
    When i submit the Delete request 
    Then I should get 204 success status code in the delete response 
 