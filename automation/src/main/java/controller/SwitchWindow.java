package controller;

import java.util.Iterator;
import java.util.Set;

public class SwitchWindow {
	
	public SwitchWindow(TestDataFactory testdataFactory) {
		Set <String> handles =testdataFactory.getDriver().getWindowHandles();
		Iterator<String> it = handles.iterator();
		while (it.hasNext()){
			String newwin = it.next();
			testdataFactory.getDriver().switchTo().window(newwin);
			}
		}

}
