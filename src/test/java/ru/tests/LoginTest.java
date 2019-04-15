package ru.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends ParentTest {

	@Test
	@Parameters("login")
	public void checkLoginning(String login) throws InterruptedException {
		assertTrue(driver.getTitle().contains(login));
	}
}
