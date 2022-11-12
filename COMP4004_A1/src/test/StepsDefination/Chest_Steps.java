package StepsDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import project.Game;
import project.Player;

import java.util.ArrayList;
import java.util.List;

public class Chest_Steps {
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
    int[] store = new int[9];
    @Given("Player1 roll dice, with {string} Card got {int} {int} {int} {int} {int} {int} {int} {int} dice:")
    public void player1_roll_dice_with_card_got_dice(String string, Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6, Integer int7, Integer int8) {
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
    @Then("Player1 put {int} {int} {int} in treasure Chest")
    public void player1_put_in_treasure_chest(Integer int1, Integer int2, Integer int3) {
        store[0] = int1;
        store[1] = int2;
        store[2] = int3;
        die[5] = 0;
        die[6] = 0;
        die[7] = 0;
    }
    @Then("Player1 reroll left dice at {string},{string} once")
    public void player1_reroll_left_dice_at_once(String string, String string2) {
        reroll1[0] = string;
        reroll1[1] = string2;
    }
    @When("dice with first left reoll outcome is {int} {int} {int} {int} {int} {int} {int} {int}")
    public void dice_with_first_left_reoll_outcome_is(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6, Integer int7, Integer int8) {
        re1[0] = int1;
        re1[1] = int2;
        re1[2] = int3;
        re1[3] = int4;
        re1[4] = int5;
        re1[5] = int6;
        re1[6] = int7;
        re1[7] = int8;
    }
    @Then("Player1 put {int} {int} {int} {int} {int} in treasure Chest and take {int} {int} {int} from treasure chest")
    public void player1_put_in_treasure_chest_and_take_from_treasure_chest(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6, Integer int7, Integer int8) {
        store[0] = int1;
        store[1] = int2;
        store[2] = int3;
        store[3] = int4;
        store[4] = int5;
        die[0] = int6;
        die[1] = int7;
        die[2] = int8;
    }
    @Then("Player1 reroll left dice at {string},{string},{string} twice")
    public void player1_reroll_left_dice_at_twice(String string, String string2, String string3) {
        reroll2[0] = string;
        reroll2[1] = string2;
        reroll2[2] = string3;
    }
    @When("dice with second left reoll outcome is {int} {int} {int} {int} {int} {int} {int} {int}")
    public void dice_with_second_left_reoll_outcome_is(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6, Integer int7, Integer int8) {
        die[0] = int1;
        die[1] = int2;
        die[2] = int3;
        die[3] = int4;
        die[4] = int5;
        die[5] = int6;
        die[6] = int7;
        die[7] = int8;
    }
    @Then("socre points with double reroll and chest is {int}")
    public void socre_points_with_double_reroll_and_chest_is(Integer int1) {
        for (int i = 0; i < 8; i++) {                //same for loop in Play class, playRound function
            if (die[i] != 0) {
                for (int j = 0; j < 8; j++) {
                    if (store[j] == 0) {
                        store[j] = die[i];
                        break;
                    }
                }
            }
        }
        pl.scoreRound(0,store,Card);
        int score = pl.getScore();
        Assertions.assertEquals(int1,score);
    }
}
