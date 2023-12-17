@Login
  Feature: Login
    User want login to website sauce demo

    @TC1
    Scenario: User login with valid credentials
      Given User already on login page
      When User input "standard_user" as username
      And User input "secret_sauce" as password
      And User click button login

    @TC2
    Scenario: User login with valid credential
      Given User already on login page
      When User input "standard_user" as userName and "secret_sauce" as password
      Then User already on inventory page
      When User sort product by "Price (low to high)"
      And User click Add to cart from product "Sauce Labs Bike Light"
      And User click Add to cart from product "Sauce Labs Onesie"
      And User click cart icon
      And User click remove product "Sauce Labs Onesie"
      And User click checkout button
      And User input valid first name "Rayhan"
      And User input valid last name "Arif"
      And User input valid postal code "63283"
      And User click continue button
      Then User verify total price "$10.79" equals to item price with tax "$10.79"
      When User click finish button
      Then User already completing the order


    @TC3
    Scenario Outline: User login with invalid credential
      Given User already on login page
      When User input "<username>" as userName and "<password>" as password
      Then User see "<errorMessage>" as error message
      Examples:
        | username      | password     | errorMessage                                                              |
        | standard_user |              | Epic sadface: Password is required                                        |
        |               | secret_sauce | Epic sadface: Username is required                                        |
        |               |              | Epic sadface: Username is required                                        |
        | rayha         | gajelas      | Epic sadface: Username and password do not match any user in this service |
