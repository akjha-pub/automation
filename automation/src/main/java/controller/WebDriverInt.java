package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.json.JSONException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverInt {
	
	public WebDriverInt(TestDataFactory testdataFactory) throws IOException, JSONException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		EventFiringWebDriver efwd =new EventFiringWebDriver(driver);
		efwd.manage().window().maximize();
		Listener list=new Listener();
		efwd.register(list);
		testdataFactory.setDriver(efwd);
	}
}
