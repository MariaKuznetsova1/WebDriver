package ru.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import ru.business.Message;

public class NewLetterTest extends ParentTest {
	private static final String BODY_OF_LETTER_ID = "mail-app-component";

	@Test(dataProvider = "dp", dataProviderClass = ParentTest.class)
	public void writtingOfNewLetter(String to, String subject, String text) throws InterruptedException {
		Message message = box.createNewMessage(to, subject, text);
		box.toWriteDraft(message);
		assertTrue(driver.findElement(By.id(BODY_OF_LETTER_ID)).isEnabled());
		int countOfDrafts = box.getNumberOfDrafts();
		countOfDrafts++;
		int timeout = 0;
		do {
			Thread.sleep(10);
			timeout++;
		} while (countOfDrafts != box.getNumberOfDrafts() || timeout != 500);
		assertEquals(box.getNumberOfDrafts(), countOfDrafts);
	}

}
