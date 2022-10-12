package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Player_getPlayer_Test {
    Player p1 = new Player("a");
    @Test
    public void name_test(){
        Assertions.assertEquals("a",p1.getPlayer().name);
    }
}