#Author: mos.yossry.cufe@gmail.com
#Task for Areeb Company
#Purchase Scenario

Feature: SauceDemo Shop

  Scenario: Checking the login to website feature

# 1st test case login without password
   Given I successfully connected to the Landing page using label "Accepted usernames"
    When I Write only password without Username "mostafa"
    Then I get an error message "Username is required"
    
# 2nd test case login with wrong Password
    When I Write registered Username with wrong Password "mostafa" and "mostafa"
    Then I get an error message "Username and password do not match any user in this service"
    
# 3rd test case login with correct Usernameand Password
    When I Write registered Username with correct Password "standard_user" and "secret_sauce"
    Then I can go to Home page using label "Products"
		And  I need to close the driver
    
    
  Scenario: Purchase some items
  
   Given I successfully connected to the Landing page using label "Accepted usernames"
    When I Write registered Username with correct Password "standard_user" and "secret_sauce"
    Then I can go to Home page using label "Products"
    
		When I filter the product by Price Low to High
		And  I select some random product
		And  I save the Product names and Prices
		And  I click Cart Icon
		Then I assert going to Your Cart page using label "Your Cart"
		And  I asset the select products by names
		
		When I click Checkout
		Then I assert going to Your Information page using label "Your Information"
		
# 1st test case continue without First Name
		When I add my information without Firstname "LastName" and "Postal"
    Then I get an message "First Name is required"
        
# 2nd test case continue with all data
    When I add all my information "Mostafa" and "Alsaddek" and "12345"
		And  I Click Continue
		Then I assert going to Overview page using label "Overview"
		And  I asset the Price Total

		When I click Finish 
		Then I assert going to Complete page using label "Complete"

		When I click the Menu Button		
		And  I click Logout
		Then I assert going to Landing page using label "Accepted usernames"
		And  I need to close the driver
