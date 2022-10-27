package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestRow115 {
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
    public void Row115(){
        Card = "3Swords(500 pts)";
        pl.setScoreSheet(0,600);
        die[0] = 5;
        die[1] = 5;
        die[2] = 6;
        die[3] = 6;
        die[4] = 4;
        die[5] = 4;
        die[6] = 4;
        die[7] = 4;

        String[] reroll = {"8","6","7","5"};
        int[] re =game.reRollKeep(die,reroll);
        re[4] = 6;
        re[5] = 6;
        re[6] = 6;
        re[7] = 6;
        pl.scoreRound(1,re,Card);
        int score = pl.getScore();
        Assertions.assertEquals(100,score);
    }
}