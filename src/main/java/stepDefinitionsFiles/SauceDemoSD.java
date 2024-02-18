package stepDefinitionsFiles;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javaFiles.JavaFunctions;
import javaFiles.Paths;


public class SauceDemoSD {

	JavaFunctions javaFunctions = new JavaFunctions();	
	Paths paths = new Paths();	
	String Locator ;
	String Item_Name_1, Item_Name_2, Item_Name_3 ;
	double Item_Price_1, Item_Price_2, Item_Price_3, TotalPrice ;


	
	@Given("I successfully connected to the Landing page using label {string}")
	public void i_successfully_connected_to_the_landing_page_using_label(String Accepted_Usernames_Label) throws IOException {
		// start Chrome Driver
		javaFunctions.startDriver ();

		// Open Home Page
		javaFunctions.OpenURL (paths.Landing_URL);

		// Set locator of AcceptedUsernames Label to be used in assertion
		Locator = "AcceptedUsernamesLabel";
		// Check the founded Text in Login page match the expected text
		javaFunctions.assert_label (Locator,Accepted_Usernames_Label);		

	}


	@When("I Write only password without Username {string}")
	public void i_write_only_password_without_username(String Password) throws IOException {

		// Set locator of the password
		Locator = "PassWord";
		// AddText of the Password
		javaFunctions.AddText(Locator,Password);
		
		// Set locator of the button
		Locator = "LoginButton";
		// Click on the Logim button 
		javaFunctions.ClickOnButton(Locator);
	}


	@Then("I get an error message {string}")
	public void i_get_an_error_message(String ErrorMessage) throws IOException {

		// Set locator of Login Button to be used in assertion
		Locator = "ErrorMessage";
		// Check the founded Text in Login Button match the expected text
		javaFunctions.assert_label (Locator,ErrorMessage);		

	}


	@When("I Write registered Username with wrong Password {string} and {string}")
	public void i_write_registered_username_with_wrong_password_and(String UserName, String Password) throws IOException {
		// Set locator of the username
		Locator = "UserName";
		// ClearText of the username
		javaFunctions.ClearText(Locator);
	// AddText of the username
		javaFunctions.AddText(Locator,UserName);

		// Set locator of the password
		Locator = "PassWord";
		// ClearText of the password
		javaFunctions.ClearText(Locator);
		// AddText of the Password
		javaFunctions.AddText(Locator,Password);
		
		// Set locator of the button
		Locator = "LoginButton";
		// Click on the Logim button 
		javaFunctions.ClickOnButton(Locator);

	}

	@When("I Write registered Username with correct Password {string} and {string}")
	public void i_write_registered_username_with_correct_password_and(String UserName, String Password) throws IOException {
		// Set locator of the username
		Locator = "UserName";
		// ClearText of the username
		javaFunctions.ClearText(Locator);
		// AddText of the username
		javaFunctions.AddText(Locator,UserName);

		// Set locator of the password
		Locator = "PassWord";
		// ClearText of the password
		javaFunctions.ClearText(Locator);
		// AddText of the Password
		javaFunctions.AddText(Locator,Password);
		
		// Set locator of the button
		Locator = "LoginButton";
		// Click on the Logim button 
		javaFunctions.ClickOnButton(Locator);

	}
	
	
	@Then("I can go to Home page using label {string}")
	public void i_can_go_to_home_page_using_label(String ProductLabel) throws IOException {

		// Set locator of ProductLabel to be used in assertion
		Locator = "ProductLabel";
		// Check the founded Text in Login Button match the expected text
		javaFunctions.assert_label (Locator,ProductLabel);		

	}

	@Given("I need to close the driver")
	public void i_need_to_close_the_driver() throws IOException, InterruptedException {
		javaFunctions.Wait3Sec();
		javaFunctions.closeDriver();
	}


	@When("I filter the product by Price Low to High")
	public void i_filter_the_product_by_price_low_to_high() throws IOException {
		// Set locator of the filter button
		Locator = "Filter";
		// Click on the filter 
		javaFunctions.ClickOnButton(Locator);

		// Set locator of the selection
		Locator = "SelectLowPrice";
		// Click on the filter selection 
		javaFunctions.ClickOnButton(Locator);
}

