package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Player_IslandSkull_Test {
    Player[] players = new Player[3];
    Player pl = new Player("A");
    Player pl1 = new Player("B");
    Player pl2 = new Player("C");
    int[] die = {6,6,6,6,1,2,3,4};

    int[] die2 = {6,6,6,2,3,4,5,5};
    @Test
    public void island_test(){
        players[0] = pl;
        players[1] = pl1;
        players[2] = pl2;
        pl.island(players,die,"Coin");
        Assertions.assertEquals(0,pl1.getScore());
        Assertions.assertEquals(0,pl2.getScore());
    }

    @Test
    public void island_SkullCard_test(){
        players[0] = pl;
        players[1] = pl1;
        players[2] = pl2;
        pl.island(players,die2,"2Skulls");
        Assertions.assertEquals(0,pl1.getScore());
        Assertions.assertEquals(0,pl2.getScore());
    }

    @Test
    public void island_CapCard_test(){
        players[0] = pl;
        players[1] = pl1;
        players[2] = pl2;
        pl.island(players,die,"Captain");
        Assertions.assertEquals(0,pl1.getScore());
        Assertions.assertEquals(0,pl2.getScore());
    }
}