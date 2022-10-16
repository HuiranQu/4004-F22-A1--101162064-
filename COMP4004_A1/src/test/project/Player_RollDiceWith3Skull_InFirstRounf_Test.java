package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Player_RollDiceWith3Skull_InFirstRounf_Test {
    int[] die = {6,6,6,1,1,1,1,1};

    Player pl = new Player("A");

    @Test
    public void FirstRound_With3Skull_Test(){
        pl.playRound(die,"coin");
        Assertions.assertEquals(0,pl.getScore());

    }
}