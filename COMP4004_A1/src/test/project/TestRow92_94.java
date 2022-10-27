package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TestRow92_94 {
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
    public void Row92_94(){
        Card = "Chest";
        die[0] = 6;
        die[1] = 6;
        die[2] = 4;
        die[3] = 4;
        die[4] = 4;
        die[5] = 1;
        die[6] = 1;
        die[7] = 1;
        int[] store = {1,1,1,0,0,0,0,0};
        die[5] = 0;
        die[6] = 0;
        die[7] = 0;
        String[] reroll = {"5","4","3"};
        int[] re =game.reRollKeep(die,reroll);
        re[4] = 1;
        re[3] = 2;
        re[2] = 2;
        store[3] = 1;
        String[] reroll2 = {"4","3"};
        int[] re2 =game.reRollKeep(re,reroll2);
        re[2] = 6;
        re[3] = 1;
        pl.scoreRound(0,store,Card);
        int score = pl.getScore();
        Assertions.assertEquals(600,score);
    }
}