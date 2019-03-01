package ru;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ElementHandler {
	private WebDriver driver;
	private int MIN_PERIOD_MS = 10;
	private int MAX_PERIOD = 5000;
	
	public ElementHandler(WebDriver driver) {
		this.driver = driver;
	}
	/**
	 * 
	 * @param locator
	 * @return
	 */
	public  boolean isPresentElement(By by) {
		try {
			driver.findElement(by);
		}catch(NoSuchElementException e) {
			return false;
		}
		return true;
	}

	public void waitElement(By by) throws InterruptedException {
		int period = 0;
		do {
			Thread.sleep(MIN_PERIOD_MS);
		period += MIN_PERIOD_MS;
		}
		while ((period!= MAX_PERIOD)||(!isPresentElement(by)));		
	}
}
