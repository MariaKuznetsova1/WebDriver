package ru.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import ru.pageobjects.yahoo.LoginPage;
import ru.pageobjects.yahoo.MainPage;
import ru.pageobjects.yahoo.PasswordPage;

public class LoginTest extends ParentTest {
	LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
	MainPage mainPage = PageFactory.initElements(driver, MainPage.class);			
	PasswordPage passPage = PageFactory.initElements(driver, PasswordPage.class);	
	
	@Parameters({ "login", "password" })
	@BeforeTest
	public void setLogin(String login, String password) throws InterruptedException {
		loginPage.setLogin(login);
		Actions performer = new Actions(driver);
		new Actions(driver).keyDown(Keys.ENTER).build().perform();
		performer.moveByOffset(0, 0).build().perform();
		
		loginPage.submit();
		passPage.setPassword(password);
		//passPage.submit();
		//assertTrue(elementHandler.isPresentElement(By.xpath(getXpathWithAdress(login))));
	}

}
