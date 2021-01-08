Feature: Update Permission

  Background:
    Given I log in Salesforce with valid User credentials

  @createUsersPermission @deleteUsersPermission
  Scenario: Update permission information in Permissions sets section
    When I navigate to Permissions sets page
    And I edit the permission with the following information
      | Etiqueta         | new name UNIQUE_ID        |
      | Nombre de la API | new name UNIQUE_ID        |
      | Descripción      | new description UNIQUE_ID |
    Then The permission information should be updated in Permission Sets section
    And The permission information should be updated in Permissions sets section table

