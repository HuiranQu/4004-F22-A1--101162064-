package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Game_GetFortuneCard_Test {
    Game game = new Game();
    List<String> Fortune = new ArrayList<>(
            List.of("Chest","Chest","Chest","Chest","Sorceress","Sorceress","Sorceress","Sorceress","Captain","Captain"
                    ,"Captain","Captain","Monkey&Parrot","Monkey&Parrot","Monkey&Parrot","Monkey&Parrot","Diamond","Diamond","Diamond"
                    ,"Diamond","Coin","Coin","Coin","Coin","2Skulls","2Skulls","1Skull","1Skull","1Skull","2Swords(300 pts)","2Swords(300 pts)"
                    ,"3Swords(500 pts)","3Swords(500 pts)","4Swords(1000 pts)","4Swords(1000 pts)"));

    @Test
    public void Fortune_output_test(){
        String text = game.getFortune();
        String outPut = " ";
        for (int i = 0;i<35;i++){
            if (Fortune.get(i) == text){
                outPut = Fortune.get(i);
            }
        }
        Assertions.assertEquals(outPut,text);
    }

    @Test
    public void Fortune_Length_test(){
        String text = game.getFortune();
        String outPut = " ";
        for (int i = 0;i<35;i++){
            if (Fortune.get(i) == text){
                outPut = Fortune.get(i);
            }
        }
        Assertions.assertEquals(outPut.length(),text.length());
    }

}