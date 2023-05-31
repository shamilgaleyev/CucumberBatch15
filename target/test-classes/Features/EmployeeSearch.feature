Feature: Searching the employee

  Background:
    When user enters valid email and valid password
    And click on login button
    When user clicks on PIM option

  @smoke1
  Scenario: Search Employee by ID
    #Given open the browser and launch HRMS application
#    When user enters valid email and valid password
#    And click on login button
#    When user clicks on PIM option
    When user enters valid employee id
    And Click on search button
    And user see employee information is displayed
    #And Close the browser

    @smoke1
    Scenario: Search Employee by Jop Title

      #Given open the browser and launch HRMS application
#      When user enters valid email and valid password
#      And click on login button
#      When user clicks on PIM option
      When user select Job Title
      And Click on search button
      And user see employee information is displayed
      #And Close the browser