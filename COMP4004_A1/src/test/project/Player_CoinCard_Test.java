package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Player_CoinCard_Test {
    int[] die = {3,3,4,4,5,5,6,6,0};
    int[] die2 = {1,1,3,3,4,4,5,5,0};
    int[] die3 = {1,1,1,1,1,1,1,3,0};
    Player pl = new Player("A");

    @Test
    public void die_without_coinTest(){
        //pl.playRound(die,"od");
        pl.scoreRound(1,die,"Coin");
        Assertions.assertEquals(100,pl.getScore());
    }

    @Test
    public void die_with2coin_Test(){
        //pl.playRound(die,"od");
        pl.scoreRound(1,die2,"Coin");
        Assertions.assertEquals(400,pl.getScore());
    }

    @Test
    public void die_with8coin_Test(){
        //pl.playRound(die,"od");
        pl.scoreRound(1,die3,"Coin");
        Assertions.assertEquals(4800,pl.getScore());
    }

}