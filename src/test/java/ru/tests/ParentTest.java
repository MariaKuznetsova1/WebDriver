package ru.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import ru.ElementHandler;
import ru.drivers.DriverFactory;
import ru.drivers.TypeOfDriver;
import ru.pageobjects.yahoo.DraftPage;
import ru.pageobjects.yahoo.LoginPage;
import ru.pageobjects.yahoo.MainPage;
import ru.pageobjects.yahoo.NewLetterPage;
import ru.pageobjects.yahoo.ParentPage;

public class ParentTest extends Assert {
	protected WebDriver driver;
	protected String MAIL_ADDRESS = "seleniumtest00@mail.ru";
	protected String START_PAGE = "https://login.yahoo.com";
	private String LOGIN_FORM_CSS = "[class*=login-box ]";
	ParentPage parentPage = new ParentPage(driver);
	ElementHandler elementHandler = new ElementHandler(driver);

	public ParentTest() {
		DriverFactory factory = new DriverFactory();
		this.driver = factory.getDriver(TypeOfDriver.CHROME);
		driver.manage().window().maximize();
	}

	@BeforeSuite
	public void getStartPage() throws InterruptedException {
		driver.get(START_PAGE);
	}

	@DataProvider(name = "dp")
	public Object[][] dp() {
		return new Object[][] { { MAIL_ADDRESS, "one", "oneoneone" },
			                    { MAIL_ADDRESS, "two", "twotwotwo" },			
				                { MAIL_ADDRESS, "three", "threethreethree" },
			                 	{ MAIL_ADDRESS, "four", "fourfourfour" },
			                  	{ MAIL_ADDRESS, "five", "fivefive" } };
	}

	public String getXpathWithAdress(String login) {
		String xPathWithAdress = String.format("//*[contains(*,'%s@yahoo.com')]", login);
		return xPathWithAdress;
	}

	@AfterSuite(alwaysRun = true)
	public void closeDriver() {
		driver.quit();
	}

}
