Feature: Multi_players tests
  Scenario: Row132_Test
    Given player1 rolls 5 5 5 5 5 5 5 6 with "Captain" FC get 4000 points
    When player2 rolls 5 5 5 5 5 5 5 6 with "1Skull" FC get 2000 points
    And player3 rolls 6 6 6 3 3 3 3 3 with "Coin" FC get 0 point
    Then game stops and "Player1" is the winner

    Scenario: Row140_Test
      Given player1 rolls 5 5 5 5 5 5 5 6 with "Captain" FC get 4000 points
      When player2 rolls 6 6 6 3 3 3 3 3 with "Coin" FC get 0 points
      And player3 rolls 6 6 6 6 6 6 4 4 with "Captain" FC get 0 points
      Then player1 rolls 3 3 3 3 4 4 4 4 with "Coin" FC reach 3800 points
      And player2 rolls 6 6 6 3 3 3 3 3 with "Captain" FC and player3 rolls 6 6 3 3 3 3 3 3 with "1Skull" FC, both score 0 point
      Then game stops and "Player1" is the winner

      Scenario: Row145_Test
        Given player1 rolls 6 6 6 3 3 3 3 3 with "Captain" FC get 0 points
        When player2 rolls 5 5 5 5 5 5 5 6 with "Captain" FC get 4000 points
        And player3 rolls 6 5 5 5 5 5 5 5 with "2Skulls" FC get 0 point
        And player1 rolls 5 5 5 5 5 5 5 5 with "Captain" FC get 9000 points
        Then game stops and "Player1" is the winner