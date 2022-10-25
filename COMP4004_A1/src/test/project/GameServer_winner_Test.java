package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameServer_winner_Test {
    Player[] players = new Player[3];
    Player pl = new Player("A");
    Player pl1 = new Player("B");
    Player pl2 = new Player("C");
    Game game = new Game();
    @Test
    public void island_test(){
        players[0] = pl;
        players[1] = pl1;
        players[2] = pl2;
        pl.setScoreSheet(1,100);
        pl1.setScoreSheet(1,200);
        pl2.setScoreSheet(1,3000);

        Assertions.assertEquals(pl2,game.getWinner(players));
    }

}