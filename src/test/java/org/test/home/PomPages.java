package org.test.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomPages extends BaseClass {

	public PomPages() {
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(xpath="//input[@type='text']")
	private WebElement id;
	
	@CacheLookup
	@FindBy(xpath="//a[text()='CONTINUE']")
	private WebElement continuebtn;
	
	@CacheLookup
	@FindBy(xpath="//input[@name='fldPassword']")
	private WebElement password;
	
	
	@CacheLookup
	@FindBy(xpath="//input[@name='chkrsastu']")
	private WebElement checkbox;


	public WebElement getId() {
		return id;
	}


	public WebElement getContinuebtn() {
		return continuebtn;
	}


	public WebElement getPassword() {
		return password;
	}


	public WebElement getCheckbox() {
		return checkbox;
	}

	
	
	
	
}
