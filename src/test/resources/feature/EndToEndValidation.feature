Feature: End To End Scenarios For SauceDemo

  Background:
    Given user open website
    Then  verify user is on login page

  Scenario: Verify user can login with valid credentials
    When  user login with username "standard_user" and password "secret_sauce"
    Then  verify user is on home page

  Scenario: Verify user cannot login with invalid username
    When  user login with username "standard" and password "secret_sauce"
    Then  verify login error message "Username and password do not match" displayed

  Scenario: Verify user cannot login with invalid password
    When  user login with username "standard_user" and password "secret"
    Then  verify login error message "Username and password do not match" displayed

  Scenario: Verify user cannot login with empty username and password
    When  user login with username "" and password ""
    Then  verify login error message "Username is required" displayed

  Scenario: Verify user cannot login as locked out user
    When  user login with username "locked_out_user" and password "secret_sauce"
    Then  verify login error message "Sorry, this user has been locked out" displayed

  Scenario: Verify user can add a product to cart
    When  user login with username "standard_user" and password "secret_sauce"
    Then  verify user is on home page
    When  user add a product "product" to cart
    Then  verify cart quantity got updated

  Scenario: Verify user can remove a product from cart
    When  user login with username "standard_user" and password "secret_sauce"
    Then  verify user is on home page
    When  user add a product "product" to cart
    Then  verify cart quantity got updated
    When  user click on cart icon
    Then  verify user is on cart page
    When  user click on remove button
    Then  verify product removed from cart successfully

  Scenario: Verify user can view product details
    When  user login with username "standard_user" and password "secret_sauce"
    Then  verify user is on home page
    When  user click on a product
    Then  verify product details are displayed

  Scenario: Verify user can sort products by price low to high
    When  user login with username "standard_user" and password "secret_sauce"
    Then  verify user is on home page
    When  user click on "Price (low to high)" from sort options
    Then  verify product sorted by "Price (low to high)"

  Scenario: Verify user can sort products by name (A to Z)
    When  user login with username "standard_user" and password "secret_sauce"
    Then  verify user is on home page
    When  user click on "Name (A to Z)" from sort options
    Then  verify product sorted by "Name (A to Z)"

  Scenario: Verify user can navigate to about page
    When  user login with username "standard_user" and password "secret_sauce"
    Then  verify user is on home page
    When  user open side menu and click "about" option
    Then  verify user is on about page

  Scenario: Verify user can logout from the application
    When  user login with username "standard_user" and password "secret_sauce"
    Then  verify user is on home page
    When  user open side menu and click "logout" option

  Scenario: Verify user can checkout with valid info
    When  user login with username "standard_user" and password "secret_sauce"
    Then  verify user is on home page
    When  user add a product "product" to cart
    Then  verify cart quantity got updated
    When  user click on cart icon
    Then  verify user is on cart page
    When  user click on checkout button
    Then  verify user is on checkout page
    When  user fill all checkout details "firstname" "lastname" "zipcode"
    And   click on Continue button
    Then  verify user is on review page
    When  user click on Finish button
    Then  verify user is on order confirmation page

  Scenario: Verify user cannot checkout with invalid info
    When  user login with username "standard_user" and password "secret_sauce"
    Then  verify user is on home page
    When  user add a product "product" to cart
    Then  verify cart quantity got updated
    When  user click on cart icon
    Then  verify user is on cart page
    When  user click on checkout button
    Then  verify user is on checkout page
    When  user fill all checkout details "invalid.firstname" "invalid.lastname" "invalid.zipcode"
    And   click on Continue button
    Then  verify error message displayed

  Scenario: Verify user can reset app state
    When  user login with username "standard_user" and password "secret_sauce"
    Then  verify user is on home page
    When  user add a product "product" to cart
    Then  verify cart quantity got updated
    When  user open side menu and click "reset" option
    Then  verify cart becomes empty and app got reset

  Scenario: Verify cart displays correct number of items added to cart
    When  user login with username "standard_user" and password "secret_sauce"
    Then  verify user is on home page
    When  user add multiple products to cart
    Then  verify cart showing correct quantity

  Scenario: Verify user can complete the order and come back to homepage
    When  user login with username "standard_user" and password "secret_sauce"
    Then  verify user is on home page
    When  user add a product "product" to cart
    Then  verify cart quantity got updated
    When  user click on cart icon
    Then  verify user is on cart page
    When  user click on checkout button
    Then  verify user is on checkout page
    When  user fill all checkout details "firstname" "lastname" "zipcode"
    And   click on Continue button
    Then  verify user is on review page
    When  user click on Finish button
    Then  verify user is on order confirmation page
    When  user click on back home button
    Then  verify user is on home page

  Scenario Outline: Verify user cannot login with invalid credentials
    When  user login with username "<invalid.username>" and password "<invalid.password>"
    Then  verify login error message "Username and password do not match" displayed
    Examples:
      | invalid.username | invalid.password |
      | user             | sauce            |
      | secret           | user             |
      | error            | login            |

  Scenario: Verify user can view cart from header
    When  user login with username "standard_user" and password "secret_sauce"
    Then  verify user is on home page
    When  user click on cart icon
    Then  verify user is on cart page

  Scenario: Verify user can view product image correctly
    When  user login with username "standard_user" and password "secret_sauce"
    Then  verify user is on home page
    When  user click on a product
    Then  verify product image is displayed correctly
