package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FullChest_test {
    int[] die = {1,1,1,1,1,1,1,1};

    int[] die1 = {1,2,3,4,5,6,1,2};

    @Test
    public void fullchest_valid_test(){
        Game game = new Game();
        Assertions.assertEquals(true,game.isFullchest(die));

    }

    @Test
    public void fullchest_valid_test2(){
        Game game = new Game();
        Assertions.assertEquals(false,game.isFullchest(die1));
    }

}