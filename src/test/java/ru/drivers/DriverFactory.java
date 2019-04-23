package ru.drivers;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	public WebDriver getDriver(TypeOfDriver driverType) {
		switch (driverType) {
		case CHROME:
			return DriverForChrome.getDriver();
		default:
			return null;
		}
	}

	public WebDriver getDriver(String driverType) {
		if (driverType.equalsIgnoreCase("Chrome")) {
			return DriverForChrome.getDriver();
		} else {
			return null;
		}
	}
}
