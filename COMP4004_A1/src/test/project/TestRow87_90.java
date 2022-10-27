package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestRow87_90 {
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
    public void Row87_90(){
        Card = "Monkey&Parrot";
        die[0] = 4;
        die[1] = 4;
        die[2] = 4;
        die[3] = 5;
        die[4] = 5;
        die[5] = 2;
        die[6] = 2;
        die[7] = 1;
        int[] store = {2,2,1,0,0,0,0,0};
        die[5] = 0;
        die[6] = 0;
        die[7] = 0;
        String[] reroll = {"5","4"};
        int[] re =game.reRollKeep(die,reroll);
        re[4] = 4;
        re[3] = 4;
        store[0] = 4;
        store[1] = 4;
        store[2] = 4;
        store[3] = 4;
        store[4] = 4;
        die[0] = 2;
        die[1] = 2;
        die[2] = 1;
        String[] reroll2 = {"1","2","3"};
        int[] re2 =game.reRollKeep(re,reroll2);
        die[0] = 6;
        die[1] = 1;
        die[2] = 4;
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
        Assertions.assertEquals(1100,score);
    }
}