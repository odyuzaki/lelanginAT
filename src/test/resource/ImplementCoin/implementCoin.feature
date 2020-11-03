# new feature
# Tags: optional

Feature: Implement the coin page

  Scenario: As a user, I should see the coin page for checking my coins to start the bidding.
    Given User at homepage
    And user hover on the my coins menu
    When the user clicks on the coin details button
    Then the user should be navigated to the coin page

  Scenario: user should see the amount of user’s coins
    Given User at homepage
    And user hover on the my coins menu
    When the user clicks on the coin details button
    Then the user should be navigated to the coin page
    Then the user should see the amount of users coins