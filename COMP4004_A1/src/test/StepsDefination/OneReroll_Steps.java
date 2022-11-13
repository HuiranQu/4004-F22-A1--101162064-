package StepsDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import project.Game;
import project.Player;

import java.util.ArrayList;
import java.util.List;

public class OneReroll_Steps {
    Player pl = new Player("a");
    Game game = new Game();
    List<String> Fortune = new ArrayList<>(
            List.of("Chest","Chest","Chest","Chest","Sorceress","Sorceress","Sorceress","Sorceress","Captain","Captain"
                    ,"Captain","Captain","Monkey&Parrot","Monkey&Parrot","Monkey&Parrot","Monkey&Parrot","Diamond","Diamond","Diamond"
                    ,"Diamond","Coin","Coin","Coin","Coin","2Skulls","2Skulls","1Skull","1Skull","1Skull","2Swords(300pts)","2Swords(300pts)"
                    ,"3Swords(500 pts)","3Swords(500pts)","4Swords(1000 pts)","4Swords(1000 pts)"));
    String Card = game.getFortune();
    int[] die = game.rollDice();
    int[] re = new int[9];
    String[] reroll = new String[9];
    @Given("I roll a dice, with {string} got {int} {int} {int} {int} {int} {int} {int} {int}:")
    public void i_roll_a_dice_with_got(String ID, Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6, Integer int7, Integer int8) {
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

    @Then("I reroll dice at {string},{string},{string},{string} once")
    public void i_reroll_dice_at_once(String string, String string2, String string3, String string4) {
        reroll[0] = string;
        reroll[1] = string2;
        reroll[2] = string3;
        reroll[3] = string4;
    }
    @Then("I reroll dice at {string},{string},{string} once")
    public void i_reroll_dice_at_once(String string, String string2, String string3) {
        reroll[0] = string;
        reroll[1] = string2;
        reroll[2] = string3;
    }
    @Then("I reroll dice at {string},{string} once")
    public void i_reroll_dice_at_once(String string, String string2) {
        reroll[0] = string;
        reroll[1] = string2;
        re =game.reRollKeep(die,reroll);
    }
    @When("dice with one reoll outcome is {int} {int} {int} {int} {int} {int} {int} {int}")
    public void dice_with_one_reoll_outcome_is(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6, Integer int7, Integer int8) {
        re[0] = int1;
        re[1] = int2;
        re[2] = int3;
        re[3] = int4;
        re[4] = int5;
        re[5] = int6;
        re[6] = int7;
        re[7] = int8;

    }


    @Then("socre points with one reroll is {int}")
    public void socre_points_is(Integer int1) {
        pl.scoreRound(0,re,Card);
        int score = pl.getScore();
        Assertions.assertEquals(int1,score);
    }
}
