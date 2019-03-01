package ru.pageobjects.yahoo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends ParentPage {

	private static final String SUBMIT_BATTON_ID = "login-signin";
	private static final String LOGIN_ID = "login-username";

	@FindBy(id = LOGIN_ID)
	private WebElement loginInput;

	@FindBy(id = SUBMIT_BATTON_ID)
	private WebElement submit;

	public LoginPage() {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public LoginPage setLogin(String loginValue) throws InterruptedException {
		loginInput.clear();
		loginInput.sendKeys(loginValue);	
		return this;
	}

	public PasswordPage submit() {
		submit.click();
		return new PasswordPage();
	}

	public boolean checkFormLogin() {
		return elementHandler.isPresentElement(By.id(LOGIN_ID));
	}
}
