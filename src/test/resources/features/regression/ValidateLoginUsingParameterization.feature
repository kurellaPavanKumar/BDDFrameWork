Feature: To validate login functionality

@regression

Scenario Outline: To validate login using different credentials

Given user starts "chrome" browser
And user launch app using url "https://adactinhotelapp.com/"
When user enters text '<username>' in textbox using xpath "//input[@name='username']"
And user enters text '<password>' in textbox using xpath "//input[@name='password']"
And user clicks button using xpath "//input[@name='login']"
Then user verifies title to be '<expectedtitle>'

Examples:
|username| |password| |expectedtitle|
|reyaz0806| |reyaz123| |Adactin.com - Search Hotel|
|reyaz0807| |reyaz124| |Adactin.com - Hotel Reservation System|
|reyaz0806| |reyaz124| |Adactin.com - Hotel Reservation System|
|reyaz0807| |reyaz123| |Adactin.com - Hotel Reservation System|
