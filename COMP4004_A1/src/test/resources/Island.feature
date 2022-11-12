Feature: Player1 go to island of skull.
  Scenario: Row109_Test
    Given player 1 have 2Skulls FC and rolled 6 6 3 3 3 4 4 4 in first round
    Then player1 reroll dice at "6","7","8"
    When dice with the reoll outcome is 6 6 3 3 3 6 6 5
    Then player1 reroll dice at "3","4","5","8" twice
    When dice with second reoll outcome is 6 6 6 6 6 6 6 5
    Then player1 get 0 score, and player2 and player 3 get 0 since they have no score.