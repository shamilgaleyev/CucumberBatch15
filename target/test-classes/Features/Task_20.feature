Feature: Adding a different language

  @testcase20
  Scenario: admin is adding different languages in qualifications

    Given “Admin” user is logged in
    When “Admin” navigates to Qualifications
    And selects Language
    Then “Admin” user can add any Language