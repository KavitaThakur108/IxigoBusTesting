package com.StepDefinitionTestNG;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.AbhibusPage;
import com.pages.BankPage;
import com.pages.BasePage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.OfferPage;
import com.pages.PaymentPage;
import com.pages.SeatBookingPage;
import com.pages.TravelerDetailsPage;
import com.pages.iciciPage;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BusStepDefinition {
	
	WebDriver driver;
	BasePage base;
	HomePage home;
	LoginPage otp;
	SeatBookingPage seat;
	TravelerDetailsPage detail;
	PaymentPage pay;
	ExcelReader excel;
	BankPage bank;
	AbhibusPage bus;
	OfferPage offer;
	iciciPage icici;
	String bankname;

	
	
//-----------------------------------------BACKGROUND-------------------------------
	
	
	@Given("User is on the homepage of Ixigo application and Logged in Buses")
	public void user_is_on_the_homepage_of_ixigo_application() 
	{
		//creating object of each class being called
		driver= BaseSteps.edgedriver();
		home=new HomePage(driver);
		otp=new LoginPage(driver);
		seat=new SeatBookingPage(driver);
		detail=new TravelerDetailsPage(driver);
		pay=new PaymentPage(driver);
		bus=new AbhibusPage(driver);
	    bank=new BankPage(driver);
	    icici=new iciciPage(driver);
	    offer=new OfferPage(driver);
		base=new BasePage(driver);
		excel=new ExcelReader();
		
		
		//Filling OTP frame 
		home.busClick();
		otp.mobileFilling();
		otp.otpFilling();	
	
	}
	
	
//-------------------------------------SCENARIO 1 :MISSING TRAVELLER DETAILS--------------------------------
	
	/*Created By   : Kavita Thakur
	 * Reviewed By : SME
	 * Motive      : To check if  Proceed to Pay is enabled without filling Traveler details
	*/
	
	
	@When("User select the from and to City and Search")
	public void Search_Route() 
	{ 
		home.fromCity();
		home.toCity();
		//home.tommorow();
		home.datePick();
		
	}

	@When("Select seat in bus")
	public void select_seat() 
	{
		seat.selectSeat();
	}
	
	@When("Select Boarding and dropping point")
	public void select_boarding_and_dropping_point()
	{
		seat.selectBoardingDropping();
	   
	}
	
	@When("Click on Continue")
	public void click_on_continue() 
	{
	    seat.seatContinue();
	}
	
	@Then("It should ask to fill the traveler details first on clicking to Pay")
	public void it_should_ask_to_fill_the_traveler_details_first()
	{   
		detail.continueToPay();
	    String Expected="Please Enter Valid Name";
	    String actual=detail.emptyDetails();
		Assert.assertEquals(actual,Expected);
	   
	}
	
//---------------------------------------SCENERIO 2: ADDING INSURANCE-------------------------------------
	
	/*Created By   : Kavita Thakur
	 * Reviewed By : SME
	 * Motive      : To check if  Insurance gets added to total fare after clicking it
	*/
	
	@When("User select the from_and_to City and Search")
	public void user_select_the_from_and_to_city_and_search() 
	{
		home.fromCity();
		home.toCity();
		//home.datePick();
		home.tommorow();
	}
	
	@When("Select seat in specific bus")
	public void select_seat_in_specific_bus() 
	{
		seat.selectSeat();
	}
	
	@When("Select Boarding and dropping point of journey")
	public void select_boarding_and_dropping_point_of_journey() 
	{
		seat.selectBoardingDropping();
	}
	
	@When("Click on Continue button")
	public void click_on_continue_button() 
	{
		 seat.seatContinue();
	}
	
	@When("Fill traveler details from file {string} and sheet {int} and row {int}")
	public void fill_traveler_details_from_filetraveler_details_xlsx_and_row3(String file,Integer sheetno, Integer rowno) throws IOException 
	{  
		//Scenerio Outline
		String[] data=excel.getTravelerDetails(file,sheetno, rowno);
		detail.typeDetails(data[0], data[1],data[2]);
	    
	}
	
	@When("Click on Insurance")
	public void click_on_insurance() 
	{
	    
		detail.insuranceCheck();
	}
	
	@Then("The insurance should be added to final bill")
	public void the_insurance_should_be_added_to_final_bill() 
	{
		
		String insuranceLab=detail.insuranceCheckLabel();
		Assert.assertEquals(insuranceLab,"Travel Insurance","No insurance label found in fare details");
	  
	}
	
//-------------------------------------SCENERIO 3:CITY/STATE DEFECT---------------------------------------
	
	/*Created By   : Kavita Thakur
	 * Reviewed By : SME
	 * Motive      : To check if  the Billing Address accepts inconsistent City-State- PIN;
	*/
	
	@When("User firstly select the from_and_to City and then Search")
	public void user_firstly_select_the_from_and_to_city_and_then_search() 
	{
		home.fromCity();
		home.toCity();
		home.datePick();
		//home.tommorow();
	}
	
	@When("Select seat in specific bus appeared")
	public void select_seat_in_specific_bus_appeared() 
	{
		seat.selectSeat();
	}
	
	@When("Select Boarding_and_dropping point of that journey")
	public void select_boarding_and_dropping_point_of_journey1() 
	{
		seat.selectBoardingDropping();
	}
	
	@When("Click on Continue button to move")
	public void click_on_continue_button_to_move() 
	{
		 seat.seatContinue();
	}
	
	@When("fill name,age ,email in traveler details")
	public void fill_name_age_email_in_traveler_details(DataTable credential) throws IOException 
	{
		   List<String> list = credential.asList();
		   String[] cred = excel.TravelDetailsReader(list.get(1));
		   detail.typeDetails(cred[0], cred[1],cred[2]);
	}
	
	@When("fill inconsistent State {string}, PIN {string} in billing address")
	public void fill_inconsistent_city_city_state_state_pin_pin_in_billing_address(String state,String pin) throws IOException 
	{
		    
		    detail.billingOpen();
		    detail.selectBillingState(state);
		    detail.enterBillingPin(pin);	 
		 
	}
	
	@When("click on Save button of Billing Address")
	public void click_on_save_button_of_billing_address() 
	{ 
		   detail.billingSaves();
	}
	
	@Then("It should not save it")
	public void it_should_not_save_it() 
	{
		
	      boolean canProceed = detail.canProceedToPay();
		  if(canProceed)
		   {
			 Assert.fail("DEFECT: App allowed proceeding to payment with inconsistent billing state/pin without validation.");
		   }	
	   
	}
	
//----------------------------------------SCENERIO 4:PAYFARE-------------------------------------------------
	
	/*Created By   : Kavita Thakur
	 * Reviewed By : SME
	 * Motive      : To check if System opens the portal of particular bank which has been selected by the user
	*/
	
	@When("User firstly clarifies the from_and_to City and then Search")
	public void user_firstly_clarifies_the_from_and_to_city_and_then_search() 
	{
		home.fromCity();
		home.toCity();
		home.datePick();
		//home.tommorow();
	}
	
	@When("Select specific seat in  bus appeared")
	public void select_specific_seat_in_bus_appeared() 
	{
		seat.selectSeat();
	}
	
	@When("Select Boarding_and_dropping point of  Bus")
	public void select_boarding_and_dropping_point_of_bus() 
	{
		seat.selectBoardingDropping();
	}
	
	@When("Click on Continue button to move forward for payment")
	public void click_on_continue_button_to_move_forward_for_payment() 
	{
		 seat.seatContinue();
	}
	
	@When("fill name,age ,email in traveler details before payment")
	public void fill_name_age_email_in_traveler_details_before_payment(DataTable credentials) throws IOException 
	{
		 List<String> list = credentials.asList();
		 String[] cred = excel.TravelDetailsReader(list.get(1));
		 detail.typeDetails(cred[0], cred[1],cred[2]);
	}
	
	@When("Click on Continue to Pay button")
	public void click_on_continue_to_pay_button() 
	{
	     detail.continueToPay();
	}
	@When("user choose Net Banking and bank for payment")
	public void user_choose_net_banking_and_bank_for_payment() 
	{
	     pay.selectNetBankingOption();
	     pay.selectBankoption();
	     bankname=pay.bankName().split("\\s+")[0].toLowerCase();
	     pay.clickPaymentBtn();
	     icici.getWindow();	
	}
	
	@Then("it should open a new window of bank selected")
	public void it_should_open_a_new_window_of_bank_selected() 
	{
		
		  icici.waitForPageToLoad();
		  String url = driver.getCurrentUrl().toLowerCase();
	      Assert.assertTrue(url.contains(bankname));
	
		
	}
	
//--------------------SCENERIO 5: COPY OFFER CODE-----------------------------------
	
	/*Created By   : Kavita Thakur
	 * Reviewed By : SME
	 * Motive      : To check if System copies the offer code chosen by the user
	*/
	
	@When("User click on the Bus Booking link under Top Tourist Bus Routes")
	public void user_click_on_the_bus_booking_link_under_top_tourist_bus_routes() 
	{ 
		  home.busBookinglink();	
	}
	
	@When("Select the offer to book the bus")
	public void select_the_offer_to_book_the_bus() 
	{
	      bus.offerSelect();
	      offer.getWindow();
	    
	   
	}
	
	@When("Click on the copy icon of offer code")
	public void click_on_the_copy_icon_of_offer_code() 
	{

		  offer.offerCopy();
	}
	
	@Then("it should give the confirmation of copying offer code")
	public void it_should_give_the_confirmation_of_copying_offer_code() 
	{
		   Alert alert = base.waitForAlert();
		   String text=base.getAlertText();
	       String expected="Copied the Code";
	       Assert.assertTrue(text.contains(expected),"Code didn't got copied");
	       alert.accept();
	       
	}
	
//----------------------------------------SCENERIO 6:INVALID CARD DETAILS------------------------------------
	
	/*Created By   : Kavita Thakur
	 * Reviewed By : SME
	 * Motive      : To check that System should not accept the incorrect credit card number
	*/
	
	@When("User mentions the from_and_to City and then Search")
	public void user_mentions_the_from_and_to_city_and_then_search() 
	{
		home.fromCity();
		home.toCity();
		//home.datePick();
		home.tommorow();
	}
	
	@When("Select seat in  bus appeared")
	public void select_seat_in_bus_appeared() 
	{
		seat.selectSeat();
	}
	
	@When("Select Boarding_and_dropping point of  your journey")
	public void select_boarding_and_dropping_point_of_your_journey() 
	{
		seat.selectBoardingDropping();
	}
	
	@When("Click on Continue button to move  for payment")
	public void click_on_continue_button_to_move_for_payment() 
	{
		 seat.seatContinue();
	}
	
	@When("fill name,age ,email in details before payment")
	public void fill_name_age_email_in_details_before_payment(DataTable credentials) throws IOException 
	{
		  List<String> list = credentials.asList();
		  String[] cred = excel.TravelDetailsReader(list.get(1));
		  detail.typeDetails(cred[0], cred[1],cred[2]);
	}
	
	@When("Click Continue to Pay button")
	public void click_continue_to_pay_button() 
	{
		  detail.continueToPay();
	}
	
	@When("user choose Credt\\/Debit Card option")
	public void user_choose_credt_debit_card_option() 
	{
	      pay.chooseCredit();
	}
	
	@When("fill Card Number <cardNumber> ,expiry date <expiry> and CVV <CVV>")
	public void fill_card_number_card_number_expiry_date_expiry_and_cvv_cvv(DataTable cardDetails) throws IOException 
	{

          Map<String, String> row = cardDetails.asMap(String.class, String.class);
          String cardNumber = row.get("cardNumber");
          String expiry     = row.get("expiry");
          String cvv        = row.get("CVV");
          
          pay.typeCardDetails(cardNumber, expiry, cvv);
          pay.securedPaymentBtn();
	}
	
	@Then("it should not accept the incorrect card number")
	public void it_should_not_accept_the_incorrect_card_number() 
	{
		  String message=pay.invalidMessage();
		  String expected="Please enter a valid card number";
		  Assert.assertEquals(message,expected );
		
		
	}
	
//--------------------------------------------SCREENSHOT--------------------------------------
	
	@After
	public void tearDown(Scenario scenario) throws InterruptedException
	{
		 final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		 scenario.attach(screenshot, "image/png", scenario.getName());
		 driver.quit();	
	}
	

}
