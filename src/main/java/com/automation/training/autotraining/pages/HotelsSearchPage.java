package com.automation.training.autotraining.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelsSearchPage extends BasePage {

	
	public HotelsSearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "hotel-destination-hlp")
	private WebElement goingTo;
	
	@FindBy(xpath = "//button[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']")
	private WebElement nextMonthButton;
	
	@FindBy(xpath = "//span[.=\"Search\"]/ancestor::button[not(@id)]")
	private WebElement searchButton;
	
	@FindBy(id = "hotel-checkin-hlp")
	private WebElement checkin;
	
	@FindBy(id = "hotel-checkout-hlp")
	private WebElement checkout;
	
	@FindBy(xpath="(//button[@data-day=\"1\"])[2]")
	private WebElement departingDay;
	
	@FindBy(xpath="//button[@data-day='8']")
	private WebElement returningDay;
	
	public ResultOfSearchHotelsPage searchHotel() {
		goingTo.click();
		goingTo.sendKeys("Montevideo, Uruguay");
		checkin.click();
		nextMonthButton.click();
		nextMonthButton.click();
		nextMonthButton.click();
		departingDay.click();
		checkout.click();
		returningDay.click();
		searchButton.click();
		return new ResultOfSearchHotelsPage(getDriver());
	}
	
	
	

}
