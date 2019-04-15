package ru.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import ru.business.YahooMailBox;
import ru.drivers.DriverFactory;
import ru.drivers.TypeOfDriver;
import ru.pageobjects.yahoo.LoginPage;
import ru.pageobjects.yahoo.MenuPage;
import ru.pageobjects.yahoo.ParentPage;

public class ParentTest extends Assert {
	protected WebDriver driver;
	protected String MAIL_ADDRESS = "seleniumtest00@mail.ru";
	protected String START_PAGE = "https://mail.yahoo.com";
	private String CROSS_NAME = "targetId";
	private String SIGN_IN_CSS = "[data-ylk='mKey:signin_click']";
	ParentPage parentPage = PageFactory.initElements(driver, ParentPage.class);
	LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
	MenuPage mainPage = PageFactory.initElements(driver, MenuPage.class);
	protected String[] FIRST_LETTER = { MAIL_ADDRESS, "one", "oneoneone" };
	protected String[] SECOND_LETTER = { MAIL_ADDRESS, "two", "twotwotwo" };
	protected String[] THIRD_LETTER = { MAIL_ADDRESS, "three", "threethreethree" };
	private String yahooMail = "Yahoo Mail";
	private String manageAccount = "manage_account";
	protected YahooMailBox box = new YahooMailBox();

	public ParentTest() {
		DriverFactory factory = new DriverFactory();
		driver = factory.getDriver(TypeOfDriver.CHROME);
		driver.manage().window().maximize();
	}

	@DataProvider(name = "dp")
	public Object[][] dp() {
		return new Object[][] { FIRST_LETTER, SECOND_LETTER, THIRD_LETTER };
	}

	@BeforeClass
	@Parameters({ "login", "password" })
	public void goToStartPageAndLogin(String login, String password) throws InterruptedException {
		driver.get(START_PAGE);
		Thread.sleep(50);
		if (driver.getTitle().equals(yahooMail)) {
			driver.findElement(By.cssSelector(SIGN_IN_CSS)).click();
		}
		Thread.sleep(50);
		if (driver.getCurrentUrl().contains(manageAccount)) {
			driver.findElement(By.name(CROSS_NAME)).click();
		}
		box.enterInBox(login, password);
	}

	@AfterClass(groups = "logout")
	@Parameters("login")
	public void logout(String login) {
		box.exit();
	}

	@AfterSuite(alwaysRun = true)
	public void closeDriver() {
		driver.quit();
	}

}
