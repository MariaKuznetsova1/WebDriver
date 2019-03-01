package ru.pageobjects.yahoo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordPage extends ParentPage{
	private static final String PASSWORD_ID = "login-passwd";
	private static final String GO_TO_MAIL_ID = "yui_3_18_0_3_1550666194709_1071";
	private static final String SUBMIT_BATTON_ID = "login-signin";
	
	@FindBy(id = PASSWORD_ID)
	private WebElement webPassword;
	
	@FindBy(id = SUBMIT_BATTON_ID)
	private WebElement submit;
	
	public PasswordPage() {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public PasswordPage setPassword(String password) throws InterruptedException {
//		elementHandler.waitElement(By.id(PASSWORD_ID));
		webPassword.clear();
		webPassword.sendKeys(password);		
		return this;
	}

	public MainPage submit() {
		submit.click();
		
		return new MainPage();
	}
	
}
