package com.build.PageLayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.build.TestBase.TestBase;

public class LoginPage extends TestBase {


	@FindBy(xpath="//input[@class='oxd-input oxd-input--active' and @name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
	WebElement button;

	
	
	public LoginPage()throws FileNotFoundException {
		
		PageFactory.initElements(driver, this);
		
	}

	
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
	}

	public HomePage login(String un, String pwd) throws Exception {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

		username.sendKeys(un);
		password.sendKeys(pwd);
		button.click();
		
		return new HomePage();
		
	}
}

