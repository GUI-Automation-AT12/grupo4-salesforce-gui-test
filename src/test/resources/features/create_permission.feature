Feature: Create a new permission

  Background:
  Given I log in Salesforce with valid User credentials

  @deletePermission
  Scenario: Validate the created permission in my permissions sets table
    When I navigate to Permissions sets section
    And I create a new permission with the following information
      | Etiqueta           |  Permission Example UNIQUE_ID       |
      | Nombre de la API   |  Permission_Example_UNIQUE_ID       |
      | Descripcion        |  This is a permission example      |
    And I filter the list of permission with the initial letter of the permission created
    Then The created permission information should match the information on the permissions set table
    And The Permission information should match with the information provided