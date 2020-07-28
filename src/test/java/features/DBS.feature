Feature: Test feature

  Scenario: Navigation in DBS website
    Given user is in landing page
    When user clicks on Learn More button
    And user scrolls down to Singapore on left panel and clicks on it
    Then user sees a table with information about meal distribution for “Feed the City” programme

    When user adds data in table to an excel sheet
    Then user verifies that excel file is created

    When user clicks on About in header tabs
    Then user is navigated to About page

    When user clicks on Who we are tab in About page
    Then user verifies that Who we are section is displayed

    When user clicks on Our Awards & Accolades section in Who we are tab
    Then user verifies that Awards & Accolades page is displayed
    And user verifies that total number of wards displayed is 22
    And user verifies following awards displayed in page
    |Award Name    |Caption of the award                                   |
#    |A World First |Euromoney                                              |
    |The Banker    |Bank of the Year 2018                                  |
    |Global Finance|Best Bank in the World 2018                            |
    |Euromoney     |Awards For Excellence                                  |
    |Global Finance|World's Best Banks                                     |
    |Global Finance|World's Best Investment Banks and Derivatives Providers|



