package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestRow103 {
    Player pl = new Player("a");
    Game game = new Game();
    List<String> Fortune = new ArrayList<>(
            List.of("Chest","Chest","Chest","Chest","Sorceress","Sorceress","Sorceress","Sorceress","Captain","Captain"
                    ,"Captain","Captain","Monkey&Parrot","Monkey&Parrot","Monkey&Parrot","Monkey&Parrot","Diamond","Diamond","Diamond"
                    ,"Diamond","Coin","Coin","Coin","Coin","2Skulls","2Skulls","1Skull","1Skull","1Skull","2Swords(300 pts)","2Swords(300 pts)"
                    ,"3Swords(500 pts)","3Swords(500 pts)","4Swords(1000 pts)","4Swords(1000 pts)"));
    String Card = game.getFortune();
    int[] die = game.rollDice();

    @Test
    public void Row103(){
        Card = "Monkey&Parrot";
        die[0] = 3;
        die[1] = 3;
        die[2] = 4;
        die[3] = 1;
        die[4] = 1;
        die[5] = 2;
        die[6] = 2;
        die[7] = 2;
        pl.scoreRound(0,die,Card);
        int score = pl.getScore()+100;
        Assertions.assertEquals(1200,score);
    }
}