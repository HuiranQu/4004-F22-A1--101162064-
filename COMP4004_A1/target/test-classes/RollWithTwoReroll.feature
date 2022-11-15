Feature: All the player plays with exactly two reroll
  Scenario Outline: Row<Row>_Test
    Given Player1 roll dice, with <Card> got <roll>:
    Then Player1 reroll dice at <Reroll_index1> once
    When dice with first reoll outcome is <DiceRoll1>
    Then I reroll dice at <Reroll_index2> twice
    When dice with second reoll outcome is <DiceRoll2>
    Then socre points with double reroll is <Score>
    Examples:
      |Row|roll           |Reroll_index1|DiceRoll1      | Reroll_index2|DiceRoll2      | Card              |Score|
      |49 |6 4 4 4 4 5 5 5|"6","7","8"  |6 4 4 4 4 6 3 3|"7","8"       |6 4 4 4 4 6 6 3|"Coin"             |0    |
      |50 |6 4 4 5 5 5 1 1|"2","3"      |6 1 1 5 5 5 1 1|"4","5","6"   |6 1 1 1 1 1 1 1|"Coin"             |4800 |
      |60 |6 3 3 4 4 5 5 5|"2","3"      |6 6 5 4 4 5 5 5|"4","5"       |6 6 5 5 3 5 5 5|"Coin"             |600  |
      |77 |2 2 5 3 1 4 4 4|"6","7","8"  |2 2 5 3 1 6 3 3|"6"           |2 2 5 3 1 3 3 3|"Sorceress"        |500  |
      |78 |6 6 6 4 4 4 5 5|"1"          |4 6 6 4 4 4 5 5|"7","8"       |4 6 6 4 4 4 4 4|"Sorceress"        |1000 |
      |79 |6 4 4 4 4 3 3 3|"6","7","8"  |6 4 4 4 4 6 4 4|"6"           |6 4 4 4 4 4 4 4|"Sorceress"        |2000 |
      |126|3 3 3 5 6 2 4 4|"7","8"      |3 3 3 5 6 2 5 5|"1","2","3"   |5 4 4 5 6 2 5 5|"4Swords(1000 pts)"|1300 |
        #1 = coin, 2 = Diamond, 3 = Monkey, 4 = Parrot, 5 = Sword, 6 = Skull
