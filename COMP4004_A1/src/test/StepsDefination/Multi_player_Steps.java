package StepsDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import project.Game;
import project.Player;

import java.util.ArrayList;
import java.util.List;

public class Multi_player_Steps {
    Player[] players = new Player[3];
    Player pl1 = new Player("Player1");
    Player pl2 = new Player("Player2");
    Player pl3 = new Player("Player3");
    Game game = new Game();
    List<String> Fortune = new ArrayList<>(
            List.of("Chest","Chest","Chest","Chest","Sorceress","Sorceress","Sorceress","Sorceress","Captain","Captain"
                    ,"Captain","Captain","Monkey&Parrot","Monkey&Parrot","Monkey&Parrot","Monkey&Parrot","Diamond","Diamond","Diamond"
                    ,"Diamond","Coin","Coin","Coin","Coin","2Skulls","2Skulls","1Skull","1Skull","1Skull","2Swords(300 pts)","2Swords(300 pts)"
                    ,"3Swords(500 pts)","3Swords(500 pts)","4Swords(1000 pts)","4Swords(1000 pts)"));
    String Card1 = game.getFortune();
    String Card2 = game.getFortune();
    String Card3 = game.getFortune();
    int[] die1 = game.rollDice();
    int[] die2 = game.rollDice();
    int[] die3 = game.rollDice();
    String[] reroll2 = new String[9];
    int[] player2_reroll1 = new int[9];
    int[] player2_reroll2 = new int[9];

    @Given("player1 rolls {int} {int} {int} {int} {int} {int} {int} {int} with {string} FC get {int} points")
    public void player1_rolls_with_fc_get_points(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6, Integer int7, Integer int8, String string, Integer int9) {
        players[0] = pl1;
        players[1] = pl2;
        players[2] = pl3;
        Card1 = string;
        die1[0] = int1;
        die1[1] = int2;
        die1[2] = int3;
        die1[3] = int4;
        die1[4] = int5;
        die1[5] = int6;
        die1[6] = int7;
        die1[7] = int8;
        pl1.scoreRound(0,die1,Card1);
        Assertions.assertEquals(int9,pl1.getScore());
    }
    @When("player2 rolls {int} {int} {int} {int} {int} {int} {int} {int} with {string} FC get {int} points")
    public void player2_rolls_with_fc_get_points(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6, Integer int7, Integer int8, String string, Integer int9) {
        Card2 = string;
        die2[0] = int1;
        die2[1] = int2;
        die2[2] = int3;
        die2[3] = int4;
        die2[4] = int5;
        die2[5] = int6;
        die2[6] = int7;
        die2[7] = int8;
        pl2.scoreRound(0,die2,Card2);
        Assertions.assertEquals(int9,pl2.getScore());
    }
    @When("player3 rolls {int} {int} {int} {int} {int} {int} {int} {int} with {string} FC get {int} point")
    public void player3_rolls_with_fc_get_point(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6, Integer int7, Integer int8, String string, Integer int9) {
        Card3 = string;
        die3[0] = int1;
        die3[1] = int2;
        die3[2] = int3;
        die3[3] = int4;
        die3[4] = int5;
        die3[5] = int6;
        die3[6] = int7;
        die3[7] = int8;
        pl3.scoreRound(0,die3,Card3);
        Assertions.assertEquals(int9,pl3.getScore());
    }
    @When("player3 rolls {int} {int} {int} {int} {int} {int} {int} {int} with {string} FC get {int} points")
    public void player3_rolls_with_fc_get_points(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6, Integer int7, Integer int8, String string, Integer int9) {
        Card3 = string;
        die3[0] = int1;
        die3[1] = int2;
        die3[2] = int3;
        die3[3] = int4;
        die3[4] = int5;
        die3[5] = int6;
        die3[6] = int7;
        die3[7] = int8;
        pl3.island(players,die3,Card3);
        Assertions.assertEquals(int9,pl3.getScore());
    }
    @Then("player1 rolls {int} {int} {int} {int} {int} {int} {int} {int} with {string} FC reach {int} points")
    public void player1_rolls_with_fc_get_points_and_reach_points(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6, Integer int7, Integer int8, String string, Integer int9) {
        Card1 = string;
        die1[0] = int1;
        die1[1] = int2;
        die1[2] = int3;
        die1[3] = int4;
        die1[4] = int5;
        die1[5] = int6;
        die1[6] = int7;
        die1[7] = int8;
        pl1.scoreRound(1,die1,Card1);
        Assertions.assertEquals(int9,pl1.getScore()+200);
    }
    @Then("player2 rolls {int} {int} {int} {int} {int} {int} {int} {int} with {string} FC and player3 rolls {int} {int} {int} {int} {int} {int} {int} {int} with {string} FC, both score {int} point")
    public void player2_rolls_with_fc_and_player3_rolls_with_fc_both_score_point(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6, Integer int7, Integer int8, String string, Integer int9, Integer int10, Integer int11, Integer int12, Integer int13, Integer int14, Integer int15, Integer int16, String string2, Integer int17) {
        Card2 = string;
        die2[0] = int1;
        die2[1] = int2;
        die2[2] = int3;
        die2[3] = int4;
        die2[4] = int5;
        die2[5] = int6;
        die2[6] = int7;
        die2[7] = int8;
        pl2.scoreRound(1,die2,Card2);
        Assertions.assertEquals(int17,pl2.getScore());
        Card3 = string2;
        die3[0] = int9;
        die3[1] = int10;
        die3[2] = int11;
        die3[3] = int12;
        die3[4] = int13;
        die3[5] = int14;
        die3[6] = int15;
        die3[7] = int16;
        pl3.scoreRound(0,die3,Card3);
        Assertions.assertEquals(int17,pl3.getScore());
    }
    @When("player2 rolls {int} {int} {int} {int} {int} {int} {int} {int} with {string}")
    public void player2_rolls_with(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6, Integer int7, Integer int8, String string) {
        Card2 = string;
        die2[0] = int1;
        die2[1] = int2;
        die2[2] = int3;
        die2[3] = int4;
        die2[4] = int5;
        die2[5] = int6;
        die2[6] = int7;
        die2[7] = int8;
    }
    @When("reroll dice at {string} get a {int}")
    public void reroll_dice_at_get_a(String string, Integer int1) {
        reroll2[0] = string;
        player2_reroll1 = game.reRollKeep(die2,reroll2);
        player2_reroll1[0] = int1;
    }
    @When("reroll dice at {string} and {string} to get {int} {int}")
    public void reroll_dice_at_and_to_get(String string, String string2, Integer int1, Integer int2) {
        reroll2[0] = string;
        reroll2[1] = string2;
        player2_reroll2 = game.reRollKeep(player2_reroll1,reroll2);
        player2_reroll2[0] = int1;
        player2_reroll2[7] = int2;
        pl2.island(players,player2_reroll2,Card2);
    }
    @Then("player1 has {int} points and player2 and player3 have {int} point.")
    public void player1_has_points_and_player2_and_player3_have_point(Integer int1, Integer int2) {
        Assertions.assertEquals(int1,pl1.getScore());
        Assertions.assertEquals(int2,pl2.getScore());
        Assertions.assertEquals(int2,pl3.getScore());
    }
    @Then("game stops and {string} is the winner")
    public void game_stops_and_is_the_winner(String string) {
        Assertions.assertEquals(string,game.getWinner(players).getName());
        System.out.println("The winner is: "+game.getWinner(players).getName());
    }
}
