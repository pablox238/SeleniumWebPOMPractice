package com.automation.training.autotraining.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.automation.training.autotraining.pages.HotelsSearchPage;
import com.automation.training.autotraining.pages.ResultOfSearchHotelsPage;
import com.automation.training.autotraining.pages.TravelocityHomePage;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class HotelTests {

	static MyDriver myDriver;
	static TravelocityHomePage home;
	@BeforeClass
	public static void beforeClass() {
		myDriver = new MyDriver("");
		home = new TravelocityHomePage(myDriver.getDriver());
	}
	
	
	@Test
	public void search() {
		HotelsSearchPage search= home.clickHotelsHeader();
		ResultOfSearchHotelsPage result= search.searchHotel();
		Assert.assertEquals("All the sponsored results are displayed first", result.sponsoredResultsAppearFirst());
		Assert.assertEquals(true, result.optionToReceiveDiscountIsPresent());
	}
	
	@AfterClass
	public static void afterClass() {
		home.dispose();
	}
}
