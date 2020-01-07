package pages;

import org.json.JSONException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import controller.TestDataFactory;
import controller.WebPage;


public class HomePage extends WebPage{
	
	
	@FindAll({
		@FindBy(how=How.XPATH, using="//input[@class='LM6RPg']"),
		@FindBy(how=How.XPATH, using="(//input[@class='nav-input'])[2]"),
	})
	WebElement searchInput;
	
	@FindAll({
		@FindBy(how=How.XPATH, using="//button[@type='submit']"),
		@FindBy(how=How.XPATH, using="(//input[@class='nav-input' and  @type='submit']"),
		})
	WebElement searchBtn;
	
	@FindBy(how=How.XPATH, using="//button[@class='_2AkmmA _29YdH8']")
	WebElement popup;
	
	@FindAll({
	@FindBy(how=How.XPATH, using="//input[@name='sprefix']"),
	@FindBy(how=How.XPATH, using="class='LM6RPg']"),
	})
	WebElement selectProduct;
	
	public  HomePage(TestDataFactory testdataFactory) 
	   {
			PageFactory.initElements(testdataFactory.getDriver(), this);	
	   }

	
	public void searchProducts(TestDataFactory testdataFactory) throws JSONException
	{
		explicitWaitByVisibilityOfElement(testdataFactory, searchInput);
		searchInput.sendKeys(testdataFactory.getTestCaseParameter().getString("productId"));
		searchInput.sendKeys(Keys.ENTER);
//		explicitWaitByVisibilityOfElement(testdataFactory, selectProduct);
//		selectProduct.click();
//		explicitWaitByVisibilityOfElement(testdataFactory, searchBtn);
//		searchBtn.click();
	}
	
	public void closePopup(TestDataFactory testdataFactory)
	{
		explicitWaitByVisibilityOfElement(testdataFactory, popup);
		popup.click();
	}
}


	


