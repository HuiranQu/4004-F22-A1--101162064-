package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Player_constructor_Test {
    Player p1 = new Player("a");

    @Test
    public void name_test(){
        Assertions.assertEquals("a",p1.name);
    }

    @Test
    public void player_scoresheet_test(){
        Assertions.assertEquals(15,p1.getScoreSheet().length);
    }

}