package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonObject;


	public class ExcelUtil {
		

		public LinkedList<TestDataFactory> getData() throws IOException, JSONException {
			
		String filePath ="//Users//amrendrajha//Desktop//Rapido//automation//Appcreation.xlsx";
	   	FileInputStream fis= new FileInputStream(filePath);
    	XSSFWorkbook wb=new XSSFWorkbook(fis);
    	XSSFSheet sh=wb.getSheetAt(0);

    	ArrayList<LinkedList<String>> array=new ArrayList<LinkedList<String>>();
    	for(Iterator<Row> rowIterator=sh.iterator();rowIterator.hasNext();)
    	{
    		LinkedList<String>lst=new LinkedList<String>();
    		Row row=rowIterator.next();
    		for(Iterator<Cell>cellIterator=row.cellIterator();cellIterator.hasNext();)
    		{
    			Cell cell=cellIterator.next();
    			lst.add(cell.toString());
    		}
    		System.out.println(lst);
    		array.add(lst);
    	}
    	System.out.println(array);
    	LinkedList<TestDataFactory> object = new LinkedList<TestDataFactory>();
    	TestDataFactory testDataFactory=new TestDataFactory();
    	for(int i=1; i<array.size(); i++){
    	LinkedList<String>data=array.get(i);
    	System.out.println(data.get(0));
    	testDataFactory.setTestCaseName(data.get(0));
    	System.out.println(new JSONObject(String.valueOf(data.get(1))));
    	testDataFactory.setTestCaseParameter(new JSONObject(String.valueOf(data.get(1))));
    	object.add(testDataFactory);
    	}
		return object;
		
    	
		}
	}

