package POM.Pages;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import POM.WebHelper;

public class LoginPage extends WebHelper{
	
	By userName = By.id("username");
	By password = By.id("password");
	By signInButton = By.id("signin-button");
	By warning = By.id("message");
	By welcome = By.id("welcome-message");
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	

	public void SignInUser(String user, String pass) {
		
		sendKeys(user, userName );
		sendKeys(pass, password);
		click(signInButton);
	}
	
	public void PresSignInButtonWithFieldsEmpty() {

		click(signInButton);
	}

	public String ReturnWarningText() {
		
		String message = getText(warning);		
		return message;	
	}


	public String ReturnWelcomeText() {
		
		String message = getText(welcome);			
		return message;		
	}
	
		
	

}
