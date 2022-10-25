package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Player_Chest_Test {
    int[] die = {1,6,4,0,0,0,0,0};

    int[] store = {4,4,4,4,4,0,0,0};
    Player pl = new Player("A");
    @Test
    public void scoreWithChest(){
        for(int i = 0;i<8;i++){
            if (die[i] != 0){
                for(int j = 0;i<8;j++){
                    if (store[j] == 0){
                        store[j] = die[i];
                        break;
                    }
                }
            }
        }
        pl.scoreRound(1,store,"Chest");
        Assertions.assertEquals(1100,pl.getScore());
    }

}