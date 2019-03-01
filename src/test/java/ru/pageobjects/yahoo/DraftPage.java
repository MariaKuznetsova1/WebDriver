package ru.pageobjects.yahoo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class DraftPage extends ParentPage {
	private static final String CHECKBOXS_CSS = "[data-test-id='checkbox']";
	private static final String DELETE_BUTTON_CSS = "[data-test-id='toolbar-perm-delete']";
	private static final String LAST_THEME_CSS = "[data-test-id*=message-subject]";
	private static final String LAST_BODY_CSS = "[data-test-id*=snippet]"; 

	public DraftPage() {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String getLastTheme() {		
		return driver.findElement(By.cssSelector(LAST_THEME_CSS)).getText();
	}
	
	public String getLastBody() {		
		return driver.findElement(By.cssSelector(LAST_BODY_CSS)).getText();
	}

	public DraftPage cleanAllDraft() {
		driver.findElement(By.cssSelector(CHECKBOXS_CSS)).click();
		driver.findElement(By.cssSelector(DELETE_BUTTON_CSS)).click();
		return this;
	}

}
