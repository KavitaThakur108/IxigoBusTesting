Overview

This project automates the testing of the Ixigo Bus Booking feature using Selenium WebDriver, TestNG, and Cucumber (BDD). It validates critical functionalities such as seat selection, traveler details, payment gateway, insurance addition, and offer code application.
-------------------------------------------------------------------------------------------------------------------------------------
 
**Tech Stack**

-Java (Core language)
-Selenium WebDriver (UI Automation)
-TestNG (Test execution and reporting)
-Cucumber (Behavior Driven Development)
-Maven (Build and dependency management)
-Excel (Data-driven testing)
-Page Object Model (POM) (Design pattern) along with Page Factory

--------------------------------------------------------------------------------------------------------------------------------------
**Data**

-Excel
-DataProvider
-Object Repository

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
