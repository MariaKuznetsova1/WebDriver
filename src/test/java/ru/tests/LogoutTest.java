package ru.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LogoutTest extends ParentTest {

	@Parameters("login")
	@Test
	public void logoutTest(String login) {
		box.exit();
		assertFalse(driver.getTitle().contains(login));
	}
}
