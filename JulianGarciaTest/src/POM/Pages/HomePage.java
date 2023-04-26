package POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import POM.WebHelper;

public class HomePage extends WebHelper{
	
	

	By welcome = By.id("welcome-message");
	By userName = By.id("username");
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public String ReturnWelcomeText() {
		
		String message = getText(welcome);	
		
		return message;
		
		}
	
	
}
