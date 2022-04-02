package com.automation.training.autotraining.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultOfSearchCruisesPage extends BasePage {

	@FindBy(css = ".trip-summary")
	 private WebElement tripSummary;
	
	
	@FindBy(xpath = "//legend[@id='cruise-length-options']/following-sibling::div//input[contains(@id,'length-10-14')]")
	 private WebElement cruiseLenght;
	
	@FindBy(css = ".strikeout-price-card>s")
	 private List<WebElement> discountPrices;
	
	
	@FindBy(css = ".card-price")
	 private List<WebElement> prices;
	
	
	@FindBy(xpath = "//div[contains(@id,'cruiseCard')]")
	 private List<WebElement> cruiseCards;
	
	@FindBy(xpath = "//html[not(contains(@class,'active-modal'))][@data-version]")
	 private WebElement pageLoaded;
	
	
	public ResultOfSearchCruisesPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickOnCruiseLenght1014() {
		wait(cruiseLenght);
		cruiseLenght.click();
		wait(pageLoaded);
	}
	
	public boolean discountsInPageArePresent() {
		if (discountPrices.size()>0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean pricesInPageArePresent() {
		if (prices.size()>0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean tripSummaryIsVisible() {
		wait(tripSummary);
		return tripSummary.isDisplayed();
	}
	
	public void selectTheBestOffer() {
		int aux=-1,index=0,discount;
		for (int i = 0; i < cruiseCards.size(); i++) {
			WebElement actual = cruiseCards.get(i);
			List<WebElement> originalPrice= actual.findElements(By.xpath(".//div[@class='price']//span[@class='strikeout-price-card']/s"));
			List<WebElement> discountPrice= actual.findElements(By.xpath(".//div[@class='price']//span[@class='card-price']"));
			if (originalPrice.size()==1 && discountPrice.size()==1) {
				discount=valueOf(originalPrice.get(0).getText())-valueOf(discountPrice.get(0).getText());
				if (discount>aux) {
					aux=discount;
					index=i;
				}
			}
		}
		cruiseCards.get(index).findElements(By.xpath(".//button[@aria-label='Show itinerary']")).get(0).click();
		cruiseCards.get(index).findElements(By.xpath(".//a[contains(@id,'selectSailingButton')]")).get(0).click();
		switchWindow();
	
	}
	
	private int valueOf(String value) {
		return Integer.valueOf(value.replace("$", "").replace(",", ""));
	}
	

}
