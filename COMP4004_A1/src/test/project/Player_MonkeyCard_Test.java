package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Player_MonkeyCard_Test {
    int[] die = {3,3,4,4,5,5,6,6,0};
    int[] die2 = {3,3,3,3,4,4,4,4,0};
    Player pl = new Player("A");

    @Test
    public void die_without_DiamondTest(){
        //pl.playRound(die,"od");
        pl.scoreRound(1,die," ");
        Assertions.assertEquals(0,pl.getScore());
    }

    @Test
    public void die_with2Diamond_Test(){
        //pl.playRound(die,"od");
        pl.scoreRound(1,die,"Monkey&Parrot");
        Assertions.assertEquals(200,pl.getScore());
    }

    @Test
    public void die_with3Diamond_Test(){
        //pl.playRound(die,"od");
        pl.scoreRound(1,die2,"Monkey&Parrot");
        Assertions.assertEquals(4500,pl.getScore());
    }
}