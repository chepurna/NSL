Feature: ShoppingHome

@Regression
Scenario: Verify page Title has value 
	When Shopping Home Page is opened in browser
	Then Asset Title of shopping home page
	Then Close the Browser

@Regression @Smoke	
Scenario: Verify shopping cart is empty
	When Shopping Home Page is opened in browser
	Then Asset Shoppingcart Empty
	Then Close the Browser

@tt		
Scenario: Verify shopping cart tooltip is MyShoppingCart
	When Shopping Home Page is opened in browser
	Then Asset Shoppingcart tooltip
	Then Close the Browser

@Regression		
Scenario: Verify sort by drop down as InStock option 
	When Shopping Home Page is opened in browser
	Then select Women section
	Then verify sort by dropdown has instock option "Price: Lowest first"
	Then Close the Browser 	 	 	