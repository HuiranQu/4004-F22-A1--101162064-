Feature: All the player plays with exactly one reroll
  Scenario Outline: Roroll once
    Given I roll a dice, with <Card> got <roll>:
    Then I reroll dice at <Reroll_index> once
    When dice with one reoll outcome is <DiceRoll>
    Then socre points with one reroll is <Score>
    Examples:
      |Row|roll           |Reroll_index|DiceRoll       | Card    |Score|
      |46 |6 4 4 4 4 5 5 5|"6","7","8"    |6 4 4 4 4 6 6 5|"Coin"            |0    |
      |47 |6 6 4 4 4 4 5 5|"7","8"        |6 6 4 4 4 4 6 5|"Coin"            |0    |
      |53 |3 3 4 4 5 5 6 6|"3","4"        |3 3 3 5 5 5 6 6|"Coin"            |200  |
      |58 |6 1 1 4 4 5 5 5|"4","5"        |6 1 1 1 5 5 5 5|"Coin"            |600  |
      |59 |6 1 1 4 4 5 5 5|"4","5"        |6 1 1 1 5 5 5 5|"Captain"         |1200 |
      |70 |6 1 1 3 4 5 5 5|"6","7","8"    |6 1 1 3 4 1 3 4|"Coin"            |600  |
      |71 |6 1 1 3 4 5 5 5|"6","7","8"    |6 1 1 3 4 1 3 4|"Diamond"         |500  |
      |83 |3 3 5 5 4 4 1 1|"3","4"        |3 3 3 4 4 4 1 1|"Monkey&Parrot"   |1700 |
      |102|3 3 3 3 5 4 4 1|"6","7"        |3 3 3 3 5 5 1 1|"2Swords(300 pts)"|700  |
      |115|5 5 6 6 4 4 4 4|"5","6","7","8"|5 5 6 6 6 6 6 6|"3Swords(500 pts)"|0    |
      |119|3 3 3 3 5 6 4 4|"7","8"        |3 3 3 3 5 6 5 6|"2Swords(300 pts)"|500  |
      |122|4 4 4 4 5 5 6 6|"1","2","3","4"|6 6 5 5 5 5 6 6|"3Swords(500 pts)"|0    |