	@When("I select some random product")
	public void i_select_some_random_product() throws IOException {
		// Set locator of the selection
		Locator = "AddToCartButtons";
		// Click on the selected buttons 1,3,4 
		javaFunctions.ClickButtonOfList(Locator,0);
		javaFunctions.ClickButtonOfList(Locator,2);
		javaFunctions.ClickButtonOfList(Locator,3);
		
	}

	@When("I save the Product names and Prices")
	public void i_save_the_product_names_and_prices() throws IOException {
		// Set locator of the Item_Names
		Locator = "Item_Name";
		// Save Name of the selected products
		Item_Name_1 = javaFunctions.GetTextOfList(Locator, 0);
		Item_Name_2 = javaFunctions.GetTextOfList(Locator, 2);
		Item_Name_3 = javaFunctions.GetTextOfList(Locator, 3);

		// Save Price of the selected products
		Locator = "Item_Price";
		Item_Price_1 = Double.parseDouble(javaFunctions.GetTextOfList(Locator, 0).replace("$", ""));
		Item_Price_2 = Double.parseDouble(javaFunctions.GetTextOfList(Locator, 2).replace("$", ""));
		Item_Price_3 = Double.parseDouble(javaFunctions.GetTextOfList(Locator, 3).replace("$", ""));
		TotalPrice = Item_Price_1 +Item_Price_2 + Item_Price_3 ;
		
		// Show Name and Pricrs of the selected products
		System.out.println("Item Name is " + Item_Name_1 + ", and item price is " + Item_Price_1);
		System.out.println("Item Name is " + Item_Name_2 + ", and item price is " + Item_Price_2);
		System.out.println("Item Name is " + Item_Name_3 + ", and item price is " + Item_Price_3);
		System.out.println("Total Price is  " + TotalPrice);

	}

	@When("I click Cart Icon")
	public void i_click_cart_icon() throws IOException {
		// Set locator of the Add to cart icon
		Locator = "AddToCartIcon";
		// Click on the filter selection 
		javaFunctions.ClickOnButton(Locator);

	}

	@Then("I assert going to Your Cart page using label {string}")
	public void i_assert_going_to_your_cart_page_using_label(String YourCartLabel) throws IOException {
		// Set locator of YourCartLabel to be used in assertion
		Locator = "YourCartLabel";
		// Check the founded Text in Login Button match the expected text
		javaFunctions.assert_label (Locator,YourCartLabel);		

	}

	@Then("I asset the select products by names")
	public void i_asset_the_select_products_by_names() throws IOException {
		// Set locator of ProductLabel to be used in assertion
		Locator = "Selected_Product_Name";		
		// Assert the the 1st item name
		javaFunctions.assert_Two_Texts (Item_Name_1,javaFunctions.GetTextOfList(Locator, 0));		
		// Assert the the 2nd item name
		javaFunctions.assert_Two_Texts (Item_Name_2,javaFunctions.GetTextOfList(Locator, 1));		
		// Assert the the 3rd item name
		javaFunctions.assert_Two_Texts (Item_Name_3,javaFunctions.GetTextOfList(Locator, 2));		

	}

	@When("I click Checkout")
	public void i_click_checkout() throws IOException {
		// Set locator of the Checkout button
		Locator = "CheckoutButton";
		// Click on the filter selection 
		javaFunctions.ClickOnButton(Locator);

	}

	@Then("I assert going to Your Information page using label {string}")
	public void i_assert_going_to_your_information_page_using_label(String YourInformationLabel) throws IOException {
		// Set locator of Your InformationLabel to be used in assertion
		Locator = "YourInformationLabel";
		// Check the founded Text in Login Button match the expected text
		javaFunctions.assert_label (Locator,YourInformationLabel);		

	}

