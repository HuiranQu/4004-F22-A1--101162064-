package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Player_moreRound_4Skull_Test {
    int[] die = {6,6,1,2,3,4,5,5};

    Player pl = new Player("A");

    @Test
    public void FirstRound_WithOut3Skull_Test(){
        pl.scoreRound(1,die," ");
        Assertions.assertEquals(200,pl.getScore());
    }
}


}