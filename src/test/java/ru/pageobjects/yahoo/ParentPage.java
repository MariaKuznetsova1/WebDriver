package ru.pageobjects.yahoo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import ru.ElementHandler;

public class ParentPage  {
	protected static WebDriver driver;	
	ElementHandler elementHandler = new ElementHandler(driver);

	public ParentPage(WebDriver webDriver) {
		this.driver = webDriver;
		// TODO Auto-generated constructor stub
	}

}
