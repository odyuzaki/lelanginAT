Feature: Login as Valid credential

  Scenario: Login as user
    Given I in LP homepages
    When I click signin button
    And I input the usernames
    And Input password
    When I click sign in button
    Then I will success login

  Scenario: Login as admin
    Given I in LP homepages
    When I click signin button
    And I input the admin usernames
    And Input admin password
    When I click sign in button
    Then I will success login