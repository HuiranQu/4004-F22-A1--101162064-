package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Player_DiamondCard_Test {
    int[] die = {3,3,4,4,5,5,6,6,0};
    int[] die2 = {2,2,3,3,4,4,5,5,0};
    int[] die3 = {2,2,2,2,2,2,2,3,0};
    Player pl = new Player("A");

    @Test
    public void die_without_DiamondTest(){
        //pl.playRound(die,"od");
        pl.scoreRound(1,die,"Diamond");
        Assertions.assertEquals(100,pl.getScore());
    }

    @Test
    public void die_with2Diamond_Test(){
        //pl.playRound(die,"od");
        pl.scoreRound(1,die2,"Diamond");
        Assertions.assertEquals(400,pl.getScore());
    }

    @Test
    public void die_with8Diamond_Test(){
        //pl.playRound(die,"od");
        pl.scoreRound(1,die3,"Diamond");
        Assertions.assertEquals(4800,pl.getScore());
    }

}