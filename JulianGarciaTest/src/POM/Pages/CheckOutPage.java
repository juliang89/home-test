package POM.Pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;

import POM.WebHelper;

public class CheckOutPage extends WebHelper{
	
	By fullName = By.id("fname");
	By cardName = By.id("cname");
	By emailField = By.id("email");
	By creditCard = By.id("ccnum");
	By addressField = By.id("adr");
	By expMonthDropdown = By.id("expmonth");
	By cityField = By.id("city");
	By expYearField = By.id("expyear");
	By cvvField = By.id("cvv");
	By stateField = By.id("state");
	By zipField = By.id("zip");
	By checkBox = By.name("sameadr");
	By continueToCheckOut = By.xpath("/html/body/div[2]/div[1]/div/form/button");
	By confirmationText = By.id("order-confirmation");
	By cart = By.xpath("/html/body/div[2]/div[2]/div");
	By totalProducts = By.xpath("/html/body/div[2]/div[2]/div/h4/span/b");
	
	
	
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean validateTotalCart() {

		List<WebElement> prices = findElements(By.tagName("span"));
		int totalElements = prices.size();

		int totalProducts = prices.size()-2;
		int sum= 0;
		
		
			for (int i = 1; i <= totalProducts; i++) {
				
				int actualValueElement = Integer.parseInt(prices.get(i).getText().replace("$",""));
				System.out.print(actualValueElement);
			    sum += actualValueElement;
			}
			
		int total = Integer.parseInt(prices.get(totalElements-1).getText().replace("$",""));
		if(total == sum) {
			return true;
		}
		return false;
	}
	
	public void CompleteForm(String name, String card, String email, String credit, String address, String expMonth, String city, String expYear, String cvv, String state, String zip) throws InterruptedException{
		sendKeys(name, fullName );
		sendKeys(card, cardName );
		sendKeys(email, emailField );
		sendKeys(credit, creditCard );
		sendKeys(address, addressField );
		sendKeys(expMonth, expMonthDropdown );
		sendKeys(city, cityField );
		sendKeys(expYear, expYearField );
		sendKeys(cvv, cvvField );
		sendKeys(state, stateField );
		sendKeys(zip, zipField );
	}
	
	public void CheckTheCheckBox () {
		
		WebElement checkbox = findElement(checkBox);

		if(checkbox.isSelected() == false) {
	
			click(checkBox);

		}					
	}
	
	public void ClickContinueToCheckOut() {
		click(continueToCheckOut);
	}
	
	public boolean ValidateCheckBoxWarning() throws InterruptedException{
			
		WebElement checkbox = findElement(checkBox);
		//Validate that the checkbox is not selected
		if(checkbox.isSelected() == false) {			
			click(continueToCheckOut);
			Alert alert = getAlert();
			alert.accept();
			
			try {			   
			    alert.accept();			   
			} catch (NoAlertPresentException e) {
				return true;
			}			
			
		}
		//If checkbox is selected uncheck it and try to continue
		click(checkBox);	
		click(continueToCheckOut);
		Alert alert = getAlert();
	    alert.accept();
			
	    try {			   
		    alert.accept();
		   
		} catch (NoAlertPresentException e) {
			return true;
		}
	    
	    return false;
	}
	
	public String ReturnConfirmationText() {
		
		String message = getText(confirmationText);	
		
		return message;
		
		}
	
	 

}
