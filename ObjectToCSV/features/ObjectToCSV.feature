Feature: Object to CSV

    Convert an Object to a CSV string

    Scenario: Convert an Object to a CSV string
        Given I have an Object
        When I convert the Object to a CSV string
        Then I should get a CSV string