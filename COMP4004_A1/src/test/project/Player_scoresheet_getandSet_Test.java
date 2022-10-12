package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Player_scoresheet_getandSet_Test {
    Player p1 = new Player("a");
    int[] score = {1,2,3,4};
    int[] modify_score = {6,2,3,4};
    @Test
    public void name_test(){
        p1.setScoreSheet(score);
        for (int i = 0;i<4;i++){
            Assertions.assertEquals(score[i],p1.getScoreSheet()[i]);
        }
    }

    @Test
    public void player_scoresheet_test(){
        p1.setScoreSheet(score);
        p1.setScoreSheet(0,6);
        for (int i = 0;i<4;i++){
            Assertions.assertEquals(modify_score[i],p1.getScoreSheet()[i]);
        }

    }

}