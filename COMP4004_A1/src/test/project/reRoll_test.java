package project;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class reRoll_test {
    Game game = new Game();

    int[] di = game.rollDice();
    String[] keep = {"1","2","3"};
    int[] re_di = game.reRollKeep(di,keep);    //reroll the dice.


    @Test
    public void DiceRoll_LengthTest(){
        Assertions.assertEquals(9,re_di.length);
    }

    @Test
    public void DiceRoll_rangeTest(){
        for (int i = 0;i<8;i++){
            if (di[i] == 1){
                Assertions.assertEquals(1,re_di[i]);
            }
        }
    }
    @Test
    public void DiceRoll_rangeTest1(){
        for (int i = 0;i<8;i++){
            if (di[i] == 6){
                Assertions.assertEquals(6,re_di[i]);
            }
        }
    }

    @Test
    public void DiceRoll_rangeTest2(){
        for (int i = 0;i<8;i++){
            Assertions.assertNotEquals(0,re_di[i]);
        }
    }
    @Test
    public void DiceRoll_rangeTest3(){
        for (int i = 0;i<8;i++){
            Assertions.assertNotEquals(7,re_di[i]);
        }
    }
}