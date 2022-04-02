package com.automation.training.autotraining.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.automation.training.autotraining.pages.CompleteBookingPage;
import com.automation.training.autotraining.pages.ResultOfSearchPage;
import com.automation.training.autotraining.pages.ReviewTripPage;
import com.automation.training.autotraining.pages.SearchFlightPage;
import com.automation.training.autotraining.pages.SelectRoomOfHotelPage;
import com.automation.training.autotraining.pages.TravelocityHomePage;
import com.automation.training.autotraining.pages.TripDetailPage;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class FlightTests {
	
	static MyDriver myDriver;
	static TravelocityHomePage home;
	@Before
	public void beforeClass() {
		myDriver = new MyDriver("");
		home = new TravelocityHomePage(myDriver.getDriver());
	}
	
	
	@Test
	public void search() {
		SearchFlightPage search= home.clickFlightsHeader();
		ResultOfSearchPage result= search.searchFlight();
		result.waitToLoadResults();
		Assert.assertEquals(new ArrayList<String>(Arrays.asList("Price (Lowest)", "Price (Highest)", "Duration (Shortest)", "Duration (Longest)", "Departure (Earliest)", "Departure (Latest)", "Arrival (Earliest)", "Arrival (Latest)")), result.getOptionsOfSortDropDown());
		Assert.assertEquals(result.numberOfResults(), result.numberOfSelectButtons());
		Assert.assertEquals(result.numberOfResults(), result.numberOfHoursResults());
		Assert.assertEquals(result.numberOfResults(), result.numberOfDetailsAndBagageFeesResults());
		result.sortByLowerPrice();
		Assert.assertEquals(true, result.isSortedByLowerPrice());
		result.selectTheResultnumber(1);
		ReviewTripPage review= result.selectSecondFlightNumber(3);
		review.clickOnNoThanks();
		Assert.assertEquals(true, review.PriceGuaranteeIsPresent());
		Assert.assertEquals(true, review.totalPriceIsPresent());
		Assert.assertEquals(2, review.getNumberOfResultsInfo());
		CompleteBookingPage complete= review.clickOnContinueBooking();
		assertTrue( complete.PriceGuaranteeIsPresent());
		assertTrue(complete.totalPriceIsPresent());
		assertTrue( complete.debitCreditCardTextIsPresent());
		assertTrue( complete.whoIsTravelingTextIsPresent());
		assertTrue( complete.sendInformationIsPresent());
	}
	
	@Test
	public void searchFlightPlusHotelError() {
		SearchFlightPage search= home.clickFlightsHeader();
		search.searchFlightPlusHotelError();
		Assert.assertEquals("Your partial check-in and check-out dates must fall within your arrival and departure dates. Please review your dates.", search.errorMessage());
	}
	
	@Test
	public void searchFlightPlusHotel() {
		SearchFlightPage search= home.clickFlightsHeader();
		ResultOfSearchPage result= search.searchFlightPlusHotel();
		assertTrue(result.lblStartChoosingYourHotelIsPresent());
		assertTrue(result.searchByPropertyNameBoxIsPresent());
		assertTrue(result.sortOptionsBarIsPresent());
		assertTrue(result.almostAResult());
		assertTrue(result.amenitiesFilterIsPresent());
		result.clickOnsortByPrice();
		assertTrue(result.hotelsAreSortedByLowerPrice());
		SelectRoomOfHotelPage room= result.selectTheFirstResultWithAlmost3Stars();
		assertEquals(room.getPrice(), room.getPriceOfHotelInPage());
		assertEquals(room.getName(), room.getHotelNameInPage());
		assertEquals(room.getStars(), room.getStarsOfHotelInPage());
		ResultOfSearchPage flight= room.clickOnSelectRoomBtn();
		flight.selectTheFlightResultnumber(1);
		flight.selectTheFlightResultnumber(3);
		TripDetailPage detail=flight.clickOnSelectCarBtn();
		assertTrue(detail.numberOfTicketsIsPresent());
		assertTrue(detail.tripFlightEndIsPresent());
		assertTrue(detail.tripFlightFromIsPresent());
		assertTrue(detail.tripFlightStartIsPresent());
		assertTrue(detail.tripFlightToIsPresent());
		CompleteBookingPage complete = detail.clickOnbtnNextFinalDetails();
		assertTrue( complete.reviewAndBookIsPresent());
		assertTrue(complete.tripTotalIsPresent());
		assertTrue( complete.debitCreditCardTextIsPresent());
		assertTrue( complete.whoIsTravelingTextIsPresent());
		assertTrue( complete.confirmationEmailIsPresent());
	}

	@After
	public void afterClass() {
		home.dispose();
	}

}
