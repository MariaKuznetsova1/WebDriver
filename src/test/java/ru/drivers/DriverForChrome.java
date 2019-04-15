package ru.drivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverForChrome {
	private static  WebDriver instance = null;	
	
	private DriverForChrome() {		
	}
	
	public static WebDriver getDriver() {
		if (instance == null) { // если объект еще не создан
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			instance = new ChromeDriver(); // создать новый объект			
			instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return instance; // вернуть ранее созданный объект		
	}
	
}
