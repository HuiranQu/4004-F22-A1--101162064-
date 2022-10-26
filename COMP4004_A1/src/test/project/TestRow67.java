package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestRow67 {
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
    public void Row67(){
        Card = "Coin";
        die[0] = 3;
        die[1] = 3;
        die[2] = 3;
        die[3] = 3;
        die[4] = 3;
        die[5] = 3;
        die[6] = 5;
        die[7] = 5;

        String[] reroll = {"7","8"};
        int[] re =game.reRollKeep(die,reroll);
        re[6] = 3;
        re[7] = 3;

        pl.scoreRound(0,re,Card);
        int score = pl.getScore();
        Assertions.assertEquals(4600,score);
    }

}