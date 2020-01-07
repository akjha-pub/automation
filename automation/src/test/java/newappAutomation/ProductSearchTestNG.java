package newappAutomation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import controller.ExcelUtil;
import controller.SwitchWindow;
import controller.TestDataFactory;
import controller.WebDriverInt;
import pages.ProductDetailsPage;
import pages.ProductSearchPage;
import pages.HomePage;

public class ProductSearchTestNG {
	
	

	
	@DataProvider(name = "TestData")
	public static Iterator<TestDataFactory> getItemData(ITestContext testContex) throws Exception {
		return new ExcelUtil().getData().iterator();
	}
	
	
	@Test(dataProvider="TestData")
	void priceComparison(TestDataFactory testdataFactory) throws IOException, JSONException
	{
		if(testdataFactory.getTestCaseParameter().getString("flipkart").contains("flipkart"))
		{
			new WebDriverInt(testdataFactory);
			testdataFactory.getDriver().get(testdataFactory.getTestCaseParameter().getString("flipkart"));
			new HomePage(testdataFactory).closePopup(testdataFactory);
			new HomePage(testdataFactory).searchProducts(testdataFactory);
			new ProductSearchPage(testdataFactory).search(testdataFactory);
			new SwitchWindow(testdataFactory);
			new ProductDetailsPage(testdataFactory).productDetails(testdataFactory);
			testdataFactory.getDriver().quit();
		}
		new WebDriverInt(testdataFactory);
		testdataFactory.getDriver().get(testdataFactory.getTestCaseParameter().getString("url"));
		new HomePage(testdataFactory).searchProducts(testdataFactory);
		new ProductSearchPage(testdataFactory).search(testdataFactory);
		new SwitchWindow(testdataFactory);
		new ProductDetailsPage(testdataFactory).productDetails(testdataFactory);
		Map<String, String> hmap=new HashMap<String, String>();
		hmap.put("amaprice", testdataFactory.getAmazonprice());
		hmap.put("flipktprice", testdataFactory.getFlipkartprice());
		Gson gson = new Gson();
		System.out.println(gson.toJson(hmap));
		testdataFactory.getDriver().quit();
		}
}
