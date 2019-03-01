package ru.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ru.pageobjects.yahoo.LoginPage;
import ru.pageobjects.yahoo.MainPage;
import ru.pageobjects.yahoo.NewLetterPage;

public class NewLetterTest extends ParentTest {
	MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
	NewLetterPage newLetter = PageFactory.initElements(driver, NewLetterPage.class);
	LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
	
	private static final String BODY_OF_LETTER_CSS = "[data-test-id='compose']";

	@Test 
	public void openOfFormForCreateNewLetter() throws InterruptedException {
		mainPage.createNew();
		assertTrue(elementHandler.isPresentElement(By.cssSelector(BODY_OF_LETTER_CSS)));
	}
	
	@Test(dataProvider = "dp", dataProviderClass = ParentTest.class)
	public void writtingOfNewLetter(String to, String subject, String text) {	
		int countOfDrafts = mainPage.checkCountDraft();
		newLetter.fillingOfFieldsOfMessage(to, subject, text);
		countOfDrafts++;
		mainPage.createNew();
		assertEquals(mainPage.checkCountDraft(), countOfDrafts);
	}
	
}
