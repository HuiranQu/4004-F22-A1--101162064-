Feature: All the player plays with exactly two reroll
  Scenario Outline: Roroll twice
    Given Player1 roll dice, with <Card> got <roll>:
    Then Player1 reroll dice at <Reroll_index1> once
    When dice with first reoll outcome is <DiceRoll1>
    Then I reroll dice at <Reroll_index2> twice
    When dice with second reoll outcome is <DiceRoll2>
    Then socre points with double reroll is <Score>
    Examples:
      |Row|roll           |Reroll_index1|DiceRoll1      | Reroll_index2|DiceRoll2      | Card    |Score|
      |49 |6 4 4 4 4 5 5 5|"6","7","8"  |6 4 4 4 4 6 3 3|"7","8"       |6 4 4 4 4 6 6 3|"Coin"   |0    |
      |60 |6 3 3 4 4 5 5 5|"2","3"      |6 6 5 4 4 5 5 5|"4","5"       |6 6 5 5 3 5 5 5|"Coin"   |600  |