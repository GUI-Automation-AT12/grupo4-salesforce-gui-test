Feature: Edit contact information

  Background:
    Given I log in Sales Force with valid User credentials
    @createContact @deleteContact
    Scenario: I edit the contact information
      When I navigate to contact page
      And I search for the contact on the table
      And I edit the contact information with the following information
        | Tratamiento    |  Ms          |
        | Nombre         |  Elyzabeth   |
        | Apellidos      |  Rojas       |
        | Telefono       |  60601020    |
      Then the contact name should be updated with the new values
      And the personal information should match with the information sent
      When I navigate to Contacts page
      And I search for the contact on the table
      Then The contact information on contact's table should be updated