package StepsDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import project.Game;
import project.Player;

import java.util.ArrayList;
import java.util.List;

public class Island {
    Player[] players = new Player[3];
    Player pl = new Player("A");
    Player pl1 = new Player("B");
    Player pl2 = new Player("C");
    Game game = new Game();
    List<String> Fortune = new ArrayList<>(
            List.of("Chest","Chest","Chest","Chest","Sorceress","Sorceress","Sorceress","Sorceress","Captain","Captain"
                    ,"Captain","Captain","Monkey&Parrot","Monkey&Parrot","Monkey&Parrot","Monkey&Parrot","Diamond","Diamond","Diamond"
                    ,"Diamond","Coin","Coin","Coin","Coin","2Skulls","2Skulls","1Skull","1Skull","1Skull","2Swords(300 pts)","2Swords(300 pts)"
                    ,"3Swords(500 pts)","3Swords(500 pts)","4Swords(1000 pts)","4Swords(1000 pts)"));
    String Card = game.getFortune();
    int[] die = game.rollDice();
    int[] re1 = new int[9];
    String[] reroll1 = new String[9];
    int[] re2 = new int[9];
    String[] reroll2 = new String[9];

    @Given("player1 have {string} FC and rolled {int} {int} {int} {int} {int} {int} {int} {int} in first round")
    public void player1_have_fc_and_rolled_in_first_round(String string, Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6, Integer int7, Integer int8) {
        players[0] = pl;
        players[1] = pl1;
        players[2] = pl2;
        Card = string;
        die[0] = int1;
        die[1] = int2;
        die[2] = int3;
        die[3] = int4;
        die[4] = int5;
        die[5] = int6;
        die[6] = int7;
        die[7] = int8;
    }
    @Then("player1 reroll dice at {string},{string},{string}")
    public void player1_reroll_dice_at(String string, String string2, String string3) {
        reroll1[0] = string;
        reroll1[1] = string2;
        reroll1[2] = string3;
        re1 =game.reRollKeep(die,reroll1);
    }
    @Then("player1 reroll dice at {string},{string},{string},{string},{string}")
    public void player1_reroll_dice_at(String string, String string2, String string3, String string4, String string5) {
        reroll1[0] = string;
        reroll1[1] = string2;
        reroll1[2] = string3;
        reroll1[3] = string4;
        reroll1[4] = string5;
        re1 =game.reRollKeep(die,reroll1);
    }
    @When("dice with the reoll outcome is {int} {int} {int} {int} {int} {int} {int} {int}")
    public void dice_with_the_reoll_outcome_is(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6, Integer int7, Integer int8) {
        re1[0] = int1;
        re1[1] = int2;
        re1[2] = int3;
        re1[3] = int4;
        re1[4] = int5;
        re1[5] = int6;
        re1[6] = int7;
        re1[7] = int8;
    }
    @Then("player1 reroll dice at {string},{string},{string},{string} twice")
    public void player1_reroll_dice_at_twice(String string, String string2, String string3, String string4) {
        reroll2[0] = string;
        reroll2[1] = string2;
        reroll2[2] = string3;
        reroll2[3] = string4;
        re2 =game.reRollKeep(re1,reroll2);
    }
    @When("dice with second rerooll outcome is {int} {int} {int} {int} {int} {int} {int} {int}")
    public void dice_with_second_rerooll_outcome_is(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6, Integer int7, Integer int8) {
        re2[0] = int1;
        re2[1] = int2;
        re2[2] = int3;
        re2[3] = int4;
        re2[4] = int5;
        re2[5] = int6;
        re2[6] = int7;
        re2[7] = int8;
    }
    @Then("player1 get {int} score, and player2 and player3 get {int} since they have no score.")
    public void player1_get_score_and_player2_and_player_get_since_they_have_no_score(Integer int1, Integer int2) {
        pl.island(players,re2,Card);
        Assertions.assertEquals(int1,pl.getScore());
        Assertions.assertEquals(int2,pl1.getScore());
        Assertions.assertEquals(int2,pl2.getScore());
    }
    @Then("Player1 get {int} score, and player2 and player3 get {int} since they have no score.")
    public void player1_get_score_and_player2_and_player3_get_since_they_have_no_score(Integer int1, Integer int2) {
        pl.island(players,re1,Card);
        Assertions.assertEquals(int1,pl.getScore());
        Assertions.assertEquals(int2,pl1.getScore());
        Assertions.assertEquals(int2,pl2.getScore());
    }
}
