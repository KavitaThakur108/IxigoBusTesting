Overview

This project automates the testing of the Ixigo Bus Booking feature using Selenium WebDriver, TestNG, and Cucumber (BDD). It validates critical functionalities such as seat selection, traveler details, payment gateway, insurance addition, and offer code application.
-------------------------------------------------------------------------------------------------------------------------------------

**Manual Testing**

A manual testing document is also included for reference. Five testcases highlighted in manual file has been used for automation testing.

--------------------------------------------------------------------------------------------------------------------------------------------
**Tech Stack**

1.Java (Core language)
2.Selenium WebDriver (UI Automation)
3.TestNG (Test execution and reporting)
4.Cucumber (Behavior Driven Development)
5.Maven (Build and dependency management)
6.Excel (Data-driven testing)
7.Page Object Model (POM) (Design pattern) along with Page Factory

--------------------------------------------------------------------------------------------------------------------------------------
**Data**

1.Excel
2.DataProvider
3.Object Repository

--------------------------------------------------------------------------------------------------------------------------------------
**Features Tested**

1.Traveler Details Validation
Ensures payment cannot proceed without filling traveler details.

2.Insurance Addition
Verifies insurance is added to the total fare when selected.

3.Billing Address Validation
Checks if inconsistent State-PIN combinations are rejected.

4.Payment Gateway
Confirms correct bank portal opens for Net Banking.

5.Offer Code Copy
Validates offer code copying functionality.

6.Invalid Card Details
Ensures system rejects incorrect credit card numbers.

-------------------------------------------------------------------------------------------------------
