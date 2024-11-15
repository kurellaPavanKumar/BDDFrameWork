Feature: To validate login functionality

Background: To start browser and launch app
Given user starts "chrome" browser
And user launch app using url "https://adactinhotelapp.com/"

Scenario: To validate login using valid credentials

When user enters text "reyaz0806" in textbox using xpath "//input[@name='username']"
And user enters text "reyaz123" in textbox using xpath "//input[@name='password']"
And user clicks button using xpath "//input[@name='login']"
Then user verifies title to be "Adactin.com - Search Hotel"

Scenario: To validate login using invalid and invalid credentials

When user enters text "reyaz080" in textbox using xpath "//input[@name='username']"
And user enters text "reyaz12" in textbox using xpath "//input[@name='password']"
And user clicks button using xpath "//input[@name='login']"
Then user verifies title to be "Adactin.com - Hotel Reservation System"

Scenario: To validate login using valid and invalid credentials

When user enters text "reyaz0806" in textbox using xpath "//input[@name='username']"
And user enters text "reyaz12" in textbox using xpath "//input[@name='password']"
And user clicks button using xpath "//input[@name='login']"
Then user verifies title to be "Adactin.com - Hotel Reservation System"

Scenario: To validate login using invalid and valid credentials

When user enters text "reyaz080" in textbox using xpath "//input[@name='username']"
And user enters text "reyaz123" in textbox using xpath "//input[@name='password']"
And user clicks button using xpath "//input[@name='login']"
Then user verifies title to be "Adactin.com - Hotel Reservation System"