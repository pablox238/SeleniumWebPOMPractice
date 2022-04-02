package com.automation.training.autotraining.tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.automation.training.autotraining.pages.CruisesSearchPage;
import com.automation.training.autotraining.pages.ResultOfSearchCruisesPage;
import com.automation.training.autotraining.pages.TravelocityHomePage;

public class CruiseTests{

	static MyDriver myDriver;
	static TravelocityHomePage home;
	@Before
	public void beforeClass() {
		myDriver = new MyDriver("");
		home = new TravelocityHomePage(myDriver.getDriver());
	}
	
	
	@Test
	public void search() {
		CruisesSearchPage search= home.clickCruisesHeader(); 
		ResultOfSearchCruisesPage result= search.searchCruises();
		result.clickOnCruiseLenght1014();
		assertTrue(result.discountsInPageArePresent());
		assertTrue(result.pricesInPageArePresent());
		result.selectTheBestOffer();
		assertTrue(result.tripSummaryIsVisible());
	}
	
	
	@After
	public void afterClass() {
		home.dispose();
	}
}
