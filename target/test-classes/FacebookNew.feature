Feature: To Validate the login functionality in fb applcation

  Scenario: To Valiate with invalid username and invalid password
    Given User has to launch the chrome browser and max the window
    When User has to launch the fb applicaion in browser
    And User has to pass invalid username in email field
    And User has to pass invalid password in password field
    And User has to click the login browser
    Then User has to close the browser

  Scenario Outline: to validate the positive and negative combination in login field
    Given user has to launch the chrome and max the window
    When user has to launch the url
    And To pass the bulk of "<emailField>" datas to email field
    And to pass the bulk of "<passField>" datas to password field
    And to click the login button
    Then user has to close the browser

    Examples: 
      | emailField         | passField  |
      | tfdnf@gmail.com    |   85585895 |
      | jgcjgujg@gmail.com |    7858588 |
      | fdyyjdyj@gmail.com | 8689kj68   |
      | hfdhdh@gmail.com   | 696886bb88 |
