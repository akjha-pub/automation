package controller;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WebPage {

	public WebDriverWait explicitWaitByVisibilityOfElement(TestDataFactory testdataFactory, WebElement el) {
		WebDriverWait wait=new WebDriverWait(testdataFactory.getDriver(), 20);
		int attempts=0;
		while(attempts<2){
			 try {
				 	wait.until(ExpectedConditions.visibilityOf(el));
	                break;
	            } catch(StaleElementReferenceException e) {
	            }
	            attempts++;
		}
		
		return wait;
	}
	
	
	public WebDriverWait explicitWaitForElelmentToClickable(TestDataFactory testdataFactory, WebElement el) {
		WebDriverWait wait=new WebDriverWait(testdataFactory.getDriver(), 20);
		int attempts=0;
		while(attempts<2){
			 try {
				 wait.until(ExpectedConditions.elementToBeClickable(el));
	                break;
	            } catch(StaleElementReferenceException e) {
	            }
	            attempts++;
		}
		
		return wait;
	}
}
