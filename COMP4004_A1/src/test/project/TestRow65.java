package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestRow65 {
    Player pl = new Player("a");
    Game game = new Game();
    List<String> Fortune = new ArrayList<>(
            List.of("Chest","Chest","Chest","Chest","Sorceress","Sorceress","Sorceress","Sorceress","Captain","Captain"
                    ,"Captain","Captain","Monkey&Parrot","Monkey&Parrot","Monkey&Parrot","Monkey&Parrot","Diamond","Diamond","Diamond"
                    ,"Diamond","Coin","Coin","Coin","Coin","2Skulls","2Skulls","1Skull","1Skull","1Skull","2Swords(300pts)","2Swords(300pts)"
                    ,"3Swords(500 pts)","3Swords(500pts)","4Swords(1000 pts)","4Swords(1000 pts)"));
    String Card = game.getFortune();
    int[] die = game.rollDice();

    @Test
    public void Row64 (){
        Card = "Diamond";
        die[0] = 1;
        die[1] = 1;
        die[2] = 1;
        die[3] = 1;
        die[4] = 1;
        die[5] = 1;
        die[6] = 1;
        die[7] = 1;
        pl.scoreRound(0,die,Card);
        int score = pl.getScore();
        Assertions.assertEquals(5400,score);
    }
}