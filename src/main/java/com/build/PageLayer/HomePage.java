package com.build.PageLayer;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.build.TestBase.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//div[@class='oxd-grid-4 orangehrm-full-width-grid']//div[1]//div//div//div//div//div//following-sibling::input")
	WebElement searchname;

	@FindBy(xpath = "//div[@class='oxd-grid-4 orangehrm-full-width-grid']//following-sibling::div[3]//div//div//div")
	WebElement empDrop;

	@FindBy(xpath = "//div[@class='oxd-grid-4 orangehrm-full-width-grid']//following-sibling::div[6]//div//div//div")
	WebElement JobTitleDrop;

	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	WebElement employeeName;
	
	@FindBy(xpath = "//button[@type='submit' and @class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	WebElement searchbutton;
	
	public HomePage() throws FileNotFoundException {
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


		return driver.getTitle();
	}
	
	public String validateemployeetest() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


		return employeeName.getText();
	}
	
	public void Search() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		searchname.sendKeys("Anthony Nolan");
		
		Select select = new Select(empDrop);
		select.selectByVisibleText("Freelance");
		
		Select select1 = new Select(JobTitleDrop);
		select1.selectByVisibleText("QA Lead");
		
		searchbutton.click();
	}
	
	


}
