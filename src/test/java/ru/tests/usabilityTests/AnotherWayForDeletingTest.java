package ru.tests.usabilityTests;

import org.testng.annotations.Test;

import ru.business.Message;
import ru.tests.ParentTest;

public class AnotherWayForDeletingTest extends ParentTest {


	@Test(groups = "sent", dataProvider = "dp", dataProviderClass = ParentTest.class, priority = 0)
	public void writtingOfNewLetter(String to, String subject, String text) throws InterruptedException {
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
	}

	@Test(priority = 1)
	public void deletingMessagesWithCtrlA() throws InterruptedException {
		int countTrash = box.getNumberOfTrash();
		int countSent = box.getNumberOfSent();
		int result = countTrash + countSent;
		box.deletingMessagesWithCtrlA();
		assertEquals(box.getNumberOfTrash(), result);
		assertEquals(box.getNumberOfSent(), 0);
	}



}
