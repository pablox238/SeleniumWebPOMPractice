package com.automation.training.autotraining.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TripDetailPage extends BasePage {

	
	@FindBy(id = "trip-flight-to")
	 private WebElement tripFlightTo;
	
	@FindBy(id = "trip-flight-from")
	 private WebElement tripFlightFrom;
	
	@FindBy(id = "trip-flight-start")
	 private WebElement tripFlightStart;
	
	@FindBy(id = "trip-flight-end")
	 private WebElement tripFlightEnd;
	
	@FindBy(id = "numberOfTickets")
	 private WebElement numberOfTickets;
	
	@FindBy(xpath = "//button[@class='btn-primary btn-action']")
	 private WebElement btnNextFinalDetails;
	
	
	public TripDetailPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean tripFlightToIsPresent() {
		return tripFlightTo.isDisplayed();
	}
	
	public boolean tripFlightFromIsPresent() {
		return tripFlightFrom.isDisplayed();
	}
	
	public boolean tripFlightStartIsPresent() {
		return tripFlightStart.isDisplayed();
	}
	
	public boolean tripFlightEndIsPresent() {
		 return tripFlightEnd.isDisplayed();
	}
	
	public boolean numberOfTicketsIsPresent() {
		return numberOfTickets.isDisplayed();
	}
	
	public CompleteBookingPage clickOnbtnNextFinalDetails() {
		btnNextFinalDetails.click();
		return new CompleteBookingPage(getDriver());
	}
	
	

}
