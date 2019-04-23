package ru.business;

import org.apache.log4j.Logger;

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
	private static Logger logger = Logger.getLogger(YahooMailBox.class);

	public Message createNewMessage(String to, String theme, String text) {
		return new Message(to, theme, text);
	}

	public void enterInBox(String login, String password) {
		logIn.autorisation(login, password);
		logger.info(login + " has been log in");

	}

	public void toSendMessage(Message message) {
		action.clickNew();
		newLetterPage.setToField(message.getTo());
		newLetterPage.setThemeField(message.getTheme());
		newLetterPage.setBodyField(message.getBody());
		newLetterPage.pushSendButton();
		logger.info(message + " has been sent");
	}

	public void toWriteDraft(Message message) {
		action.clickNew();
		newLetterPage.setToField(message.getTo());
		newLetterPage.setThemeField(message.getTheme());
		newLetterPage.setBodyField(message.getBody());
		action.clickNew();
		logger.info("Draft has been created");
	}

	public void deleteAllDrafts() {
		letterPage.deleteAllDrafts();
		logger.info("All the drafts have been deleted");
	}

	public void deleteAllSend() {
		letterPage.deleteAllSentLetters();
		logger.info("All the sent messeges have been deleted");
	}

	public String getThemeOfMessage(int number) throws InterruptedException {
		return letterPage.getTheme(number);
	}

	public String getBodyOfMessage(int number) {
		return letterPage.getBody(number);
	}

	public void exit() {
		action.exitFromBox();
		logger.info("logout was here");

	}

	public void goToSent() {
		action.goToSentMessages();
		logger.info("enter into sent");
	}

	public void goToDraft() {
		action.goToDrafts();
		logger.info("enter into drafts");
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

	public void deletingMessagesWithCtrlA() {
		action.goToSentMessages();
		letterPage.anotherWayToDeleteMessages();
		logger.info("All the messages have been deleted");
	}

	public int getNumberOfTrash() {
		return action.getNumberOfTrash();
	}

	public void deleteTrash() {
		action.deleteAllTheTrash();
		logger.info("Basket is clean");
	}

	public void update() {
		action.update();
	}
}
