Feature: Search and Place the order for Products

@OffersPage
Scenario Outline: Search Experience for product search in both home and Offers page


Given User is on GreenCart Landing page
When User searched with shortname <Name> and extracted actual name of product
Then User searched for <Name> shortname in offers page to check if product exist with same name
And Validate product name in offers page matches with landing page 

Examples:
| Name |
| Tom  |
| Beet |