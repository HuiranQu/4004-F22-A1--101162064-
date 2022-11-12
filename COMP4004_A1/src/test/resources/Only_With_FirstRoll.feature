Feature: All the tests plays with only one roll, no any reroll
  Scenario Outline: Roll without any reroll
    Given I roll a dice, with <Card>
    When dice outcome is <DiceRoll>
    Then socre points is <Score>
    Examples:
      |Row|DiceRoll       | Card              |Score|
      |45 |6 6 6 5 5 5 5 5|"Coin"             |0    |
      |52 |3 3 4 4 2 2 1 1|"Captain"          |800  |
      |54 |3 3 3 5 5 5 6 6|"Coin"             |200  |
      |55 |2 2 2 6 6 3 5 4|"Coin"             |500  |
      |56 |1 1 1 1 6 6 5 5|"Diamond"          |700  |
      |57 |5 5 5 4 4 4 4 6|"Coin"             |400  |
      |62 |3 3 3 3 3 3 6 6|"Coin"             |1100 |
      |63 |4 4 4 4 4 4 4 6|"Coin"             |2100 |
      |64 |1 1 1 1 1 1 1 1|"Coin"             |5400 |
      |65 |1 1 1 1 1 1 1 1|"Diamond"          |5400 |
      |66 |5 5 5 5 5 5 5 5|"Captain"          |9000 |
      |72 |4 4 4 4 1 1 6 6|"Coin"             |600  |
      |82 |3 3 3 4 4 4 6 1|"Monkey&Parrot"    |1100 |
      |84 |6 6 6 3 3 3 4 4|"Monkey&Parrot"    |0    |
      |97 |3 3 3 5 5 5 1 4|"Coin"             |300  |
      |98 |3 3 3 5 5 5 2 2|"Captain"          |1600 |
      |99 |3 3 3 5 5 5 5 1|"Coin"             |1000 |
      |103|3 3 4 1 1 2 2 2|"Monkey&Parrot"    |1100 |
      |106|6 5 5 5 5 5 5 5|"2Skulls"          |0    |
      |107|6 6 5 5 5 5 5 5|"1Skull"           |0    |
      |114|3 3 3 3 6 6 6 5|"2Swords(300 pts)" |0    |
      |116|3 3 5 5 5 6 6 6|"4Swords(1000 pts)"|0    |
      |117|3 3 3 5 5 1 4 4|"2Swords(300 pts)" |500  |
      |120|3 3 3 5 5 5 5 6|"3Swords(500 pts)" |800  |
      |123|3 3 3 5 5 5 5 6|"4Swords(1000 pts)"|1300 |
    #1 = coin, 2 = Diamond, 3 = Monkey, 4 = Parrot, 5 = Sword, 6 = Skull