package ru.drivers;

import org.openqa.selenium.WebDriver;

public class DriverFactory{
		
	public WebDriver getDriver(TypeOfDriver driverType) {		
		switch (driverType) {
		case CHROME:
			return DriverForChrome.getDriver();		
		}
		return null;
	}
}
	

