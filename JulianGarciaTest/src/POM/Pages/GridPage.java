package POM.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import POM.WebHelper;

public class GridPage extends WebHelper {
	
	public GridPage(WebDriver driver) {
		super(driver);

	}

	//By products = By.id("menu");
	public String getProductName(int numberOnTheGrid) {
		List<WebElement> products = findElements(By.tagName("h4"));		

		WebElement elements = products.get(numberOnTheGrid);

		String element = elements.getText();

		return element;
		
	}
	
	public String getProductPrice(int numberOnTheGrid) {
			
		List<WebElement> prices = findElements(By.tagName("p"));
	
		WebElement elements = prices.get(numberOnTheGrid);

		String element = elements.getText();

		return element;
		
	}
	
	public boolean validateProductElement() {
		
		List<WebElement> elements = findElements(By.id("menu"));
		boolean allElementsValid = true;
		
		
		for (WebElement element : elements) {

		        boolean hasImage = element.findElement(By.tagName("img")).isDisplayed();
		        boolean hasTitle = element.findElement(By.tagName("h4")).isDisplayed();
		        boolean hasPrice = element.findElement(By.id("item-price")).isDisplayed();
		        boolean hasButton = element.findElement(By.tagName("button")).isDisplayed();
		        if (!(hasImage && hasTitle && hasPrice && hasButton)) {
		        	allElementsValid = false;
		            break;        
				}
			}
		return allElementsValid;

	}
}

