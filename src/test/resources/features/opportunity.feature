@Opportunities
Feature: Create Opportunities

  @BeforeScenarioOutline
  Scenario Outline: I create a task assigned to an account
    Given I log in Salesforce with valid User credentials
    When I navigate to Opportunity page
    And I create an Opportunity with the following data
      | Opportunity name | <Opportunity name> |
      | Close date       | <Close date>       |
      | Stage            | <Stage>            |
    Then the opportunity's name should be displayed on Opportunity details page
    And the opportunity's information should match
    Examples:
      | Opportunity name | Close date      | Stage                |
      | opportunity1     | TOMORROW        | Prospecting          |
      | opportunity2     | YESTERDAY       | Needs Analysis       |
      | opportunity3     | TODAY           | Perception Analysis  |
      | opportunity4     | 2 DAYS AGO      | Proposal/Price Quote |
      | opportunity5     | 2 DAYS FROM NOW | Closed Won           |

  @BeforeScenarioOutline
  Scenario Outline: this scenario closes the web driver instance
    When I close the driver
    Examples:
      | Opportunity  | Close    | Stage       |
      | opportunity1 | TOMORROW | Prospecting |