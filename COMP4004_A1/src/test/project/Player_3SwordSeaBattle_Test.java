package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Player_3SwordSeaBattle_Test {
    int[] die = {6,3,5,5,5,5,3,3,0};
    int[] die2 = {6,3,4,4,4,5,3,6,0};
    int[] die3 = {6,3,4,6,4,5,3,6,0};
    Player pl = new Player("A");

    @Test
    public void die_Win_Test(){
        pl.scoreRound(1,die,"3Swords(500 pts)");
        Assertions.assertEquals(800,pl.getScore());
    }
    @Test
    public void die_lose_lessSword_Test(){
        pl.setScoreSheet(0,600);
        pl.scoreRound(1,die2,"3Swords(500 pts)");
        Assertions.assertEquals(100,pl.getScore());
    }

    @Test
    public void die_lose_3skull_Test(){
        pl.setScoreSheet(0,400);
        pl.scoreRound(1,die3,"3Swords(500 pts)");
        Assertions.assertEquals(0,pl.getScore());
    }

}