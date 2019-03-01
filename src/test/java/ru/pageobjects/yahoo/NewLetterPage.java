package ru.pageobjects.yahoo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLetterPage extends ParentPage {

	private static final String FIELD_TO_ID = "message-to-field";
	private static final String FIELD_SUBJECT_CSS = "[data-test-id*='compose-subject']";
	private static final String FIELD_TEXT_CSS = "[data-test-id='rte']";
	private static final String SAVE_BUTTON_XPATH = "//*[contains(@data-name,'saveDraft')]";
	private static final String SAVE_STATUS_XPATH = "//*[contains(@data-mnemo,'saveStatus')]";
	private static final String SENT_A_MESSAGE_XPATH = "//*[contains(@data-title,'Отправить')]";
	
	@FindBy(id = FIELD_TO_ID)
	private WebElement fillingOfToField;

	@FindBy(css = FIELD_SUBJECT_CSS)
	private WebElement fillingOfSubjectField;

	@FindBy(css = FIELD_TEXT_CSS)
	private WebElement fillingOfBodyOfLetter;

	@FindBy(xpath = SAVE_BUTTON_XPATH)
	private WebElement clickSaveButton;

	@FindBy(xpath = SAVE_STATUS_XPATH)
	private WebElement checkSaveStatus;

	@FindBy(xpath = SENT_A_MESSAGE_XPATH)
	private WebElement pushSentBatton;

	public NewLetterPage() {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public NewLetterPage fillingOfFieldsOfMessage(String to,String subject, String text) {	
		fillingOfToField.clear();
		fillingOfToField.sendKeys(to);	
		fillingOfSubjectField.clear();
		fillingOfSubjectField.sendKeys(subject);
		fillingOfBodyOfLetter.clear();
		fillingOfBodyOfLetter.sendKeys(text);		
		return this;
	}

	/**
	 * @param message
	 */

	public NewLetterPage pushTheSaveBatton() {
		clickSaveButton.click();
		return this;
	}


	public MainPage pushSentButton() {
		pushSentBatton.click();
		return new MainPage();
	}

}
