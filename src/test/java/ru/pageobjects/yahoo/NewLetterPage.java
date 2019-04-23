package ru.pageobjects.yahoo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ru.drivers.DriverFactory;
import ru.drivers.TypeOfDriver;

public class NewLetterPage extends ParentPage {

	private static final String FIELD_TO_ID = "message-to-field";
	private static final String FIELD_SUBJECT_CSS = "[data-test-id*='compose-subject']";
	private static final String FIELD_TEXT_CSS = "[data-test-id='rte']";
	private static final String TO_SEND_A_MESSAGE_CSS = "[data-test-id=compose-send-button]";

	@FindBy(id = FIELD_TO_ID)
	private WebElement fillingOfToField;

	@FindBy(css = FIELD_SUBJECT_CSS)
	private WebElement fillingOfSubjectField;

	@FindBy(css = FIELD_TEXT_CSS)
	private WebElement fillingOfBodyOfLetter;

	@FindBy(css = TO_SEND_A_MESSAGE_CSS)
	private WebElement pushSentBatton;

	public NewLetterPage() {
		super(driver);
		DriverFactory factory = new DriverFactory();
		driver = factory.getDriver(TypeOfDriver.CHROME);
		PageFactory.initElements(driver, this);
	}


	public NewLetterPage setToField(String to) {
		Actions act = new Actions(driver);
		act.doubleClick(fillingOfToField).sendKeys(fillingOfToField, to).build().perform();
		return this;
	}

	public NewLetterPage setThemeField(String subject) {
		Actions act = new Actions(driver);
		act.doubleClick(fillingOfSubjectField).sendKeys(fillingOfSubjectField, subject).build().perform();
		return this;
	}

	public NewLetterPage setBodyField(String text) {
		Actions act = new Actions(driver);
		act.doubleClick(fillingOfBodyOfLetter).sendKeys(fillingOfBodyOfLetter, text).build().perform();
		return this;
	}

	public MenuPage pushSendButton() {
		Actions act = new Actions(driver);
		act.click(pushSentBatton).pause(500).build().perform();
//		pushSentBatton.click();
		return new MenuPage();
	}

}
