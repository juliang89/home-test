package POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import POM.WebHelper;

public class SearchPage extends WebHelper{
	
	By search = By.name("searchWord");
	By searchButton = By.cssSelector("body > div.row > div > div > form > button");
	By result = By.id("result");
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	public void searchWord(String word) throws InterruptedException {
		
		click(search);
		sendKeys(word, search);
		click(searchButton);
		waitForTextToBePresentInElement(result, word, 10000);
		
	}
	
	public String validateSearchResult(String word) {
		WebElement results = findElement(result);
		String resultText = results.getText();
		return resultText;
	}
	
	public void clickSearchButtonWithEmptyField() {
		click(searchButton);
		waitForTextToBePresentInElement(result, "provide", 1000);
	}
	
	

}
