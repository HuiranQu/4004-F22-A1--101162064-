Feature: Multi_players tests
  Scenario: Row132_Test
    Given player1 rolls 5 5 5 5 5 5 5 6 with "Captain" FC get 4000 points
    When player2 rolls 5 5 5 5 5 5 5 6 with "1Skull" FC get 2000 points
    And player3 rolls 6 6 6 3 3 3 3 3 with "Coin" FC get 0 point
    Then game stops and "Player1" is the winner