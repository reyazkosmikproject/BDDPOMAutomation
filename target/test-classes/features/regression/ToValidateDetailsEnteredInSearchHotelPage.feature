Feature: To validate details entered in Search Hotel Page
 
  @wip0603
  Scenario: Verify Search Hotel Details
    Given user is on LoginPage
		When user enters text in textbox in LoginPage
		|objectName | text |
		|usernameTextBox | reyaz0617 |
		And user enters text in textbox in LoginPage
		|objectName | text |
		|passwordTextBox | reyaz123 |
		When user clicks on Button in LoginPage
		|objectName|
		|loginButton|
		Then user validates title to be 'Adactin.com - Search Hotel'
    Given user is on SearchHotelPage
    When user enters details in SearchHotelPage
    | Location | Hotels | Room Type | Number of Rooms | Check InDate | Check OutDate| Adults per Room| Kids per room|
    | Sydney | Hotel Creek | Standard | 1 - One | 06/03/2023 | 07/03/2023 | 1 - One | 0 - None |
    When user clicks on Button in SearchHotelPage
    |objectName|
    |searchbutton|
    