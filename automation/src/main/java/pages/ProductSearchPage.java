package pages;

import org.json.JSONException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import controller.TestDataFactory;
import controller.WebPage;

public class ProductSearchPage extends WebPage{
	

	@FindBy(how=How.XPATH, using="//img[@alt='1984']")
	WebElement ProductSearchResult;
	

	public  ProductSearchPage(TestDataFactory testdataFactory) 
	   {
			PageFactory.initElements(testdataFactory.getDriver(), this);	
	   }

	
	public void search(TestDataFactory testdataFactory) throws JSONException
	{
		explicitWaitByVisibilityOfElement(testdataFactory, ProductSearchResult);
		ProductSearchResult.click();
	}

}
