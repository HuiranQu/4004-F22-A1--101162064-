Feature: All the player plays with exactly one reroll
  Scenario Outline: Roroll once
    Given I roll a dice, with <Card> got <roll>:
    Then I reroll dice at <Reroll_index> once
    When dice with one reoll outcome is <DiceRoll>
    Then socre points with one reroll is <Score>
    Examples:
      |Row|roll           |Reroll_index|DiceRoll       | Card |Score|
      |46 |6 4 4 4 4 5 5 5|"6","7","8" |6 4 4 4 4 6 6 5|"Coin"| 0   |
      |47 |6 6 4 4 4 4 5 5|"7","8"     |6 6 4 4 4 4 6 5|"Coin"| 0   |
