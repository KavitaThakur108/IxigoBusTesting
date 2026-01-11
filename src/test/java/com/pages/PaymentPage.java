package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

	@FindBy(xpath="//p[text()=\"Net Banking\"]")WebElement NetBankingbtn;
	@FindBy(xpath="//p[text()=\"ICICI Bank\"]")WebElement SelectBank;
	@FindBy(css  ="button[data-testid=\"payment-button\"]")WebElement PayBtn;
	@FindBy(xpath="//p[text()=\"Credit/Debit/ATM Card\"]")WebElement creditCard;
	@FindBy(css  ="input[name=\"cardNumber\"]")WebElement cardNum;
	@FindBy(css  ="input[name=\"cardExpDate\"]")WebElement expiry;
	@FindBy(css  ="input[name=\"newCardCVV\"]")WebElement cvv;
	@FindBy(xpath="//button[@id=\"btn-paymentForm-newCard\"]")WebElement SecuredPay;
	@FindBy(xpath="//div[text()=\"Please enter a valid card number\"]")WebElement invalidMessage;
	
	
	public PaymentPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		
	}
	
//Choose credit card option from Paying options---------------------
	public void chooseCredit()
	{
		waitUntilVisibilityOfElement(creditCard);
		waitUntilElementToBeClickable(creditCard);
		creditCard.click();	
	}
	
//Click on payment button ----------------------------------------------
	public void securedPaymentBtn()
	{
		waitUntilElementToBeClickable(SecuredPay);
		SecuredPay.click();
	}

//Filling the credit card details-----------------------------------------
	public void typeCardDetails(String card,String exp,String cvvnum  )
	{
		waitUntilVisibilityOfElement(cardNum);
		cardNum.sendKeys(card);
		waitUntilVisibilityOfElement(expiry);
		expiry.sendKeys(exp);
		waitUntilVisibilityOfElement(cvv);
		cvv.sendKeys(cvvnum);
		
	}
	
//Invalid message for passing wrong credit card number-------------------------------
	public String invalidMessage()
	{
		waitUntilVisibilityOfElement(invalidMessage);
		String message=invalidMessage.getText();
		return message;
		
	}
	
//Selecting the bank for payment--------------------------------------------------------
	public String bankName()
	{
		String bank=SelectBank.getText();
		return bank;
	}
	
//Selecting NetBanking Option -------------------------------------------------------------
	public void selectNetBankingOption()
	{
		waitUntilVisibilityOfElement( NetBankingbtn);
		waitUntilElementToBeClickable(NetBankingbtn);
		NetBankingbtn.click();
	}

//Select the bank for payment--------------------------------------------------------------	
	public void selectBankoption()
	{
		waitUntilElementToBeClickable(SelectBank);
		SelectBank.click();
		
	}

//Click on paymentBtn of NetBanking-----------------------------------------------------------
	public void clickPaymentBtn()
	{
		waitUntilElementToBeClickable(PayBtn);
		PayBtn.click();
	}
	
	
	
	
}
