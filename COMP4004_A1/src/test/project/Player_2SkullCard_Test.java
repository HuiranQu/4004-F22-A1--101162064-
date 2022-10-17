package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Player_2SkullCard_Test {
    int[] die = {1,3,4,4,5,5,1,6,0};
    int[] die2 = {1,1,5,3,4,4,5,5,0};
    int[] die3 = {6,3,4,4,5,5,6,6,0};
    Player pl = new Player("A");

    @Test
    public void die_2Skull_Test(){
        pl.scoreRound(1,die,"2Skulls");
        Assertions.assertEquals(0,pl.getScore());
    }

    @Test
    public void die_ScoreWithoutSkull_Test(){
        pl.scoreRound(1,die2,"2Skulls");
        Assertions.assertEquals(300,pl.getScore());
    }
    @Test
    public void die_2Skull_Test2(){
        pl.scoreRound(1,die3,"2Skulls");
        Assertions.assertEquals(0,pl.getScore());
    }

}