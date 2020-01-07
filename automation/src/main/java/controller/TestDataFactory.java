package controller;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

public class TestDataFactory {

	private String testCaseName;
	private JSONObject TestCaseParameter;
	public WebDriver driver;
	public String amazonprice;
	public String flipkartprice;
	
	
	
	public String getTestCaseName() {
		return testCaseName;
	}
	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}
	
	public JSONObject getTestCaseParameter() {
		return TestCaseParameter;
	}
	public void setTestCaseParameter(JSONObject jsonObject) {
		TestCaseParameter = jsonObject;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public String getAmazonprice() {
		return amazonprice;
	}
	public void setAmazonprice(String amazonprice) {
		this.amazonprice = amazonprice;
	}
	public String getFlipkartprice() {
		return flipkartprice;
	}
	public void setFlipkartprice(String flipkartprice) {
		this.flipkartprice = flipkartprice;
	}

}
