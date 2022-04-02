package com.automation.training.autotraining.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectRoomOfHotelPage extends BasePage {

	private String name,stars;
	private int price;
	
	@FindBy(id = "hotel-name")
	private WebElement nameOfHotel;
	
	@FindBy(xpath = "//a[@class='price link-to-rooms']")
	private WebElement priceOfHotel;
	
	@FindBy(xpath = "//span[contains(@class,'icon-stars')]")
	private WebElement starsOfHotel;
	
	
	@FindBy(css = ".book-button-wrapper>a")
	private WebElement selectRoombtn;

	public SelectRoomOfHotelPage(WebDriver driver, int price, String name, String stars) {
		super(driver);
		this.price = price;
		this.name = name;
		this.stars = stars;
	}
	
	private int getPriceOfElement(WebElement element) {
		return Integer.valueOf(element.getText().replace("$", "").replace(",", "").replace(" ", ""));
	}
	
	public String getHotelNameInPage() {
		return nameOfHotel.getText();
	}
	
	public int getPriceOfHotelInPage() {
		wait(priceOfHotel);
		return getPriceOfElement(priceOfHotel);
	}
	
	public String getName() {
		return name;
	}

	public String getStars() {
		return stars;
	}

	public int getPrice() {
		return price;
	}

	public String getStarsOfHotelInPage() {
		return starsOfHotel.getAttribute("title");
	}
	
	public ResultOfSearchPage clickOnSelectRoomBtn() {
		selectRoombtn.click();
		return new ResultOfSearchPage(getDriver());
	}
	

}
