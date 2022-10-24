package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Player_4SwordSeaBattle_Test {
    int[] die = {6,3,5,5,5,5,3,3,0};
    int[] die2 = {6,3,4,4,4,5,3,6,0};
    int[] die3 = {6,3,4,6,4,5,3,6,0};
    Player pl = new Player("A");

    @Test
    public void die_Win_Test(){
        pl.scoreRound(1,die,"4Swords(1000 pts)");
        Assertions.assertEquals(1300,pl.getScore());
    }
    @Test
    public void die_lose_lessSword_Test(){
        pl.scoreRound(1,die2,"4Swords(1000 pts)");
        Assertions.assertEquals(-1000,pl.getScore());
    }

    @Test
    public void die_lose_3skull_Test(){
        pl.scoreRound(1,die3,"4Swords(1000 pts)");
        Assertions.assertEquals(-1000,pl.getScore());
    }

}