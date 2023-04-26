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
import POM.Pages.HomePage;
import POM.Pages.LoginPage;

class CheckOutTest {
	
	private WebDriver driver;
	CheckOutPage checkOutPage;


	@BeforeEach
	void setUp() throws Exception {
		
		checkOutPage = new CheckOutPage(driver);
		driver = checkOutPage.chromeDriverConnection();
		checkOutPage.visit("http://localhost:3100/checkout");
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@ParameterizedTest
    @CsvSource({
            "Julian, 1111, a@a, 2222, address, September, city, 3, 4, 5, 6",
    })
	public void validateSuccessCheckOut(String fullName, String card, String email, String creditCard, String address, String expMonth, String city, String expYear, String cvv, String state, String zip) throws InterruptedException {		
		checkOutPage.CompleteForm(fullName, card, email, creditCard, address, expMonth, city, expYear, cvv, state, zip);
		checkOutPage.CheckTheCheckBox();
		checkOutPage.ClickContinueToCheckOut();
		assertThat(checkOutPage.ReturnConfirmationText(), containsString("Order Number: ") );	
		
	}
	
	@ParameterizedTest
    @CsvSource({
            "Julian, 1111, a@a, 2222, address, September, city, 3, 4, 5, 6",
    })
	public void validateCheckBoxWarningDesappear(String fullName, String card, String email, String creditCard, String address, String expMonth, String city, String expYear, String cvv, String state, String zip) throws InterruptedException {
		checkOutPage.CompleteForm(fullName, card, email, creditCard, address, expMonth, city, expYear, cvv, state, zip);
		assertTrue(checkOutPage.ValidateCheckBoxWarning());	
	}
	
	
	@Test
	public void validateTotalCart() throws InterruptedException {
		assertTrue(checkOutPage.validateTotalCart());

	}

}
