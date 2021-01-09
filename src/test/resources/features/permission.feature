Feature: Update Permission

  Background:
    Given I log in Salesforce with valid User credentials

  @createUsersPermission @deleteUsersPermission
  Scenario: Update permission information in Permissions sets page
    When I navigate to Permissions sets page
    And I edit the permission with the following information
      | Label       | edit permission UNIQUE_ID             |
      | API Name    | edit permission UNIQUE_ID             |
      | Description | edit permission description UNIQUE_ID |
    Then The information should be updated in Permission Set Overview section
    And The information should be displayed in Permissions sets section table
    And The information should be match with information in Permissions sets section table

