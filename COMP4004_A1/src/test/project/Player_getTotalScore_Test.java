package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Player_getTotalScore_Test {
    Player p1 = new Player("a");
    int[] score = {100,200,300,400,500,600,700,800,900,1000,1100,1200,1300,1400,1500};
    int[] score2 = {100,200,300,400,500,600,700,800,900,1000,1100,1200,1300,1400,0};
    int[] score3 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    @Test
    public void getTotalScore(){
        p1.setScoreSheet(score);
        Assertions.assertEquals(12000,p1.getScore());
    }
    @Test
    public void getTotalScore_with0(){
        p1.setScoreSheet(score2);
        Assertions.assertEquals(10500,p1.getScore());
    }

    @Test
    public void getTotalScore_empty(){
        p1.setScoreSheet(score3);
        Assertions.assertEquals(0,p1.getScore());
    }


}