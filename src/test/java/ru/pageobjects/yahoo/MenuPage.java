package ru.pageobjects.yahoo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.drivers.DriverFactory;
import ru.drivers.TypeOfDriver;

public class MenuPage extends ParentPage {

	private static final String NEW_LETTER_CSS = "[data-test-id*='compose-button']";
	private static final String CLICK_DRAFTS_CSS = "[aria-label*=draft]";
	private static final String EXIT_CSS = "span[role*=presentation]";
	private static final String LOGOUT_CSS = "[href*=logout]";
	private static final String COUNT_OF_LETTERS_ATTRIBUT_NAME = "data-test-total-count";
	private static final String CHECK_SEND_CSS = "[data-test-folder-name*=Sent]";

	@FindBy(css = NEW_LETTER_CSS)
	private WebElement createNewLetterButton;

	@FindBy(css = CLICK_DRAFTS_CSS)
	private WebElement draftItem;
	
	@FindBy(css = CHECK_SEND_CSS)
	private WebElement sentItem;
	
	
	public MenuPage() {
		super(driver);
		DriverFactory factory = new DriverFactory();
		driver = factory.getDriver(TypeOfDriver.CHROME);
		PageFactory.initElements(driver, this);
	}

	public NewLetterPage createNew() {
		Actions act = new Actions(driver);
		act.click(createNewLetterButton).build().perform();
//		createNewLetterButton.click();
		return new NewLetterPage();
	}

	public AnyLetterPage checkDraft() {
		Actions act = new Actions(driver);
		act.click(draftItem).build().perform();
//		draftItem.click();
		return new AnyLetterPage();
	}

	public AnyLetterPage checkSent() {
		Actions act = new Actions(driver);
		act.click(sentItem).build().perform();
//		sentItem.click();
		return new AnyLetterPage();
	} 
	
	public LoginPage exit() {
		Actions act = new Actions(driver);
		WebElement exit = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(EXIT_CSS)));
		act.click(exit).build().perform();
		WebElement logout = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(LOGOUT_CSS)));
		act.click(logout).build().perform();
//		exit.click();
//		logout.click();
		return new LoginPage();
	}

	public int checkCountDraft() {
		return Integer.parseInt(draftItem.getAttribute(COUNT_OF_LETTERS_ATTRIBUT_NAME));
	}

	public int checkCountSent() {
		return Integer.parseInt(sentItem.getAttribute(COUNT_OF_LETTERS_ATTRIBUT_NAME));
	}

}
