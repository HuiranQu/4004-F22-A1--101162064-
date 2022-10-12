package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Player_getUpAndLower_score_Test {
    Player p1 = new Player("a");
    int[] score = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

    @Test
    public void getUpperscoer(){
        p1.setScoreSheet(score);
        Assertions.assertEquals(21,p1.getUpperScore());
    }

    @Test
    public void getlowerscoer(){
        p1.setScoreSheet(score);
        Assertions.assertEquals(70,p1.getLowerScore());
    }



}