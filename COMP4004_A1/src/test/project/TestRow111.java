package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestRow111 {
    Player[] players = new Player[3];
    Player pl = new Player("A");
    Player pl1 = new Player("B");
    Player pl2 = new Player("C");
    Game game = new Game();
    List<String> Fortune = new ArrayList<>(
            List.of("Chest","Chest","Chest","Chest","Sorceress","Sorceress","Sorceress","Sorceress","Captain","Captain"
                    ,"Captain","Captain","Monkey&Parrot","Monkey&Parrot","Monkey&Parrot","Monkey&Parrot","Diamond","Diamond","Diamond"
                    ,"Diamond","Coin","Coin","Coin","Coin","2Skulls","2Skulls","1Skull","1Skull","1Skull","2Swords(300 pts)","2Swords(300 pts)"
                    ,"3Swords(500 pts)","3Swords(500 pts)","4Swords(1000 pts)","4Swords(1000 pts)"));
    String Card = game.getFortune();
    int[] die = game.rollDice();

    @Test
    public void Row111(){
        players[0] = pl;
        players[1] = pl1;
        players[2] = pl2;
        Card = "2Skulls";
        die[0] = 6;
        die[1] = 6;
        die[2] = 6;
        die[3] = 5;
        die[4] = 5;
        die[5] = 5;
        die[6] = 5;
        die[7] = 5;
        String[] reroll = {"8","6","7","4","5"};
        int[] re =game.reRollKeep(die,reroll);
        re[5] = 1;
        re[6] = 1;
        re[7] = 1;
        re[3]=  1;
        re[4] = 1;
        pl.island(players,re,Card);
        Assertions.assertEquals(0,pl.getScore());
        Assertions.assertEquals(0,pl1.getScore());
        Assertions.assertEquals(0,pl2.getScore());
    }
}