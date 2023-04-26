package POM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebHelper {

	
	private WebDriver driver;
	
	public WebHelper(WebDriver driver) {
		
		this.driver = driver;
	}
	
		
	public WebDriver chromeDriverConnection() {
		
		System.setProperty("chromedriver", "user.dir");	   
	    driver = new ChromeDriver();	    
	    return driver;

	}
	
	 
	
	public List<WebElement> findElements(By locator){
		return driver.findElements(locator);
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
       
    public String getText(By locator) {
    	return driver.findElement(locator).getText();
    }
    
    public void sendKeys(String text, By locator) {
    	driver.findElement(locator).sendKeys(text);
    }
    
    public void click(By locator) {
    	driver.findElement(locator).click();
    }
    
    public Boolean isDisplayed(By locator) {
    	try {
    		return driver.findElement(locator).isDisplayed();
    	} catch (org.openqa.selenium.NoSuchElementException e) {
    		return false;
    	}
    }
    
    public void visit(String url) {
    	driver.get(url);
    }
    
    public Alert getAlert() {
    	Alert alert = driver.switchTo().alert();
    	return alert;
    }
    
    public WebElement waitForElementVisible(By locator, long timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public boolean waitForTextToBePresentInElement(By locator, String text, long timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }
    

	
}
