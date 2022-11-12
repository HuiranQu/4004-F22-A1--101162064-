package StepsDefination;

import io.cucumber.java.en.Given;
import project.Game;
import project.Player;

import java.util.ArrayList;
import java.util.List;

public class WithoutReroll_Steps {
    Player pl = new Player("a");
    Game game = new Game();
    List<String> Fortune = new ArrayList<>(
            List.of("Chest","Chest","Chest","Chest","Sorceress","Sorceress","Sorceress","Sorceress","Captain","Captain"
                    ,"Captain","Captain","Monkey&Parrot","Monkey&Parrot","Monkey&Parrot","Monkey&Parrot","Diamond","Diamond","Diamond"
                    ,"Diamond","Coin","Coin","Coin","Coin","2Skulls","2Skulls","1Skull","1Skull","1Skull","2Swords(300pts)","2Swords(300pts)"
                    ,"3Swords(500 pts)","3Swords(500pts)","4Swords(1000 pts)","4Swords(1000 pts)"));
    String Card = game.getFortune();
    int[] die = game.rollDice();
    @Given("I roll a dice, with {string}")
    public void i_roll_a_dice_with(String string) {
        Card = string;
    }
}
