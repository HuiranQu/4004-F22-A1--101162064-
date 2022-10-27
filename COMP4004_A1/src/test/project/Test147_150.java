package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test147_150 {
        Player[] players = new Player[3];
        Player pl = new Player("A");
        Player pl1 = new Player("B");
        Player pl2 = new Player("C");
        Game game = new Game();

        @Test
        public void island_CapCard_test(){
            //pl2.setScoreSheet(0,0);
            int[] pl_die = {5,5,5,5,5,5,6,6,0};
            players[0] = pl;
            players[1] = pl1;
            players[2] = pl2;
            pl.scoreRound(0,pl_die,"Coin");
            int[] pl1_die = {6,6,6,6,6,6,6,1};
            String[] reroll = {"1"};
            int[] re =game.reRollKeep(pl1_die,reroll);
            re[0] = 4;
            String[] reroll2 = {"1","8"};
            int[] re2 =game.reRollKeep(re,reroll2);
            re2[0] = 6;
            re2[7] = 6;
            pl1.island(players,re2,"Sorceress");
            Assertions.assertEquals(300,pl.getScore());
            Assertions.assertEquals(0,pl1.getScore());
            Assertions.assertEquals(0,pl2.getScore());
        }
}