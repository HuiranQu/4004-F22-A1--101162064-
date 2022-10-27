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

    public int[] rerollDice(int[] dieRoll, int i) {
        dieRoll[i] = (int) (Math.random() * 6 + 1);
        return dieRoll;
    }

    public int[] reRollKeep(int[] dieRoll, String[] keep) {
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        for (String s : keep) {
            int rem = Integer.parseInt(s) - 1;
            rolls.add(rem);
        }
        for (int s : rolls) {
            dieRoll = rerollDice(dieRoll, (s));
        }
        return dieRoll;
    }

    public boolean isOfAKind(int x, int[] dieRoll) {
        HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
        for (int i : dieRoll) {
            if (dict.containsKey(i)) {
                dict.put(i, dict.get(i) + 1);
            } else {
                dict.put(i, 1);
            }
        }
        Collection<Integer> val = dict.values();
        if (val.contains(x)  && Collections.max(val) > 2) {
            return true;
        }
        return false;
    }

    public int scoreSet(int[] dieRoll) {
        int sc = 0;
        if (isOfAKind(3, dieRoll)) {
            sc = sc+100;
        }
        if (isOfAKind(4,dieRoll)){
            sc = sc+200;
        }

        if (isOfAKind(5,dieRoll)){
            sc = sc + 500;
        }
        if (isOfAKind(6,dieRoll)){
            sc = sc + 1000;
        }
        if ((isOfAKind(7,dieRoll))){
            sc = sc + 2000;
        }
        if (isOfAKind(8,dieRoll)||isOfAKind(9,dieRoll)){
            sc = sc + 4000;
        }
        return sc;
    }

    public boolean isFullchest(int[] dieRoll) {
        for (int i =0;i<dieRoll.length;i++){
            if (dieRoll[i] == 6){
                return false;
            }
        }
        int num_CandD = 0;
        int getScore = 0;
        int j = 0;
        int[] Non_CandD_dice = new int[8];
        for (int i =0;i<8;i++){
            if (dieRoll[i] == 1 || dieRoll[i] == 2){
                getScore++;
                num_CandD++;
            }else{
                Non_CandD_dice[j] = dieRoll[i];
                j++;
            }
        }
        HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
        for (int i : Non_CandD_dice) {
            if (dict.containsKey(i)) {
                dict.put(i, dict.get(i) + 1);
            } else {
                dict.put(i, 1);
            }
        }
        Collection<Integer> val = dict.values();

        if(num_CandD == 0){           //need all 8 dice to get score
            if (val.contains(4)){
                val.remove(4);
                if (val.contains(4)){
                    getScore = 8;
                }
            }
            if ((val.contains(8) )||(val.contains(3) && val.contains(5))){
                getScore = 8;
            }
        }
        if(num_CandD == 1){           //need all 7 dice to get score
            if ((val.contains(7) )|| (val.contains(3) && val.contains(4))){
                getScore = 8;
            }
        }
        if(num_CandD == 2){                    //need all 6 dice to get score.
            if (val.contains(3)){
                val.remove(3);
                if (val.contains(3)){
                    getScore = 8;
                }
            }
            if ((val.contains(6))){
                getScore = 8;
            }
        }
        if(num_CandD == 3){                       //need all 5 dice to get score
            if ((val.contains(5) )){
                getScore = 8;
            }
        }
        if(num_CandD == 5){                       //need all other 3 dice get score.
            if ((val.contains(3))){
                getScore = 8;
            }
        }
        if (getScore == 8){
            return true;
        }
        return false;
    }

    public int scoreFullchest(int[] dieRoll) {
        if (isFullchest(dieRoll))
            return 500;
        return 0;
    }

    public int scoreCandD(int[] dieRoll) {
        int count = 0;
        int score = 0;
        for (int i =0;i<dieRoll.length;i++){
            if (dieRoll[i] == 1 || dieRoll[i] == 2){           //whether a die is coin or diamond
                count++;
            }
        }
        score = 100*count;
        return score;
    }
    public Player getWinner(Player[] pl) {
        Player temp = pl[1];
        if (pl[0].getScore() >= pl[1].getScore())
            temp = pl[0];
        if (pl[2].getScore() >= temp.getScore())
            return pl[2];
        return temp;
    }

    public String getFortune(){
        Random rand = new Random();
        int n = rand.nextInt(35);
        List<String> Fortune = new ArrayList<>(
                List.of("Chest","Chest","Chest","Chest","Sorceress","Sorceress","Sorceress","Sorceress","Captain","Captain"
                        ,"Captain","Captain","Monkey&Parrot","Monkey&Parrot","Monkey&Parrot","Monkey&Parrot","Diamond","Diamond","Diamond"
                        ,"Diamond","Coin","Coin","Coin","Coin","2Skulls","2Skulls","1Skull","1Skull","1Skull","2Swords(300 pts)","2Swords(300 pts)"
                        ,"3Swords(500 pts)","3Swords(500 pts)","4Swords(1000 pts)","4Swords(1000 pts)"));
        return Fortune.get(n);
    }

    public void printDieRoll(int[] dieRoll) {
        System.out.println(" ___    ___    ___    ___    ___    ___    ___    ___ ");
        System.out.println("| " + dieRoll[0] + " |  | " + dieRoll[1] + " |  | " + dieRoll[2] + " |  | " + dieRoll[3]
                + " |  | " + dieRoll[4] +" |  | " + dieRoll[5] + " |  | " + dieRoll[6] +" |  | " + dieRoll[7] + " | ");
        System.out.println("|___|  |___|  |___|  |___|  |___|  |___|  |___|  |___|");

    }

    public void printScoreSheet(Player p) {
        String[] sc = new String[p.getScoreSheet().length];
        for (int i = 0; i < p.getScoreSheet().length; i++) {
            if (p.getScoreSheet()[i] == -1) {
                sc[i] = "-";
            } else {
                sc[i] = "" + p.getScoreSheet()[i];
            }
        }
        System.out.println(
                "|---------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("| Scores for player : " + p.name + "\t \t \t \t \t \t \t \t \t \t \t \t \t \t|");
        System.out.println(
                "|---------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("| Total Score : " + p.getScore() + "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t|");
        System.out.println(
                "|---------------------------------------------------------------------------------------------------------------------------------------|");

    }
}
