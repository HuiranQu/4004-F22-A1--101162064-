Feature: For player get Treasure Chest as FC.
  Scenario: Row90_Test
    Given Player1 roll dice, with "Chest" Card got 4 4 4 5 5 2 2 1 dice:
    Then Player1 put 2 2 1 in treasure Chest
    And Player1 reroll left dice at "4","5" once
    When dice with first left reoll outcome is 4 4 4 4 4 0 0 0
    Then Player1 put 4 4 4 4 4 in treasure Chest and take 2 2 1 from treasure chest
    And Player1 reroll left dice at "1","2","3" twice
    When dice with second left reoll outcome is 6 1 4 0 0 0 0 0
    Then socre points with double reroll and chest is 1100
