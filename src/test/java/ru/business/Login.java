package ru.business;

import ru.pageobjects.yahoo.LoginPage;

public class Login {
	private LoginPage loginPage = new LoginPage();

	public void autorisation(String login, String password) {
		try {
			loginPage.enterLoginAndGo(login);
			loginPage.enterPassword(password);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
