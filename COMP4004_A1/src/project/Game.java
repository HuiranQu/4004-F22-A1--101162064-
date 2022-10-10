package project;

import java.io.Serializable;
import java.util.*;

public class Game implements Serializable {
    private static final long serialVersionUID = 1L;

    public int[] rollDice() {
        int[] die = new int[9];
        for (int i = 0; i < 8; i++) {
            int rand = (int) (Math.random() * 6 + 1);
            die[i] = rand;
        }
        return die;
    }
}
