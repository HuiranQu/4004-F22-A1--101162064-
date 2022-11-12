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
      |55 |2 2 2 6 6 3 5 4|"Coin"   |500  |
      |56 |1 1 1 1 6 6 5 5 |"Diamond"|700  |
      |57 |5 5 5 4 4 4 4 6 |"Coin"  |400   |
      |62 |3 3 3 3 3 3 6 6 |"Coin"  |1100  |
      |63 |4 4 4 4 4 4 4 6 |"Coin"  |2100  |
      |64 |1 1 1 1 1 1 1 1 |"Coin"  |5400  |
      |65 |1 1 1 1 1 1 1 1 |"Diamond"|5400 |
      |66 |5 5 5 5 5 5 5 5 |"Captain"|9000 |