package ru.business;

import ru.pageobjects.yahoo.MenuPage;

public class ActionWithMenu {
	private MenuPage menu = new MenuPage();

	public void exitFromBox() {
		menu.exit();
	}

	public void goToSentMessages() {
		menu.checkSent();
	}

	public void goToDrafts() {
		menu.checkDraft();
	}

	public int getNumberOfDrafts() {
		return menu.checkCountDraft();
	}

	public int getNumberOfSent() {
		return menu.checkCountSent();
	}

	public void clickNew() {
		menu.createNew();
	}

	public void goToBasket() {
		menu.goToBasket();
	}

	public int getNumberOfTrash() {
		return menu.checkCountTrash();
	}

	public void deleteAllTheTrash() {
		menu.deleteTrash();
	}

	public void update() {
		menu.updateThePage();
	}
}
