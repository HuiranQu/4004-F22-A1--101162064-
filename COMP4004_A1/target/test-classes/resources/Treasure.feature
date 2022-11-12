Feature: For player get Treasure Chest as FC.
  Scenario Outline: play with Treasure Chest
    Given Player1 roll dice, with "Treasure Chest" Card got <roll>:
    Then Player1 put <in1> in treasure Chest
    And Player1 reroll left dice at <Reroll_index1> once
    When dice with first left reoll outcome is <DiceRoll1>
    Then Player1 put <in2> in treasure Chest and take <out> from treasure chest
    And Player1 reroll left dice at <Reroll_index2> twice
    When dice with second left reoll outcome is <DiceRoll2>
    Then socre points with double reroll and chest is <Score>
    Examples:
      |Row|roll   |in1|Reroll_index1|DiceRoll1|in2|out | Reroll_index2|DiceRoll2 |Score|
      |90 |4 4 4 5 5 2 2 1|6 7 8|"4","5"|4 4 4 4 4 0 0 0|1 2 3 4 5|1 2 3|"1","2","3"|6 1 4 0 0 0 0 0|1100|