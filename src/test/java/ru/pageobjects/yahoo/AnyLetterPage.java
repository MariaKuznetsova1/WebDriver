package ru.pageobjects.yahoo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnyLetterPage extends ParentPage {
	private static final String LETTERS_BODIES_CSS = "[data-test-id*=snippet]";
	private static final String LETTERS_THEMES_CSS = "[data-test-id*=message-subject]";
	private static final String CHECKBOX_CSS = "[data-test-id=checkbox]";
	private static final String DELETE_BUTTON_DY_CHECKBOX_CSS = "[data-test-id*=toolbar-delete]";
	private static final String DELETE_ALL_DRAFTS_CSS = "[data-test-id=toolbar-perm-delete]";
	private static final String OK_DELETE_BUTTON_CSS = "[data-test-id=primary-btn]";


	@FindBy(css = LETTERS_THEMES_CSS)
	private List<WebElement> lastThemes;

	@FindBy(css = LETTERS_BODIES_CSS)
	private List<WebElement> lastBodies;
	
	@FindBy(css = CHECKBOX_CSS)
	private WebElement checkbox;
	
	@FindBy(css = DELETE_BUTTON_DY_CHECKBOX_CSS)
	private WebElement deleteMarkLetters;

	@FindBy(css = DELETE_ALL_DRAFTS_CSS)
	private WebElement deleteAllTheDrafts;


	public AnyLetterPage() {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String getTheme(int number) throws InterruptedException {
		int i = 0;
	do {
		Thread.sleep(10);
		 i++;
	}
		while (!lastThemes.get(number).isDisplayed() || i != 500);
		return lastThemes.get(number).getText();
	}

	public String getBody(int number) {
		return lastBodies.get(number).getText();
	}


	public void deleteAllDrafts() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", checkbox);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", deleteAllTheDrafts);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.cssSelector(OK_DELETE_BUTTON_CSS)));
		// allTheDrafts.click();
//		deleteAllTheDrafts.click();
//		driver.findElement(By.cssSelector(OK_DELETE_BUTTON_CSS)).click();
	}

	
	public void deleteAllSentLetters() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", checkbox);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", deleteMarkLetters);
//		checkbox.click();
//		deleteMarkLetters.click();		
	}
	
}
