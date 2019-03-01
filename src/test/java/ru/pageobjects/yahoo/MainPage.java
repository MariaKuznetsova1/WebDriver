package ru.pageobjects.yahoo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends ParentPage {

	private static final String NEW_LETTER_CSS = "[data-test-id*='compose-button']";
	private static final String CLICK_DRAFTS_CSS = "[data-test-folder-name='Draft']";
	private static final String EXIT_ID = "ybarAccountMenu";
	private static final String LOGOUT_XPATH = "//*[contains(@href,'logout')]";
	private static final String COUNT_OF_DRAFTS_ATTRIBUT_NAME = "data-test-total-count";
	//private static final String CHECK_SEND_CSS = "[data-test-folder-name*='Sent']";

	@FindBy(css = NEW_LETTER_CSS)
	private WebElement createNewLetter;

	@FindBy(css = CLICK_DRAFTS_CSS)
	private WebElement clickDraft;

	@FindBy(id = EXIT_ID)
	private WebElement exit;

//	@FindBy(css = CHECK_SEND_CSS)
//	private WebElement checkSendLetters;

	public MainPage() {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public NewLetterPage createNew() {
		createNewLetter.click();
		return new NewLetterPage();
	}

	public DraftPage checkDraft() {
		clickDraft.click();
		return new DraftPage();
	}

	public MainPage exit() {
		exit.click();
		driver.findElement(By.xpath(LOGOUT_XPATH)).click();
		return this;
	}

	public int checkCountDraft() {
		return Integer.parseInt(clickDraft.getAttribute(COUNT_OF_DRAFTS_ATTRIBUT_NAME));
	}
	
//	public SentPage checkSentFolder() {
//		checkSendLetters.click();
//		return new SentPage();
//	}

}
