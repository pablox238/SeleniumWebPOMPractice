package com.automation.training.autotraining.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultOfSearchHotelsPage extends BasePage {

	public ResultOfSearchHotelsPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath = "//li[.='Sponsored']")
	private List<WebElement> sponsoredResults;
	
	@FindBy(xpath = "//li[.='Sponsored']")
	private WebElement sponsoredResult;
	
	@FindBy(xpath = "//div[@id='resultsContainer']/section/article[@data-hotelid]")
	List<WebElement> listResult;
	
	@FindBy(xpath = "//div[@id='mod-signup-banner']//input[@id='mer-banner-signup-email']")
	private WebElement emailDiscount;
	
	
	public int numberOfSponsoredResults() {
		return sponsoredResults.size();
	}
	
	public String sponsoredResultsAppearFirst() {
		getDriver().manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(sponsoredResult));
		for(int i=0;i<numberOfSponsoredResults();i++) {
			List<WebElement> actual= listResult.get(i).findElements(By.xpath(".//li[.='Sponsored']"));
			if (actual.size()!=1) {
				return "Not all the sponsored results are displayed first";
			}
		}
		
		return "All the sponsored results are displayed first";
	}
	
	public boolean optionToReceiveDiscountIsPresent() {
		return emailDiscount.isEnabled();
	}
	
		

	}

