package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestRow71 {
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
    public void Row71(){
        Card = "Diamond";
        die[0] = 6;
        die[1] = 1;
        die[2] = 1;
        die[3] = 3;
        die[4] = 4;
        die[5] = 5;
        die[6] = 5;
        die[7] = 5;

        String[] reroll = {"6","7","8"};
        int[] re =game.reRollKeep(die,reroll);
        re[5] = 1;
        re[6] = 3;
        re[7] =4;
        pl.scoreRound(0,re,Card);
        int score = pl.getScore();
        Assertions.assertEquals(500,score);
    }
}