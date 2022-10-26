package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestRow73 {
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
    public void Row73(){
        Card = "Sorceress";
        die[0] = 2;
        die[1] = 2;
        die[2] = 5;
        die[3] = 3;
        die[4] = 1;
        die[5] = 4;
        die[6] = 4;
        die[7] = 4;
        String[] reroll = {"6","7","8"};
        int[] re =game.reRollKeep(die,reroll);
        re[5] = 6;
        re[6] = 3;
        re[7] = 3;
        String[] reroll2 = {"6"};
        int[] re2 =game.reRollKeep(re,reroll2);
        re2[5] = 3;

        pl.scoreRound(0,re2,Card);
        int score = pl.getScore();
        Assertions.assertEquals(500,score);
    }
}