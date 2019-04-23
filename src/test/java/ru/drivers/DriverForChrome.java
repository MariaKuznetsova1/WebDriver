package ru.drivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverForChrome {
	private static WebDriver instance = null;

	private DriverForChrome() {
	}

	public static WebDriver getDriver() {
		if (instance == null) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			instance = new ChromeDriver();
			instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return instance;
	}

}
