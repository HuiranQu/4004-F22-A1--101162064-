package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreFullChest_Test {
    int[] die = {1,1,1,1,1,1,1,1};

    int[] die1 = {1,2,3,4,5,6,1,2};

    @Test
    public void fullchest_valid_test(){
        Game game = new Game();

        Assertions.assertEquals(500,game.scoreFullchest(die));

    }

    @Test
    public void fullchest_valid_test2(){
        Game game = new Game();
        Assertions.assertEquals(0,game.scoreFullchest(die1));
    }


}