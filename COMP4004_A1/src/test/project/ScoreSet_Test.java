package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.PublicKey;

import static org.junit.jupiter.api.Assertions.*;

class ScoreSet_Test {
    int[] die = {1,1,1,2,3,4,5,5};
    int[] die1 = {1,1,2,2,3,3,4,4};
    int[] die2 = {1,1,1,1,1,1,1,1};
    int[] die3 = {1,1,1,2,2,2,2,5};
    int[] die4 = {1,1,1,1,2,2,2,2};

    @Test
    public void score_valid_test(){
        Game game = new Game();
        Assertions.assertEquals(100,game.scoreSet(die));
    }

    @Test
    public void score_valid_test1(){
        Game game = new Game();
        Assertions.assertEquals(0,game.scoreSet(die1));
    }

    @Test
    public void score_valid_test2(){
        Game game = new Game();
        Assertions.assertEquals(4000,game.scoreSet(die2));
    }
    @Test
    public void score_valid_test3(){
        Game game = new Game();
        Assertions.assertEquals(300,game.scoreSet(die3));
    }
}