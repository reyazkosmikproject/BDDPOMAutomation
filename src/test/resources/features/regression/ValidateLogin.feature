Feature: To validate Login Functionality

@smoke @regression
Scenario: To validate login using valid credentials

Given user is on LoginPage
When user enters text in textbox in LoginPage
|objectName | text |
|usernameTextBox | reyaz0617|
And user enters text in textbox in LoginPage
|objectName | text |
|passwordTextBox | reyaz123|
When user clicks on Button in LoginPage
|objectName|
|loginButton|
Then user validates title to be "Adactin.com - Search Hotel"

@regression
Scenario Outline: To validate login using Invalid credentials

Given user is on LoginPage
When user enters text in textbox in LoginPage
|objectName | text |
|usernameTextBox | <username>|
And user enters text in textbox in LoginPage
|objectName | text |
|passwordTextBox | <password>|
When user clicks on Button in LoginPage
|objectName|
|loginButton|
Then user validates title to be '<expTitle>'

Examples: 
| username | password | expTitle |
| reyaz0617 | reyaz456 | Adactin.com - Hotel Reservation System |
| reyaz1212 | reyaz123 | Adactin.com - Hotel Reservation System |
| reyaz1212 | reyaz456 | Adactin.com - Hotel Reservation System |


