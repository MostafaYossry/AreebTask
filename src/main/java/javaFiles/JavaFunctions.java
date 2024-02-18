package javaFiles;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class JavaFunctions {

	Paths path = new Paths();
	GetElementByLocator getElementByLocator = new GetElementByLocator();
	WebElement elementNeeded ;
	List<WebElement> elementNeededs ;
	public WebDriver driver ;

	
	public void startDriver () throws IOException  {
		driver = getElementByLocator.intializeDriver() ;
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

	public void closeDriver () throws IOException  {
		getElementByLocator.CloseDriver() ;
		}

	public void OpenURL (String path ) {
		driver.get(path);
	}

	// -------------------------------------------------------
	// -------------------------------------------------------
	
	// make sure the page label is correct
	public void assert_label (String LocatorName , String Actual_label) throws IOException 
	{
		//get element by xpath in excel sheet
			elementNeeded = getElementByLocator.GetElement(LocatorName);
			//compare texts (expected from previous class and actual from UI)	
			Assert.assertTrue(elementNeeded.getText().contains(Actual_label));
	}
	
	
	public void ClickOnButton (String LocatorName) throws IOException 
	{
		//get element by xpath in excel sheet
			elementNeeded = getElementByLocator.GetElement(LocatorName);
		// Click on Button
			elementNeeded.click();	
	}
	
	public void AddText (String LocatorName, String TextToAdd) throws IOException 
	{
		//get element by xpath in excel sheet
			elementNeeded = getElementByLocator.GetElement(LocatorName);
		// Write the Text
			elementNeeded.sendKeys(TextToAdd);	
	}		


	public void ClearText (String LocatorName) throws IOException 
	{
		//get element by xpath in excel sheet
			elementNeeded = getElementByLocator.GetElement(LocatorName);
		// Write the Text
			elementNeeded.clear();
	}		
	
	
	public void ClickButtonOfList (String  LocatorName , int NumberOfButton) throws IOException 
	{
		//get element by xpath in excel sheet
		elementNeededs = getElementByLocator.GetElements(LocatorName);
	// Click on Button
		elementNeededs.get(NumberOfButton).click();
	}
	
	public String GetTextOfList (String  LocatorName , int NumberOfButton) throws IOException 
	{
		//get element by xpath in excel sheet
		elementNeededs = getElementByLocator.GetElements(LocatorName);
	// Click on Button
		return elementNeededs.get(NumberOfButton).getText();
	}

	public void assert_Two_Texts (String Text1 , String Text2) throws IOException 
	{
			//compare texts (expected from previous class and actual from UI)	
			Assert.assertTrue(Text1.equals(Text2));
	}


	
	public void Wait3Sec() throws IOException, InterruptedException 
	{
		//get element by xpath in excel sheet
		TimeUnit.SECONDS.sleep(3);
	}		

	
}
