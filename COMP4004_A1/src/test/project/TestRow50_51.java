package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestRow50_51 {
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
    public void Row50And51(){
        Card = "Coin";
        die[0] = 6;
        die[1] = 4;
        die[2] = 4;
        die[3] = 5;
        die[4] = 5;
        die[5] = 5;
        die[6] = 1;
        die[7] = 1;

        String[] reroll = {"3","2"};
        int[] re =game.reRollKeep(die,reroll);
        re[1] = 1;
        re[2] = 1;
        for(int i =0;i<re.length;i++){
            System.out.println(re[i]);
        }
        String[] reroll2 = {"5","6","4"};
        int[] re2 =game.reRollKeep(re,reroll2);
        re2[3] = 1;
        re2[4] = 1;
        re2[5] = 1;
        System.out.println("2:");
        for(int i =0;i<re2.length;i++){

            System.out.println(re2[i]);
        }
        pl.scoreRound(0,re2,Card);
        int score = pl.getScore();
        Assertions.assertEquals(4800,score);
    }

}