Feature: Login Feature

  Scenario: Test Login feature with valid cradentials
    Given User open the application on browser
    When User click on the log in feature
    And User enter the email "shakil_ipe@yahoo.com"
    And User enter the password "365827"
    Then User click on log in button
    And Verify user loged in successfully
    Then Driver quit
    
     Scenario: Test Login feature with empty username and password
    Given User open the application on browser
    When User click on the log in feature
    And User enter the email ""
    And User enter the password ""
    Then User click on log in button
    And Veryfy the error of username and password
    Then Driver quit

  Scenario Outline: Test Login with invalid cradentials
    Given User open the application on browser
    When User click on the log in feature
    And User enter the email "<username>"
    And User enter the password "<password>"
    Then User click on log in button
    And Verify the error meaasge
    Then Driver quit

    Examples: 
      | username             | password |
      | shakil_ipe@yaho.com  |   365827 |
      | shakil_ipe@yahoo.com |    36582 |
      
