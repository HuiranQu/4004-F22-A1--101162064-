package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class score_CoinandDiamond_Test {
    int[] die = {2,2,2,2,2,2,2,2};

    int[] die1 = {1,3,3,3,3,3,3,3};

    int[] die2 = {3,3,3,3,3,3,3,3};

    @Test
    public void score_coinAndDiamond_Test_only(){
        Game game = new Game();
        Assertions.assertEquals(100,game.scoreCandD(die1));
    }
    @Test
    public void score_coinAndDiamond_Test_all(){
        Game game = new Game();
        Assertions.assertEquals(800,game.scoreCandD(die));
    }
    @Test
    public void score_coinAndDiamond_Test_none(){
        Game game = new Game();
        Assertions.assertEquals(0,game.scoreCandD(die2));
    }

}