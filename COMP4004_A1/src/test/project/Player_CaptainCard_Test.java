package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Player_CaptainCard_Test {
    int[] die = {1,3,4,4,5,5,6,6,0};
    int[] die2 = {1,1,1,1,1,1,1,1,0};
    int[] die3 = {3,3,4,4,5,5,6,6,0};
    Player pl = new Player("A");

    @Test
    public void die_Cap_Test(){
        //pl.playRound(die,"od");
        pl.scoreRound(1,die,"Captain");
        Assertions.assertEquals(200,pl.getScore());
    }

    @Test
    public void die_Cap_Full_Test(){
        //pl.playRound(die,"od");
        pl.scoreRound(1,die2,"Captain");
        Assertions.assertEquals(10600,pl.getScore());
    }


    @Test
    public void die_Cap_0_Test(){
        //pl.playRound(die,"od");
        pl.scoreRound(1,die3,"Captain");
        Assertions.assertEquals(0,pl.getScore());
    }

}