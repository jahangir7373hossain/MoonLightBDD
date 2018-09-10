Feature: Registration Feature

  Scenario Outline: Test Registration feature first name using valid cradentials
    Given User open the url on browser
    Then user click on registration feature
    And user enters the "<First Name>"
    Then user click on submit button
    Then verify the message
    And close the window

    Examples: 
      | First Name |
      | Mohammed   |

  Scenario Outline: Test Registration feature first name with invalid credentials
    Given User open the url on browser
    Then user click on registration feature
    And user enters the "<First Name>"
    Then user click on submit button
    Then verify the error messages
    And close the window

    Examples: 
      | First Name                           |
      |                                      |
      | gfffdhhdhgdgfdghdhdjuqshquyfd7632fe7 |

  Scenario Outline: Test Registration feature last name using valid cradentials
    Given User open the url on browser
    Then user click on registration feature
    And user enters the Last name as "<Last name>"
    Then user click on submit button
    Then verify the message for last name
    And close the window

    Examples: 
      | Last name |
      | Hossain   |

  Scenario Outline: Test Registration feature last name using invalid cradentials
    Given User open the url on browser
    Then user click on registration feature
    And user enters the Last name as "<Last name>"
    Then user click on submit button
    Then verify the error message for last name
    And close the window

    Examples: 
      | Last name                           |
      |                                     |
      | gfffdhhdhgdgfdghdhdjuqshjsuhbhsdhah |

  Scenario: Test User Type feature with valid cradentials
    Given User open the url on browser
    Then user click on registration feature
    And select the user type
    Then user click on submit button
    And vrify the user type drop down element
    And close the window
