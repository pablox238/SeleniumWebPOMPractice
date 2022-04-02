package com.automation.training.autotraining.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TravelocityHomePage extends BasePage {

	public TravelocityHomePage(WebDriver driver) {
		super(driver);
		driver.get("https://www.travelocity.com/");
	}
	
	@FindBy(id = "primary-header-flight")
	private WebElement flightsHeaderLink;
	
	@FindBy(id = "primary-header-hotel")
	private WebElement hotelsHeaderLink;
	
	@FindBy(id = "primary-header-cruise")
	private WebElement cruisesHeaderLink;
	
	
	public SearchFlightPage clickFlightsHeader() {
		flightsHeaderLink.click();
		return new SearchFlightPage(getDriver());
	}
	
	public HotelsSearchPage clickHotelsHeader() {
		hotelsHeaderLink.click();
		return new HotelsSearchPage(getDriver());
	}
	
	public CruisesSearchPage clickCruisesHeader() {
		cruisesHeaderLink.click();
		return new CruisesSearchPage(getDriver());
	}
	
	

}
