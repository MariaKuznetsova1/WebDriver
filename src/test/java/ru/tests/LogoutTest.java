package ru.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import ru.pageobjects.yahoo.LoginPage;
import ru.pageobjects.yahoo.MainPage;

public class LogoutTest extends ParentTest{	
	LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
	MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
	
	@AfterTest
	public void logout() {
		mainPage.exit();
		assertTrue(loginPage.checkFormLogin());
	}
}
