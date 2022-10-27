package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestRow124_126 {
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
    public void Row124_126(){
        Card = "4Swords(1000 pts)";
        die[0] = 3;
        die[1] = 3;
        die[2] = 3;
        die[3] = 5;
        die[4] = 6;
        die[5] = 2;
        die[6] = 4;
        die[7] = 4;
        String[] reroll = {"7","8"};
        int[] re =game.reRollKeep(die,reroll);
        re[6] = 5;
        re[7] = 5;
        String[] reroll2 = {"1","2","3"};
        int[] re2 =game.reRollKeep(re,reroll2);
        re2[0] = 5;
        re2[1] = 4;
        re2[2] = 4;
        pl.scoreRound(1,re2,Card);
        int score = pl.getScore();
        Assertions.assertEquals(1300,score);
    }
}