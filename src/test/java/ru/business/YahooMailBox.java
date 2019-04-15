package ru.business;

import ru.pageobjects.yahoo.AnyLetterPage;
import ru.pageobjects.yahoo.NewLetterPage;

public class YahooMailBox {
	private String login;
	private String password;
	private Message message;
	private AnyLetterPage letterPage = new AnyLetterPage();
	private NewLetterPage newLetterPage = new NewLetterPage();
	private ActionWithMenu action = new ActionWithMenu();
	private Login logIn = new Login();

	public Message createNewMessage(String to, String theme, String text) {
		return new Message(to, theme, text);
	}

	public void enterInBox(String login, String password) {
		logIn.autorisation(login, password);
	}

	public void toSendMessage(Message message) {
		action.clickNew();
		newLetterPage.fillingOfFieldsOfMessage(message.getTo(), message.getTheme(), message.getBody());
		newLetterPage.pushSendButton();
	}

	public void toWriteDraft(Message message) {
		action.clickNew();
		newLetterPage.fillingOfFieldsOfMessage(message.getTo(), message.getTheme(), message.getBody());
		action.clickNew();
	}

	public void deleteAllDrafts() {
		letterPage.deleteAllDrafts();
	}

	public void deleteAllSend() {
		letterPage.deleteAllSentLetters();
	}

	public String getThemeOfMessage(int number) throws InterruptedException {
		return letterPage.getTheme(number);
	}

	public String getBodyOfMessage(int number) {
		return letterPage.getBody(number);
	}

	public void exit() {
		action.exitFromBox();
	}

	public void goToSent() {
		action.goToSentMessages();
	}

	public void goToDraft() {
		action.goToDrafts();
	}

	public void clickNew() {
		action.clickNew();
	}

	public int getNumberOfDrafts() {
		return action.getNumberOfDrafts();
	}

	public int getNumberOfSent() {
		return action.getNumberOfSent();
	}
}
