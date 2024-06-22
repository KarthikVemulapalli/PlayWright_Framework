@ShopByBrand
Feature: Shop By Brand Test Cases

  Scenario: Order Product from Ace Pump Page
  	Given user launches application url
  	When user clicks on "ShopByBrand" link on home page
  	Then user clicks on "AcePump" link on ShopByBrand page
  	And user selects the product "Ace Pumps Repair Kit Universal Ace Roller Pumps"
  	And user enters product quantity "2" and add to cart
  	And user clicks on ProceedToCheckout link
  	And user enters email "test@mail.com" firstname "TestFName" lastname "TestLName" in shipping address
  	And user enters street address "Test Address Lane 1" country "DZ" city "TestArea" postalcode "11111" phonenumber "9199191999" in shipping address
  	And user enter credit card details "4111 1111 1111 1111" "6" "2027" "123"