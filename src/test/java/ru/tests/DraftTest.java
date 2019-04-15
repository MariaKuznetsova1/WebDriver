package ru.tests;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.Test;

public class DraftTest extends ParentTest {
	private int counter = 1;

	@Test(groups = "draft", dataProvider = "dp", dataProviderClass = ParentTest.class)
	public void checkingLastDraft(String to, String subject, String text) throws InterruptedException {
		box.goToDraft();
		int lengt = dp().length;
		String lastTheme = box.getThemeOfMessage(lengt - counter);
		String lastBody = box.getBodyOfMessage(lengt - counter);
		assertEquals(lastTheme, subject);
		assertEquals(lastBody, text);
		counter++;
	}

	@AfterGroups("draft")
	public void deleteDrafts() {
		box.deleteAllDrafts();
	}

}