	@When("I add my information without Firstname {string} and {string}")
	public void i_add_my_information_without_firstname_and(String LastName, String Postal) throws IOException {

		// Set locator of the LastName
		Locator = "LastName";
		// AddText of the LastName
		javaFunctions.AddText(Locator,LastName);
		
		// Set locator of the Postal
		Locator = "Postal";
		// AddText of the Postal
		javaFunctions.AddText(Locator,Postal);

		// Set locator of the button
		Locator = "ContinueButton";
		// Click on the ContinueButton button 
		javaFunctions.ClickOnButton(Locator);

	}

	@Then("I get an message {string}")
	public void i_get_an_message(String Information_Error_MSG) throws IOException {
		// Set locator of Error Message to be used in assertion
		Locator = "Information_Error_MSG";
		// Check the founded Text in Login Button match the expected text
		javaFunctions.assert_label (Locator,Information_Error_MSG);		

	}


	@When("I add all my information {string} and {string} and {string}")
	public void i_add_all_my_information_and_and(String FirstName, String LastName, String Postal) throws IOException {
		// Set locator of the LastName
		Locator = "LastName";
		// Clear of the LastName
		javaFunctions.ClearText(Locator);
		// AddText of the LastName
		javaFunctions.AddText(Locator,LastName);

		// Set locator of the FirstName
		Locator = "FirstName";
		// Clear of the FirstName
		javaFunctions.ClearText(Locator);
		// AddText of the FirstName
		javaFunctions.AddText(Locator,FirstName);
		
		// Set locator of the Postal
		Locator = "Postal";
		// Clear Text of the Postal
		javaFunctions.ClearText(Locator);
		// AddText of the Postal
		javaFunctions.AddText(Locator,Postal);

	}


	@When("I Click Continue")
	public void i_click_continue() throws IOException {
		// Set locator of the button
		Locator = "ContinueButton";
		// Click on the ContinueButton button 
		javaFunctions.ClickOnButton(Locator);

	}

	@Then("I assert going to Overview page using label {string}")
	public void i_assert_going_to_overview_page_using_label(String OverViewLabel) throws IOException {
		// Set locator of Your InformationLabel to be used in assertion
		Locator = "OverViewLabel";
		// Check the founded Text in OverViewLabel match the expected text
		javaFunctions.assert_label (Locator,OverViewLabel);		

	}

	@Then("I asset the Price Total")
	public void i_asset_the_price_total() throws IOException {
		// Set locator of total price to be used in assertion
		Locator = "TotalPrices";
		// Assert the total prices is correct
		javaFunctions.assert_label (Locator,Double.toString(TotalPrice));		
	}

	@When("I click Finish")
	public void i_click_finish() throws IOException {
		// Set locator of the button
		Locator = "FinishButton";
		// Click on the FinishButton button 
		javaFunctions.ClickOnButton(Locator);

	}

	@Then("I assert going to Complete page using label {string}")
	public void i_assert_going_to_complete_page_using_label(String CompleteLabel) throws IOException {
		// Set locator of CompleteLabel to be used in assertion
		Locator = "CompleteLabel";
		// Assert the CompleteLabel is correct
		javaFunctions.assert_label (Locator,CompleteLabel);		

	}

	@When("I click the Menu Button")
	public void i_click_the_menu_button() throws IOException {
		// Set locator of the button
		Locator = "MenuButton";
		// Click on the MenuButton 
		javaFunctions.ClickOnButton(Locator);

	}

	@When("I click Logout")
	public void i_click_logout() throws IOException {
		// Set locator of the button
		Locator = "LogoutButton";
		// Click on the LogoutButton 
		javaFunctions.ClickOnButton(Locator);

	}

	@Then("I assert going to Landing page using label {string}")
	public void i_assert_going_to_landing_page_using_label(String Accepted_Usernames_Label) throws IOException {
		// Set locator of AcceptedUsernames Label to be used in assertion
		Locator = "AcceptedUsernamesLabel";
		// Check the founded Text in Login page match the expected text
		javaFunctions.assert_label (Locator,Accepted_Usernames_Label);		

	}
}
