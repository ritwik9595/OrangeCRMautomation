package com.build.TestLayer;
import java.io.FileNotFoundException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.build.PageLayer.HomePage;
import com.build.PageLayer.LoginPage;
import com.build.TestBase.TestBase;

public class LoginTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;

	public LoginTest() throws FileNotFoundException {
		super();
	}
		
	@BeforeMethod
	public void setup() throws FileNotFoundException {
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void titleTest() {
		String title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "ABCD");	
		System.out.println(title);
	}
	
	@Test(priority = 2)
	public void Logintest() throws FileNotFoundException {
		homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
