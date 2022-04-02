package com.automation.training.autotraining.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.automation.training.autotraining.pages.TravelocityHomePage;

public class BaseTests {

	MyDriver myDriver;
	private TravelocityHomePage home;

	@BeforeClass
	public void beforeClass() {
		myDriver = new MyDriver("");
		home = new TravelocityHomePage(myDriver.getDriver());
	}

	@AfterClass
	public void afterClass() {
		home.dispose();
	}
	
	public TravelocityHomePage getTravelocityHomePage() {
		return home;
	}
	

}
