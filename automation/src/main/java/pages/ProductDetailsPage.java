package pages;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.google.gson.Gson;

import controller.TestDataFactory;
import controller.WebPage;
import junit.framework.Assert;

public class ProductDetailsPage extends WebPage{
		
		@FindAll({
		@FindBy(how=How.XPATH, using="//span[@class='_3nCwDW']"),
		@FindBy(how=How.XPATH, using="//div[@class='a-section a-spacing-mini']//span[@class='a-text-bold']"),
		})
		WebElement deliveryInfo;
		
		@FindAll({
		@FindBy(how=How.XPATH, using="//div[@class='_3WHvuP']/ul/li"),
		@FindBy(how=How.XPATH, using="//div[@class='content']//ul/li"),
		})
		List<WebElement> productInfo;
		
		@FindAll({
		@FindBy(how=How.XPATH, using="//div[@class='_1vC4OE _3qQ9m1']"),
		@FindBy(how=How.XPATH, using="//span[contains(@class,'a-size-medium a-color-price inlineBlock')]"),
		})
		WebElement priceInfo;

		
		public  ProductDetailsPage(TestDataFactory testdataFactory) 
		   {
				PageFactory.initElements(testdataFactory.getDriver(), this);	
		   }

		
		public void productDetails(TestDataFactory testdataFactory) throws JSONException
		{
			explicitWaitByVisibilityOfElement(testdataFactory, deliveryInfo);
			String delivery= deliveryInfo.getText();
			System.out.println(delivery);
			if(testdataFactory.getTestCaseParameter().getString("flipkart").contains("flipkart"))
			{
				String price= priceInfo.getText();
				testdataFactory.setFlipkartprice(price);
			} else {
				String price= priceInfo.getText();
				testdataFactory.setAmazonprice(price);
			}
			for(WebElement e : productInfo) {
				  System.out.println(e.getText());
			}
		}
	}


















