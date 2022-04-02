package com.automation.training.autotraining.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchFlightPage extends BasePage {

	public SearchFlightPage(WebDriver driver) {
		super(driver);
		driver.get("https://www.travelocity.com/Flights");
	}
	
	@FindBy(id = "flight-origin-flp")
	private WebElement flyingFrom;
	
	@FindBy(id = "flight-destination-flp")
	private WebElement flyingTo;
	
	@FindBy(id = "flight-departing-flp")
	private WebElement departing;
	
	@FindBy(id = "flight-returning-flp")
	private WebElement returning;
	
	@FindBy(id = "tab-flight-tab-flp")
	private WebElement flightOnlyBtn;
	
	@FindBy(id = "tab-flight-tab-flp")
	private WebElement roundTripBtn;
	
	@FindBy(id = "flight-adults-flp")
	private WebElement adults;
	
	@FindBy(xpath = "//select[@id='flight-adults-flp']//option[@value='1']")
	private WebElement numberAdultsFlight;
	
	@FindBy(id = "package-1-adults-flp-fh")
	private WebElement adultsFlightPlusHotel;
	
	@FindBy(xpath = "//select[@id='package-1-adults-flp-fh']//option[@value='1']")
	private WebElement numberAdultsFlightPlusHotel;
	
	@FindBy(xpath = "//span[.=\"Search\"]/ancestor::button[not(@id)]")
	private WebElement searchButton;
	
	@FindBy(xpath = "//button[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']")
	private WebElement nextMonthButton;
	
	@FindBy(xpath = "//select[@id='flight-adults-flp']//option[@value='{0}']")
	private WebElement adultsNumber;
	
	@FindBy(xpath="(//button[@data-day='1'])[2]")
	private WebElement departingDay;
	
	@FindBy(xpath="//button[@data-day='13']")
	private WebElement returningDay;
	
	@FindBy(id = "tab-flightHotel-tab-flp-fh")
	private WebElement flightPlusHotelBtn;
	
	@FindBy(id = "package-origin-flp-fh")
	private WebElement flyingFromHotelPlusFlight;
	
	@FindBy(id = "package-destination-flp-fh")
	private WebElement flyingToHotelPlusFlight;
	
	@FindBy(id = "package-departing-flp-fh")
	private WebElement departingHotelPlusFlight;
	
	@FindBy(id = "package-returning-flp-fh")
	private WebElement returningHotelPlusFlight;
	
	@FindBy(id = "package-checkin-flp-fh")
	private WebElement checkin;
	
	@FindBy(id = "package-checkout-flp-fh")
	private WebElement checkout;
	
	@FindBy(xpath="(//button[@data-day='14'])[2]")
	private WebElement chekinDay;
	
	@FindBy(xpath="//button[@data-day='15']")
	private WebElement checkoutDay;
	
	@FindBy(id="partialHotelBooking-flp-fh")
	private WebElement onlyHotelOfPartOfStayCheck;
	
	@FindBy(id = "search-button-flp-fh")
	private WebElement searchHotelPlusFlightBtn;
	
	@FindBy(xpath="//a[@class='error-link']")
	private WebElement errorLink;
	
	
	
	public ResultOfSearchPage searchFlight() {
		flyingFrom.click();
		flyingFrom.sendKeys("Las Vegas, NV (LAS-All Airports)");
		flyingTo.click();
		flyingTo.sendKeys("Los Angeles, CA (LAX-Los Angeles Intl.)");
		departing.click();
		nextMonthButton.click();
		nextMonthButton.click();
		nextMonthButton.click();
		departingDay.click();
		returning.click();
		returningDay.click();
		adults.click();
		wait(numberAdultsFlight);
		numberAdultsFlight.click();
		searchButton.click();
		return new ResultOfSearchPage(getDriver());
	}
	
	public void searchFlightPlusHotelError() {
		flightPlusHotelBtn.click();
		flyingFromHotelPlusFlight.click();
		flyingFromHotelPlusFlight.sendKeys("Las Vegas, NV (LAS-All Airports)");
		flyingToHotelPlusFlight.click();
		flyingToHotelPlusFlight.sendKeys("Los Angeles, CA (LAX-Los Angeles Intl.)");
		departingHotelPlusFlight.click();
		nextMonthButton.click();
		nextMonthButton.click();
		nextMonthButton.click();
		departingDay.click();
		returningHotelPlusFlight.click();
		returningDay.click();
		onlyHotelOfPartOfStayCheck.click();
		checkin.click();
		chekinDay.click();
		checkout.click();
		checkoutDay.click();
		searchHotelPlusFlightBtn.click();
	}
	
	public ResultOfSearchPage searchFlightPlusHotel() {
		flightPlusHotelBtn.click();
		flyingFromHotelPlusFlight.click();
		flyingFromHotelPlusFlight.sendKeys("Las Vegas, NV (LAS-All Airports)");
		flyingToHotelPlusFlight.click();
		flyingToHotelPlusFlight.sendKeys("Los Angeles, CA (LAX-Los Angeles Intl.)");
		departingHotelPlusFlight.click();
		nextMonthButton.click();
		nextMonthButton.click();
		nextMonthButton.click();
		departingDay.click();
		returningHotelPlusFlight.click();
		returningDay.click();
		adultsFlightPlusHotel.click();
		numberAdultsFlightPlusHotel.click();
		searchHotelPlusFlightBtn.click();
		return new ResultOfSearchPage(getDriver());
	}
	
	public String errorMessage() {
		return errorLink.getText();
	}
	
	
	

}
