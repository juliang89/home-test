package POM.TestCases;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;

import POM.Pages.CheckOutPage;
import POM.Pages.GridPage;
import POM.Pages.HomePage;
import POM.Pages.LoginPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import POM.Pages.HomePage;
import POM.Pages.LoginPage;

class GridTest {

	
	private WebDriver driver;
	GridPage gridPage;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		gridPage = new GridPage(driver);
		driver = gridPage.chromeDriverConnection();
		gridPage.visit("http://localhost:3100/grid");
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void validateProductName() {		
		assertEquals("Super Pepperoni", gridPage.getProductName(6));
	}
	
	@Test
	void validateProductPrice() {		
		assertEquals("$10", gridPage.getProductPrice(6));
	}
	
	@Test
	void validateProductElements() {		
		assertTrue(gridPage.validateProductElement());
	}

}
