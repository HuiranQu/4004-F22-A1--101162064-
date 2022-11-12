Feature: All the tests plays with only one roll, no any reroll
  Scenario Outline: Roll without any reroll
    Given I roll a dice, with <Card>
    When dice outcome is <DiceRoll>
    Then socre points is <Score>
    Examples:
      |Row|DiceRoll       | Card    |Score|
      |45 |6 6 6 5 5 5 5 5|"Coin"   |0    |
      |52 |3 3 4 4 2 2 1 1|"Captain"|800  |
      |54 |3 3 3 5 5 5 6 6|"Coin"   |200  |