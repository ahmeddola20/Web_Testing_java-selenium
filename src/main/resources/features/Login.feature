Feature: User should be abel to login to the system

  # Test scenario 1
  Scenario: user login with valid user name and password
    Given user open browser
    And user navigate to login page

    When user enters valid username and password
     And usre click on login button
    #Expcted result
    Then user could login succesfully and go to home page
And user go to home page

    # Test scenario 2
  Scenario: user login with invalid user name and password

