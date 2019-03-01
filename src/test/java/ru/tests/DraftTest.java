package ru.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.Test;
import ru.pageobjects.yahoo.DraftPage;
import ru.pageobjects.yahoo.LoginPage;
import ru.pageobjects.yahoo.MainPage;

public class DraftTest extends ParentTest {
	LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
	MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
	DraftPage draftPage = PageFactory.initElements(driver, DraftPage.class);
	

	@Test(dataProvider = "dp", groups = "draft")
	public void checkingLastDraft(Object[][] object) {	
		assertEquals(draftPage.getLastTheme(),object[object.length-1][1]);
		assertEquals(draftPage.getLastBody(),object[object.length-1][2]);
	}

	@AfterGroups("draft")
	public void clearDrafts() {
		draftPage.cleanAllDraft();
	}

}
