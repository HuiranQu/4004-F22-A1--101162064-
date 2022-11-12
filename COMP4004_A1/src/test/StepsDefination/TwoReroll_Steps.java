package StepsDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import project.Game;
import project.Player;

import java.util.ArrayList;
import java.util.List;

public class TwoReroll_Steps {
    Player pl = new Player("a");
    Game game = new Game();
    List<String> Fortune = new ArrayList<>(
            List.of("Chest","Chest","Chest","Chest","Sorceress","Sorceress","Sorceress","Sorceress","Captain","Captain"
                    ,"Captain","Captain","Monkey&Parrot","Monkey&Parrot","Monkey&Parrot","Monkey&Parrot","Diamond","Diamond","Diamond"
                    ,"Diamond","Coin","Coin","Coin","Coin","2Skulls","2Skulls","1Skull","1Skull","1Skull","2Swords(300pts)","2Swords(300pts)"
                    ,"3Swords(500 pts)","3Swords(500pts)","4Swords(1000 pts)","4Swords(1000 pts)"));
    String Card = game.getFortune();
    int[] die = game.rollDice();
    int[] re1 = new int[9];
    String[] reroll1 = new String[9];
    int[] re2 = new int[9];
    String[] reroll2 = new String[9];

    @Given("Player1 roll dice, with {string} got {int} {int} {int} {int} {int} {int} {int} {int}:")
    public void player1_roll_dice_with_got(String ID, Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6, Integer int7, Integer int8) {
        Card = ID;
        die[0] = int1;
        die[1] = int2;
        die[2] = int3;
        die[3] = int4;
        die[4] = int5;
        die[5] = int6;
        die[6] = int7;
        die[7] = int8;
    }

    @Then("Player1 reroll dice at {string},{string},{string} once")
    public void player1_reroll_dice_at_once(String string, String string2, String string3) {
        reroll1[0] = string;
        reroll1[1] = string2;
        reroll1[2] = string3;
    }
    @Then("Player1 reroll dice at {string},{string} once")
    public void player1_reroll_dice_at_once(String string, String string2) {
        reroll1[0] = string;
        reroll1[1] = string2;
    }
    @When("dice with first reoll outcome is {int} {int} {int} {int} {int} {int} {int} {int}")
    public void dice_with_first_reoll_outcome_is(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6, Integer int7, Integer int8) {
        re1[0] = int1;
        re1[1] = int2;
        re1[2] = int3;
        re1[3] = int4;
        re1[4] = int5;
        re1[5] = int6;
        re1[6] = int7;
        re1[7] = int8;
    }

    @Then("I reroll dice at {string},{string} twice")
    public void i_reroll_dice_at_twice(String string, String string2) {
        reroll2[0] = string;
        reroll2[1] = string2;
    }
    @Then("I reroll dice at {string},{string},{string} twice")
    public void i_reroll_dice_at_twice(String string, String string2, String string3) {
        reroll2[0] = string;
        reroll2[1] = string2;
        reroll2[2] = string3;
    }
    @Then("I reroll dice at {string} twice")
    public void i_reroll_dice_at_twice(String string) {
        reroll2[0] = string;
    }
    @When("dice with second reoll outcome is {int} {int} {int} {int} {int} {int} {int} {int}")
    public void dice_with_second_reoll_outcome_is(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6, Integer int7, Integer int8) {
        re2[0] = int1;
        re2[1] = int2;
        re2[2] = int3;
        re2[3] = int4;
        re2[4] = int5;
        re2[5] = int6;
        re2[6] = int7;
        re2[7] = int8;
    }

    @Then("socre points with double reroll is {int}")
    public void socre_points_with_double_reroll_is(Integer int1) {
        pl.scoreRound(0,re2,Card);
        int score = pl.getScore();
        Assertions.assertEquals(int1,score);
    }
}
