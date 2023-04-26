package POM.TestCases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;

import POM.Pages.LoginPage;
import POM.Pages.SearchPage;

class SearchTest {
	private WebDriver driver;
	SearchPage searchPage;

	@BeforeEach
	void setUp() throws Exception {
		searchPage = new SearchPage(driver);
		driver = searchPage.chromeDriverConnection();
		searchPage.visit("http://localhost:3100/search");
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@ParameterizedTest
    @CsvSource({
            "Selenium",
    })
	public void validateSearchResult(String word) throws InterruptedException {
		
		searchPage.searchWord(word);
		assertEquals("Found one result for " + word, searchPage.validateSearchResult(word));
	}
	
	@Test
	public void validateEmptySearchResult() throws InterruptedException {
		searchPage.clickSearchButtonWithEmptyField();
		assertEquals("Please provide a search word.", searchPage.validateSearchResult("provide"));
	}

}
