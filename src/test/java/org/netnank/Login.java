package org.netnank;

import org.test.home.BaseClass;
import org.test.home.PomPages;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends BaseClass {
	@BeforeMethod
	private void beforemethods() {
		chromeLaunch();
		impWait(20);

	}

	@AfterMethod
	private void aftermethod() {
		quit();

	}
	
	@Test
	private void test() {
		urlLaunch("https://netbanking.hdfcbank.com/netbanki");
		PomPages p=new PomPages();
		sendKeys(p.getId(), "loguchinna");
		click(p.getContinuebtn());
		sendKeys(p.getPassword(), "hplap2022");
		click(p.getCheckbox());

	}
	@Test
	private void test1() {
		System.out.println("New code");

	}
}
