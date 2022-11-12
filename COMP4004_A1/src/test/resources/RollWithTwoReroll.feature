Feature: All the player plays with exactly two reroll
  Scenario Outline: Roroll twice
    Given Player1 roll dice, with <Card> got <roll>:
    Then Player1 reroll dice at <Reroll_index1> once
    When dice with one reoll outcome is <DiceRoll1>
    Then I reroll dice at <Reroll_index2> twice
    When dice with one reoll outcome is <DiceRoll2>
    Then socre points with double reroll is <Score>
    Examples:
      |Row|roll |Reroll_index1|DiceRoll1 | Reroll_index2|DiceRoll2| Card    |Score|