Feature: Place the order for Products

Scenario Outline: Search Experience for product search in both home and Offers page


Given User is on GreenCart Landing page
When User searched with shortname <Name> and extracted actual name of product
And added "3" items of the selected product to cart
Then User proceeds to Checkout and validate the <Name> items in checkout page
And verify user has ability to enter promo code and place the order


Examples:
| Name |
| Tom  |
