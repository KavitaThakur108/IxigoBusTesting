Feature: To test the bus booking functionality of Ixigo Application

Background: 
Given User is on the homepage of Ixigo application and Logged in Buses 



@MissingDetails @Parallel @Negative
Scenario: To validate Ixigo blocks the payment without traveler details
 
  When User select the from and to City and Search
  And  Select seat in bus
  And  Select Boarding and dropping point
  And  Click on Continue
  Then It should ask to fill the traveler details first on clicking to Pay
 
 
   
@Insurance @Parallel @Positive
Scenario Outline: To validate insurance get added into final bill 
  
  When User select the from_and_to City and Search
  And  Select seat in specific bus
  And  Select Boarding and dropping point of journey
  And  Click on Continue button
  And  Fill traveler details from file "<file>" and sheet <Sheet> and row <row>
  And  Click on Insurance
  Then The insurance should be added to final bill
  Examples:
       |file                 |Sheet |row|
       |traveler_details.xlsx|   0  | 1 |
       |traveler_details.xlsx|   0  | 2 |
      
       
 
 
@defect @Parallel
Scenario Outline: To validate that System allows saving Billing details with inconsistent State–City–PIN 
 
  When User firstly select the from_and_to City and then Search
  And  Select seat in specific bus appeared
  And  Select Boarding_and_dropping point of that journey
  And  Click on Continue button to move
  And  fill name,age ,email in traveler details 
  
       | filename               |
       | Traveler_details.xlsx  |

  And  fill inconsistent State "<State>", PIN "<PIN>" in billing address
  When click on Save button of Billing Address
  Then It should not save it
  Examples:
       |  State        |PIN      |
       |  Punjab       |  333333 |
       |  Assam        |  333333 |
  
  
  
  
@PayFare @Parallel @Positive
Scenario: To validate that System opens the portal of particular bank which has been selected by the user
 
  When User firstly clarifies the from_and_to City and then Search
  And  Select specific seat in  bus appeared
  And  Select Boarding_and_dropping point of  Bus
  And  Click on Continue button to move forward for payment
  And  fill name,age ,email in traveler details before payment 
     | filename               |
     | Traveler_details.xlsx  |
  And  Click on Continue to Pay button
  When user choose Net Banking and bank for payment
  Then it should open a new window of bank selected 
 
 
  
  
@Offers @Parallel @Positive
Scenario:  To validate that System copies the offer code chosen by the user
 
  When User click on the Bus Booking link under Top Tourist Bus Routes
  And  Select the offer to book the bus
  And  Click on the copy icon of offer code
  Then it should give the confirmation of copying offer code
  
  
  
  
@CreditCard @Parallel @Negative
Scenario: To validate that System accept the incorrect credit card number
 
  When User mentions the from_and_to City and then Search
  And  Select seat in  bus appeared
  And  Select Boarding_and_dropping point of  your journey
  And  Click on Continue button to move  for payment
  And  fill name,age ,email in details before payment 
    | filename               |
    | Traveler_details.xlsx  |
  And Click Continue to Pay button
  When user choose Credt/Debit Card option 
  And fill Card Number <cardNumber> ,expiry date <expiry> and CVV <CVV>
    |cardNumber |987987987987|
    |expiry     |333         |
    |CVV        |243         |
  Then it should not accept the incorrect card number
  
  

          