package ru.tests;

import org.testng.annotations.Test;

import ru.business.Message;

public class SendLetterTest extends ParentTest {
	private int counter = 1;

	@Test(groups = "toWriteLetter", dataProvider = "dp", dataProviderClass = ParentTest.class, priority = 0)
	public void writtingOfNewLetter(String to, String subject, String text) throws InterruptedException {
		// mainPage.checkSent();
		int countOfSent = box.getNumberOfSent();
		Message message = box.createNewMessage(to, subject, text);
		box.toSendMessage(message);
		countOfSent++;
		int timeout = 0;
		driver.get(driver.getCurrentUrl());
		do {
			Thread.sleep(10);
			timeout++;
		} while (countOfSent != box.getNumberOfSent() || timeout != 500);
		assertEquals(box.getNumberOfSent(), countOfSent);
	}

	@Test(groups = "toCheckSentLetters", dataProvider = "dp", dataProviderClass = ParentTest.class, priority = 1)
	public void checkingLastSentLetter(String to, String subject, String text) throws InterruptedException {
		box.goToSent();
		int lengt = dp().length;
		String lastTheme = box.getThemeOfMessage(lengt - counter);
		String lastBody = box.getBodyOfMessage(lengt - counter);
		assertEquals(lastTheme, subject);
		assertEquals(lastBody, text);
		counter++;
	}

	@Test(groups = "delete", priority = 2)
	public void deleteAll() {
		box.deleteAllSend();
	}

}
