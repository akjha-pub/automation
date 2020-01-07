package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.json.JSONException;

public class ReadProperties {
	
	public Object readProperties(TestDataFactory testdataFactory) throws IOException, JSONException
	{
		FileInputStream fis = new FileInputStream("//Users//amrendrajha//Desktop//Rapido//automation//config.properties");
		Properties prop=new Properties();
		prop.load(fis);
		System.out.println(prop.getProperty("flipkarturl"));
//		testdataFactory.setAmazonurl(prop.getProperty("amazonurl"));
//		testdataFactory.setAmazonurl(prop.getProperty("flipkarturl"));
//		testdataFactory.setProductId(prop.getProperty("productId"));
		return prop;
	}

}
