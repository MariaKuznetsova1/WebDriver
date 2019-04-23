package ru.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import ru.business.YahooMailBox;
import ru.drivers.DriverFactory;
import ru.drivers.TypeOfDriver;
import ru.testdatalayer.ProviderOfTestData;

public class ParentTest extends Assert {
	protected WebDriver driver;
	protected String START_PAGE = "https://mail.yahoo.com";
	private String CROSS_NAME = "targetId";
	private String SIGN_IN_CSS = "[data-ylk='mKey:signin_click']";
	private String yahooMail = "Yahoo Mail";
	private String manageAccount = "manage_account";
	protected YahooMailBox box = new YahooMailBox();
	private ProviderOfTestData provider = new ProviderOfTestData();



	public ParentTest() {
		if (driver == null) {
			DriverFactory factory = new DriverFactory();
			driver = factory.getDriver(TypeOfDriver.CHROME);
			driver.manage().window().maximize();
		}
	}

	@BeforeSuite
	@Parameters({ "login", "password", "start page" })
	public void totalCleanUp(String login, String password, String startPageAdress) throws InterruptedException {
		driver.get(startPageAdress);
		Thread.sleep(50);
		if (driver.getTitle().equals(yahooMail)) {
			driver.findElement(By.cssSelector(SIGN_IN_CSS)).click();
		}
		Thread.sleep(50);
		if (driver.getCurrentUrl().contains(manageAccount)) {
			driver.findElement(By.name(CROSS_NAME)).click();
		}
		box.enterInBox(login, password);
		box.goToDraft();
		Thread.sleep(50);
		box.deletingMessagesWithCtrlA();
		box.goToSent();
		box.deletingMessagesWithCtrlA();
		box.deleteTrash();
		box.exit();
	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {
		return provider.getTestDataFromCSV();
	}

	@BeforeClass
	@Parameters({ "login", "password", "start page" })
	public void goToStartPageAndLogin(String login, String password, String startPageAdress)
			throws InterruptedException {
		driver.get(startPageAdress);
		Thread.sleep(100);
		if (driver.getTitle().equals(yahooMail)) {
			driver.findElement(By.cssSelector(SIGN_IN_CSS)).click();
		}
		Thread.sleep(100);
		if (driver.getCurrentUrl().contains(manageAccount)) {
			driver.findElement(By.name(CROSS_NAME)).click();
		}
		box.enterInBox(login, password);
	}

	@AfterClass(groups = "logout")
	public void logout() {
		box.exit();
	}

	@AfterSuite(alwaysRun = true)
	public void closeDriver() {
		driver.quit();
	}

}
