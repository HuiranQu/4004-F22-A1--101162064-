Feature: All the tests plays with only one roll, no any reroll
  Scenario Outline: Roll without any reroll
    Given I roll a dice, with <Card>
    When dice with one reoll outcome is <DiceRoll>
    Then socre points with one reroll is <Score>
    Examples:
      |Row|DiceRoll       | Card    |Score|
      |45 |6 6 6 5 5 5 5 5|"Coin"   |0    |