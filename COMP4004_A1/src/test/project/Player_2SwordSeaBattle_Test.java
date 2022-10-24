package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Player_2SwordSeaBattle_Test {
    int[] die = {6,3,4,4,5,5,3,6,0};
    int[] die2 = {6,3,4,4,4,5,3,6,0};
    int[] die3 = {6,3,4,6,4,5,3,6,0};
    Player pl = new Player("A");

    @Test
    public void die_Win_Test(){
        pl.scoreRound(1,die,"2Swords(300 pts)");
        Assertions.assertEquals(300,pl.getScore());
    }
    @Test
    public void die_lose_lessSword_Test(){
        pl.scoreRound(1,die2,"2Swords(300 pts)");
        Assertions.assertEquals(-300,pl.getScore());
    }

    @Test
    public void die_lose_3skull_Test(){
        pl.scoreRound(1,die3,"2Swords(300 pts)");
        Assertions.assertEquals(-300,pl.getScore());
    }

}