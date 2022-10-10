package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import project.Game;

import static org.junit.jupiter.api.Assertions.*;

class isSet_Test {
    int[] dice = {1,1,1,2,3,4,7,8};
    int[] dice1 = {1,1,1,1,1,1,1,1};
    int[] dice2 = {1,2,3,4,5,6,1,2};
    @Test
    public void isSetof_test(){
        Game game = new Game();
        Assertions.assertEquals(true,game.isOfAKind(3,dice));
    }

    @Test
    public void isSetof_invaild_test(){
        Game game = new Game();
        Assertions.assertEquals(false,game.isOfAKind(4,dice));
    }

    @Test
    public void isSetof_test2(){
        Game game = new Game();
        Assertions.assertEquals(true,game.isOfAKind(8,dice1));
    }

    @Test
    public void isSetof_test3(){
        Game game = new Game();
        Assertions.assertEquals(false,game.isOfAKind(9,dice1));
    }

    @Test
    public void isSetof_test4(){
        Game game = new Game();
        Assertions.assertEquals(false,game.isOfAKind(3,dice2));
    }
    @Test
    public void isSetof_test5(){
        Game game = new Game();
        Assertions.assertEquals(false,game.isOfAKind(2,dice2));
    }

}