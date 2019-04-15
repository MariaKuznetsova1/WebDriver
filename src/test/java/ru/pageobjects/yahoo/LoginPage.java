package ru.pageobjects.yahoo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends ParentPage {

	private static final String LOGIN_ID = "login-username";
	private static final String PASSWORD_ID = "login-passwd";

	public LoginPage() {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public LoginPage enterLoginAndGo(String loginValue) throws InterruptedException {
		WebElement loginInput = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id(LOGIN_ID)));
		loginInput.clear();
		loginInput.sendKeys(loginValue);		
		loginInput.sendKeys(Keys.ENTER);
		return new LoginPage();
	}

	public MenuPage enterPassword(String password) {
		WebElement webPassword = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id(PASSWORD_ID)));
		webPassword.clear();
		webPassword.sendKeys(password);	
		webPassword.sendKeys(Keys.ENTER);
		return new MenuPage();
	}

}
