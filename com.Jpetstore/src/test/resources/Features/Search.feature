
@searchfunctionality
Feature: verify search functionality
 Background:
      Given I click enter store link
   @productselection
  Scenario: selecting the product items
   And I verify searchfield
   And I enter pets in searchfield
   When I click searchButton
   And I selected the product and verify
    Then I verify wishlist link
    Then I verify product availability 
    @verifyfilter
 Scenario: filter result by price and language
   And I enter pets in searchfield
   When I click searchButton
   Then I verify price filter
   Then I verify language filter  
 @productdetails
   Scenario: verifying the product details
    And I enter pets in searchfield
   When I click searchButton
   And I selected the product and verify
   And I select the product
   And I verify product title
   And I verify description
   And I verify price
   And I click addtocart button
   And I verify shopping cart
   And I click proceed to checkout button
   And I click checkbox
   And I click continue button
   When I click confirm button
   Then Its display the message  
   
  @cartupdating
   Scenario: updating the cart 
    And I enter pets in searchfield
   When I click searchButton
    And I add first product to cart
   And I add second product to cart
   Then I check cart is updated
   And I click remove button
   Then I verify cart 
  
   
   