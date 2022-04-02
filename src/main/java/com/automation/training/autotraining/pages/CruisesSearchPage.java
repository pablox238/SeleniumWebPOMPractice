package com.automation.training.autotraining.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CruisesSearchPage extends BasePage {

	public CruisesSearchPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(id = "cruise-destination-cruiselp")
	private WebElement goingTo;
	
	@FindBy(xpath = "//option[.='Europe']")
	private WebElement goingToOption;
	
	@FindBy(id = "cruise-start-date-cruiselp")
	private WebElement departsEarly;
	
	@FindBy(id = "cruise-end-date-cruiselp")
	private WebElement departsLate;
	
	@FindBy(xpath = "//button[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']")
	private WebElement nextMonthButton;
	
	@FindBy(xpath="(//button[@data-day='1'])[2]")
	private WebElement departsEarlyDay;
	
	@FindBy(xpath="//button[@data-day='8']")
	private WebElement departsLateDay;
	
	@FindBy(xpath = "//span[.=\"Search\"]/ancestor::button[not(@id)]")
	private WebElement searchButton;
	
	public ResultOfSearchCruisesPage searchCruises() {
		goingTo.click();
		goingToOption.click();
		departsEarly.click();
		nextMonthButton.click();
		nextMonthButton.click();
		nextMonthButton.click();
		departsEarlyDay.click();
		departsLate.click();
		departsLateDay.click();
		searchButton.click();
		return new ResultOfSearchCruisesPage(getDriver());
	}

}
