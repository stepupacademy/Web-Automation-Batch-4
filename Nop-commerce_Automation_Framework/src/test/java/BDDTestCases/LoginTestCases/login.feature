Feature: Login Functionality

  Scenario: Valid Login
    Given user navigate to login page
    When user enters username "StepUp@Test.com" and password "Test123"
    And user clicks on login button
    Then Welcome message appears

    Scenario Outline: InValid Login
      Given user navigate to login page
      When user enters username "<username>" and password "<password>"
      And user clicks on login button
      Then Error message appears
      Examples:
        |username  | password|
        | StepUP   | password |
        | StepUP1   | password |
        | StepUP2  | password |

