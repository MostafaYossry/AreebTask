package javaFiles;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GetElementByLocator {
	
	// -------------------------------------------------------
	// -------------------------------------------------------

	// define driver type
		public WebDriver driver ;

	// define used objects
		ReadFromExcel ReadFromExcel = new ReadFromExcel();
		Paths path = new Paths();

	// define array and array size that will contain elements from excel file (locators file)
		int ExcelLocatorElements = path.ExcelLocatorSize ;
			String[] AllExcellIntoArray = new String[ExcelLocatorElements];

	// define two arrays one for locator names the other for locators (xpaths)
		int ColExcelElements = ExcelLocatorElements/2 ;
		String[] LocatorArray = new String[ColExcelElements];
		String[] LocatorXpathArray = new String[ColExcelElements];

	// -------------------------------------------------------
	// -------------------------------------------------------

		
		public WebDriver intializeDriver ( )  
		{
			System.setProperty("webdriver.chrome.driver", path.Chrome_Driverpath );
			driver = new ChromeDriver();
			return driver;
		}

	// -------------------------------------------------------
	// -------------------------------------------------------
				
			public void CloseDriver()  
			{
				driver.close();;
			}

	// -------------------------------------------------------
	// -------------------------------------------------------
		
	// Get the xpath from the excel file based on the Locator Name
		public String GetFromExcel (String LocatorName) throws IOException 
			{
				String xpath = ReadFromExcel.GetValueBasedonOtherColText( LocatorName) ;
				return xpath ;
			}
	// -------------------------------------------------------
	// -------------------------------------------------------
			
		// By locator name >> get xpath from excel file, then return (((this element))) to other classes	
				public WebElement GetElement(String LocatorName) throws IOException {
		// get the value from excel file by the locator name
				String Xpathlocator = GetFromExcel(LocatorName);
		// get the element
					WebElement ElementsNeeded = driver.findElement(By.xpath(Xpathlocator));
					return ElementsNeeded ;
				}

	// -------------------------------------------------------
	// -------------------------------------------------------

				
	// By locator name >> get xpath from excel file, then return (((these list of elements))) to other classes	
			public List<WebElement> GetElements(String LocatorName) throws IOException {
	// get the value from excel file by the locator name
				String Xpathlocator = GetFromExcel(LocatorName);
	// get the list of elements
				List<WebElement> ElementsNeededs = driver.findElements(By.xpath(Xpathlocator));
				return ElementsNeededs ;
			}

	// -------------------------------------------------------
	// -------------------------------------------------------
			


}
