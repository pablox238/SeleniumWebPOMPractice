package com.automation.training.autotraining.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultOfSearchPage extends BasePage {

	public ResultOfSearchPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = ".fill")
	private WebElement fillBar;

	@FindBy(xpath = "//select[@id='sortDropdown']/option")
	private List<WebElement> optionsSortDropDown;

	@FindBy(id = "sortDropdown")
	private WebElement sortDropDown;

	@FindBy(xpath = "//select[@id='sortDropdown']/option[.='Price (Lowest)']")
	private WebElement priceLowest;

	@FindBy(xpath = "//*[@style='visibility: visible; opacity: 1;']")
	private WebElement rulesAndRestrictionsVisibleSection;

	@FindBy(xpath = "//ul[@id='flightModuleList']/li[@class='flight-module segment offer-listing']//div[@data-test-id=\"listing-main\"]//button[@data-test-id=\"select-button\"]")
	private List<WebElement> selectButtons;
	
	@FindBy(xpath = "//ul[@id='flightModuleList']/li[@class='flight-module segment offer-listing']//div[@data-test-id=\"listing-main\"]//button[@data-test-id=\"select-button\"]")
	private WebElement selectButton;

	@FindBy(xpath = "//span[.='Select this fare']/ancestor::button")
	private List<WebElement> selectThisFareButtons;

	@FindBy(xpath = "//ul[@id='flightModuleList']/li[@class='flight-module segment offer-listing']//div[@data-test-id=\"listing-main\"]")
	private List<WebElement> listResult;

	@FindBy(xpath = "//span[@data-test-id=\"duration\"]")
	private List<WebElement> hoursList;

	@FindBy(xpath = "//span[contains(text(),'Details & baggage fees')][@class='show-flight-details']")
	private List<WebElement> detailsAndBagageFeesList;

	@FindBy(xpath = "//span[@data-test-id=\"listing-price-dollars\"]")
	private List<WebElement> pricesList;
	
	@FindBy(xpath = "//*[@class='actualPrice price fakeLink ']")
	private List<WebElement> priceHotelsList;
	
	@FindBy(xpath = "//span[.='Rules and restrictions apply']")
	private List<WebElement> rulesAndRestrictionsList;

	@FindBy(xpath = "//h1[contains(text(),'Start by choosing your hotel')]")
	private WebElement lblStartChoosingYourHotel;

	@FindBy(xpath = "//*[@class='sort-options nobullet']")
	private WebElement sortOptionsBar;

	@FindBy(xpath = "//h3[contains(text(),'Search by property name')]/following-sibling::fieldset[@role='search']")
	private WebElement searchByPropertyNameBox;

	@FindBy(xpath = "//article[@data-hotelid]")
	private List<WebElement> results;
	
	@FindBy(xpath = "//article[@data-hotelid]")
	private WebElement result;

	@FindBy(id = "amenities")
	private WebElement amenitiesFilter;

	@FindBy(xpath = "//button[@aria-label='Sort by: Price']")
	private WebElement sortByPrice;
	
	@FindBy(xpath = "//html[not(contains(@class,'active-modal'))][@data-version]")
	 private WebElement pageLoaded;
	
	@FindBy(xpath = "//button[@class='btn-secondary btn-sub-action  gt-add-btn']")
	 private WebElement selectCarBtn;
	

	public void clickOnsortByPrice() {
		wait(sortByPrice);
		sortByPrice.click();
		wait(pageLoaded);
	}
	public boolean amenitiesFilterIsPresent() {
		return amenitiesFilter.isDisplayed();
	}

	public boolean almostAResult() {
		if (results.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean searchByPropertyNameBoxIsPresent() {
		return searchByPropertyNameBox.isDisplayed();
	}

	public boolean sortOptionsBarIsPresent() {
		return sortOptionsBar.isDisplayed();
	}

	public boolean lblStartChoosingYourHotelIsPresent() {
		wait(lblStartChoosingYourHotel);
		return lblStartChoosingYourHotel.isDisplayed();
	}

	public int numberOfResults() {
		return listResult.size();
	}

	public int numberOfHoursResults() {
		return hoursList.size();
	}

	public int numberOfSelectButtons() {
		return selectButtons.size();
	}

	public void waitToLoadResults() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.attributeToBe(fillBar, "style", "width: 100%;"));
	}

	public int numberOfDetailsAndBagageFeesResults() {
		return detailsAndBagageFeesList.size();
	}

	public List<String> getOptionsOfSortDropDown() {
		List<String> result = new ArrayList<String>();
		for (WebElement element : optionsSortDropDown) {
			result.add(element.getText());
		}
		return result;

	}

	public void sortByLowerPrice() {
		sortDropDown.click();
		priceLowest.click();
	}

	public boolean isSortedByLowerPrice() {
		int aux = getPriceOfElement(pricesList.get(0));
		for (WebElement element : pricesList) {
			int actual = getPriceOfElement(element);
			if (actual >= aux) {
				aux = actual;
			} else {
				return false;
			}
		}

		return true;
	}

	public boolean hotelsAreSortedByLowerPrice() {
		wait(pageLoaded);
		wait(result);
		int aux = getPriceOfElement(priceHotelsList.get(0));
		for (WebElement element : priceHotelsList) {
			int actual = getPriceOfElement(element);
			if (actual >= aux) {
				aux = actual;
			} else {
				return false;
			}
		}

		return true;
	}
	private int getPriceOfElement(WebElement element) {
		return Integer.valueOf(element.getText().replace("$", "").replace(",", "").replace(" ", ""));
	}

	public void selectTheResultnumber(int number) {
		getDriver().manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		selectButtons.get(number - 1).click();
		wait.until(ExpectedConditions.visibilityOf(rulesAndRestrictionsVisibleSection));
		selectThisFareButtons.get(number - 1).sendKeys(Keys.ENTER);
	}
	
	public void selectTheFlightResultnumber(int number) {
		//wait(selectButton);
		getDriver().manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		selectButtons.get(number - 1).click();
	}

	public ReviewTripPage selectSecondFlightNumber(int number) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(rulesAndRestrictionsList.get(0)));
		selectButtons.get(number - 1).click();
		return new ReviewTripPage(getDriver());

	}
	
	public SelectRoomOfHotelPage selectTheFirstResultWithAlmost3Stars() {
		WebElement actual,base;
		String name="",stars="";
		int price=0;
		for (int i = 0; i < results.size(); i++) {
			base=results.get(i);
			actual= base.findElements(By.xpath(".//span[contains(@class,'icon-stars')]")).get(0);
			System.out.println(actual.getAttribute("title"));
			if (Float.parseFloat(actual.getAttribute("title"))>=3.0) {
				name=base.findElements(By.xpath(".//h4[@class='hotelName fakeLink']")).get(0).getText();
				price=getPriceOfElement(base.findElements(By.xpath(".//li[@class='actualPrice price fakeLink ']")).get(0));
				stars=actual.getAttribute("title");
				results.get(i).click();
			}
		}
		swapToLoadedWindowWithTitle(getDriver(), "Book");
		return new SelectRoomOfHotelPage(getDriver(), price, name, stars);
	}
	
	public TripDetailPage clickOnSelectCarBtn() {
		
//		if (selectCarBtn.isDisplayed()) {
//			wait(selectCarBtn);
//			selectCarBtn.click();
//		}
		
		return new TripDetailPage(getDriver());
	}

}
