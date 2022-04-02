package com.automation.training.autotraining.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompleteBookingPage extends BasePage {

	public CompleteBookingPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "totalPriceForTrip")
	 private WebElement totalPrice;
	
	@FindBy(id = "best-price-guarantee")
	 private WebElement priceGuaranteeText;
	
	@FindBy(xpath="//h2[.=\"Who's traveling?\"]|//h2[contains(text(),\" Who's flying?\")]")
	private WebElement whoIsTravelingText;
	
	@FindBy(xpath="//*[contains(text(),\"Debit/Credit\")]")
	private WebElement debitCreditCard;
	
	@FindBy(xpath="//*[contains(text(),\"Where should we send your confirmation?\")]")
	private WebElement sendInformation;
	
	@FindBy(xpath="//*[contains(text(),\"Review and book\")]")
	private WebElement reviewAndBook;
	
	@FindBy(xpath="//span[@data-price-update=\"tripTotal\"]")
	private WebElement tripTotal;
	
	@FindBy(xpath="//*[contains(text(),'Confirmation email')]")
	private WebElement confirmationEmail;
	
	public boolean tripTotalIsPresent() {
		return tripTotal.isEnabled();
	}
	
	public boolean confirmationEmailIsPresent() {
		return confirmationEmail.isEnabled();
	}
	
	public boolean reviewAndBookIsPresent() {
		wait(reviewAndBook);
		return reviewAndBook.isEnabled();
	}
	
	public boolean totalPriceIsPresent() {
		return totalPrice.isEnabled();
	}
	
	public boolean PriceGuaranteeIsPresent() {
		return priceGuaranteeText.isEnabled();
	}
	
	public boolean whoIsTravelingTextIsPresent() {
		return whoIsTravelingText.isEnabled();
	}
	
	public boolean debitCreditCardTextIsPresent() {
		return debitCreditCard.isEnabled();
	}
	
	public boolean sendInformationIsPresent() {
		return sendInformation.isEnabled();
	}

	
}
