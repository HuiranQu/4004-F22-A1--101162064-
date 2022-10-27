package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TestRow78 {
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
    public void Row78(){
        Card = "Sorceress";
        die[0] = 6;
        die[1] = 6;
        die[2] = 6;
        die[3] = 3;
        die[4] = 3;
        die[5] = 3;
        die[6] = 5;
        die[7] = 5;
        String[] reroll = {"1"};
        int[] re =game.reRollKeep(die,reroll);
        re[0] = 3;
        String[] reroll2 = {"7","8"};
        int[] re2 =game.reRollKeep(re,reroll2);
        re2[6] = 3;
        re2[7] = 3;

        pl.scoreRound(0,re2,Card);
        int score = pl.getScore();
        Assertions.assertEquals(1000,score);
    }
}