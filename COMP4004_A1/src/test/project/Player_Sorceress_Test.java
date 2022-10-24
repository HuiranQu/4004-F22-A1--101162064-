package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Player_Sorceress_Test {
    int[] die = {2,2,1,3,5,4,4,4};

    int[] reroll1 ={2,2,1,3,5,6,3,3};
    int[] reroll2 ={2,2,1,3,5,3,3,3};
    int[] die2 = {6,6,6,6,1,2,3,4};
    Player pl = new Player("A");
    @Test
    public void scoreWithSorceress(){
        pl.scoreRound(1,reroll2,"Sorceress");
        Assertions.assertEquals(500,pl.getScore());
    }

    @Test
    public void EndWith4moreSkull_Sorceress(){
        pl.scoreRound(1,die2,"Sorceress");
        Assertions.assertEquals(0,pl.getScore());
    }


}