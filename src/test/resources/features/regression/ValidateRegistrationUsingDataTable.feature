Feature: To validate registration functionality

@smoke2

Scenario: To validate registration functionality using valid data

Given user starts "chrome" browser
And user launch app using url "https://adactinhotelapp.com/"
When user click using xpath "//a[text()='New User Register Here']"
Then user verifies title to be "Adactin.com - New User Registration"
When user enters details in registration form
|pavan|123|123|pavankumar|pavan19@gmail.com|read|