package com.automation.training.autotraining.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewTripPage extends BasePage {

	public ReviewTripPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".packagePriceTotal")
	 private WebElement totalPrice;
	
	
	@FindBy(xpath = "//a[contains(text(),'No thanks')]")
	private WebElement noThanksLink;
	
	@FindBy(xpath = "//div[contains(@class,'flex-card flex-tile details')]")
	private List<WebElement> departureAndReturnInfo;
	
	@FindBy(css = ".priceGuarantee")
	 private WebElement priceGuaranteeText;
	
	@FindBy(id = "bookButton")
	 private WebElement continueBookingBtn;
	
	
	
	
	
	public void clickOnNoThanks() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(noThanksLink));
		if (noThanksLink.isDisplayed()) {
			noThanksLink.click();
		}
		switchWindow();
	}
	
	public boolean totalPriceIsPresent() {
		return totalPrice.isEnabled();
	}
	
	public boolean PriceGuaranteeIsPresent() {
		return priceGuaranteeText.isEnabled();
	}
	
	public int getNumberOfResultsInfo() {
		return departureAndReturnInfo.size();
	}
	
	public CompleteBookingPage clickOnContinueBooking() {
		continueBookingBtn.click();
		return new CompleteBookingPage(getDriver());
	}
	
}
