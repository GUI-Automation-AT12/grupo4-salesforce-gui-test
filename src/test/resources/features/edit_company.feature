Feature: Edit Company

  Background:
    Given I log in Salesforce with valid User credentials

  @RestoreInformation @LoadDefaultContact
  Scenario: Edit company's information in company section
    Given I navigates to Profile Company pages
    When I navigate to Update Company Information pages
    And I edit the company information with following information
      | Organization Name | new name UNIQUE_ID                                       |
      | Primary Contact   | Contact Name UNIQUE_ID                                   |
      | Division          | Division UNIQUE_ID                                       |
      | Phone             | +59178342849                                             |
      | Fax               | 000                                                      |
      | Default Locale    | English (India)                                          |
      | Default Language  | English                                                  |
      | Default Time Zone | (GMT+13:00) New Zealand Daylight Time (Pacific/Auckland) |
    Then The company information updated in the company section