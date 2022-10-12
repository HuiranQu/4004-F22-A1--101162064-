package project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Game_PrintDiceRoll_test {
    int[] dice = {1,2,3,4,5,6,1,2};
    @Test
    public void DiceRollPrint(){
        Game game = new Game();
        game.printDieRoll(dice);
    }

}