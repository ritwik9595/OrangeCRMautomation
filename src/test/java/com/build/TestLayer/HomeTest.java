package com.build.TestLayer;

import java.io.FileNotFoundException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.build.PageLayer.HomePage;
import com.build.PageLayer.LoginPage;
import com.build.TestBase.TestBase;

public class HomeTest extends TestBase {
		
		LoginPage loginpage;
		HomePage homepage;

		public HomeTest() throws FileNotFoundException {
			super();
		}
			
		@BeforeMethod
		public void setup() throws Exception {
			initialization();
			loginpage = new LoginPage();
			homepage = new HomePage();
			
			homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		}
		
		@Test(priority = 1)
		public void titleTest() {
			String title=homepage.validateHomePageTitle();
			Assert.assertEquals(title, "OrangeHRM");	
			System.out.println(title);
		}
		
		@Test(priority = 2)
		public void empNameTest() {
			String empName=homepage.validateemployeetest();
			Assert.assertEquals(empName, "Paul Collings");	
			System.out.println(empName);
		}
		
		@Test(priority = 3)
		public void HomeSearch() {
			homepage.Search();
		}
		
		
		@AfterMethod
		public void teardown() {
			driver.quit();
		}

}
