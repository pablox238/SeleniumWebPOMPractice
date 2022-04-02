package com.automation.training.autotraining.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	private WebDriver driver;

	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	protected WebDriver getDriver() {
		return driver;
	}
	
	public void dispose() {
		if (driver!=null) {
				if(driver!=null) {
					driver.quit();
				}
		}
	}
	
	public void wait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 120);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void switchWindow() {
		String subWindowHandler="";
		Set<String> handles = getDriver().getWindowHandles();
		Iterator<String> iterator = handles.iterator();

		while (iterator.hasNext()){ 
			subWindowHandler = iterator.next(); 
			} 
		getDriver().switchTo().window(subWindowHandler).getTitle(); 
		System.out.println(getDriver().getTitle());
	}
	
	public static Boolean swapToLoadedWindowWithTitle(WebDriver driver, String title) {
		Boolean found = false;
		try {
			Set<String> windows = driver.getWindowHandles();
			for (String winHandle : windows) {
				driver.switchTo().window(winHandle);
				String currentTitle = driver.getTitle();
				if (currentTitle.toUpperCase().contains(title.toUpperCase())) {
					found = true;
					break;
				}
			}
		} catch (Exception e) {
		
		}
		return found;
	}
}
