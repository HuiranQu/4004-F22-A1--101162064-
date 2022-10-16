package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Player_getRoundScore_Test {
    int[] die = {6,6,4,3,3,4,5,5};

    Player pl = new Player("A");

    @Test
    public void FirstRound_With3Skull_Test(){
        //pl.playRound(die,"od");
        pl.scoreRound(1,die," ");
        Assertions.assertEquals(0,pl.getScore());
    }
}