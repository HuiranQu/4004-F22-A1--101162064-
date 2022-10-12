package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Game_Get_Winner_Test {
    Player p1 = new Player("a");
    Player p2= new Player("b");
    Player p3 = new Player("c");
    Player[] p = {p1,p2,p3};
    int[] score = {100,200,300,400,500,600,700,800,900,1000,1100,1200,1300,1400,1500};
    int[] score2 = {100,200,300,400,500,600,700,800,900,1000,1100,1200,1300,1400,0};
    int[] score3 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    int[] score4 = {100,200,300,400,500,600,700,800,900,1000,1100,1200,1300,1400,1500};
    @Test
    public void getWinner(){
        Game game = new Game();
        p1.setScoreSheet(score);
        p2.setScoreSheet(score2);
        p3.setScoreSheet(score3);
        Assertions.assertEquals(p1,p1.game.getWinner(p));
    }
    @Test
    public void getWinner_sameScore(){
        Game game = new Game();
        p1.setScoreSheet(score);
        p2.setScoreSheet(score4);
        p3.setScoreSheet(score3);
        Assertions.assertEquals(p1,p1.game.getWinner(p));
    }

}