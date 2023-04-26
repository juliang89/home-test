package POM.TestCases;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.containsString;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;

import POM.Pages.HomePage;
import POM.Pages.LoginPage;

class LoginTest {
	
	private WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	

	@BeforeEach
	public void setUp() throws Exception {
	
		loginPage = new LoginPage(driver);
		driver = loginPage.chromeDriverConnection();
		loginPage.visit("http://localhost:3100/login");
		
	}

	

	@ParameterizedTest
    @CsvSource({
            "johndoe19, supersecret",
    })
	public void validLogin(String user, String password) throws InterruptedException {
		loginPage.SignInUser(user, password);			
		assertThat(loginPage.ReturnWelcomeText(), containsString(user) );
			
	}
	
	@ParameterizedTest
    @CsvSource({
            "johndoe12, supersecret",
            
    })
	public void invalidLogin(String user, String password) throws InterruptedException {
		loginPage.SignInUser(user, password);
		assertEquals("WRONG CREDENTIALS", loginPage.ReturnWarningText());
			
	}
	
	@Test

	public void validEmptyFields() throws InterruptedException {
		loginPage.PresSignInButtonWithFieldsEmpty();
		assertEquals("FIELDS CAN NOT BE EMPTY", loginPage.ReturnWarningText());
			
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		driver.quit();
	}

}
