package project;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Player implements Serializable{
    private static final long serialVersionUID = 1L;
    public String name;

    int playerId = 0;

    Game game = new Game();
    private int[] scoreSheet = new int[15];

    Client clientConnection;

    Player[] players = new Player[3];
    Boolean inTestMode = false;


    public int getUpperScore() {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (this.getScoreSheet()[i] >= 0)
                count += this.scoreSheet[i];
        }
        return count;
    }

    public int getLowerScore() {
        int count = 0;
        for (int i = 6; i < 13; i++) {
            if (this.getScoreSheet()[i] >= 0)
                count += this.scoreSheet[i];
        }
        return count;
    }

    public int getScore() {
        int sc = getLowerScore() + getUpperScore();
        sc += scoreSheet[13]+scoreSheet[14]+2;
        return sc;
    }

    public int[] playRound(int[] dieRoll,String ID) {
        Scanner myObj = new Scanner(System.in);
        int count = 1;
        int stop = 0;
        int[] store = new int[8];
        game.printDieRoll(dieRoll);
        System.out.println("1 = coin, 2 = Diamond, 3 = Monkey, 4 = Parrot, 5 = Sword, 6 = Skull");
        System.out.println("");
        System.out.println("The Fortune card you have is: " + ID);
        System.out.println("");
        while (stop == 0) {
            int skull = 0;
            int reroll = 1;
            for (int i = 0; i < dieRoll.length; i++) {
                if (dieRoll[i] == 6) {
                    skull++;
                    //System.out.println("dice"+dieRoll[i]);
                    //System.out.println("Skull"+skull);j

                }
            }
            if (skull == 3 && count == 1) {             //first roll with 3 skull dices.
                stop = 1;
                System.out.println("roll with 3 skull dice.");
                break;
            }
            if (skull != 3) {
                System.out.println("Select an action: ");
                if (count < 100) {
                    System.out.println("(1) Choose dice number to roll again");
                }
                System.out.println("(2) Score this round");
                int act = myObj.nextInt();
                if (act == 1 && count < 100) {
                    System.out.println("Select the die to re-roll: (1,2...) ");

                    String[] die = (myObj.next()).replaceAll("\\s", "").split(",");
                    if (die.length <= 1) {                               //must use at least two dice,
                        System.out.println("Must roll at least two dices");
                        continue;
                    }
                    if (reroll == 1) {
                        dieRoll = game.reRollKeep(dieRoll, die);
                        count++;
                        System.out.println("New Roll: ");
                        game.printDieRoll(dieRoll);
                    }
                }
                int r = 0;
                if (act == 2) {
                    System.out.println("Where do you want write the score in the scoresheet? (0~14)");
                    r = myObj.nextInt();
                    setScoreSheet(scoreRound(r, dieRoll, ID));
                    r = -1;
                    stop = 1;
                }
            }
        }
        System.out.println("This turn ends");
        return this.scoreSheet;
    }

    public int[] scoreRound(int r, int[] dieRoll,String ID) {
        int totalscore = 0;
        int skull = 0;
        for (int i = 0;i<dieRoll.length;i++){
            if (dieRoll[i] == 6){
                skull++;
            }
        }
        totalscore = game.scoreSet(dieRoll)+game.scoreCandD(dieRoll)+game.scoreFullchest(dieRoll);
        setScoreSheet(r,totalscore);
        return getScoreSheet();
    }




    
    // client
    private class Client {
        Socket socket;
        private ObjectInputStream dIn;
        private ObjectOutputStream dOut;

        public Client() {
            try {
                socket = new Socket("localhost", Config.GAME_SERVER_PORT_NUMBER);
                dOut = new ObjectOutputStream(socket.getOutputStream());
                dIn = new ObjectInputStream(socket.getInputStream());

                playerId = dIn.readInt();

                System.out.println("Connected as " + playerId);
                sendPlayer();

            } catch (IOException ex) {
                System.out.println("Client failed to open");
            }
        }

        public Client(int portId) {
            try {
                socket = new Socket("localhost", portId);
                dOut = new ObjectOutputStream(socket.getOutputStream());
                dIn = new ObjectInputStream(socket.getInputStream());

                playerId = dIn.readInt();

                System.out.println("Connected as " + playerId);
                sendPlayer();

            } catch (IOException ex) {
                System.out.println("Client failed to open");
            }
        }

        /*
         * function to send the score sheet to the server
         */
        public void sendPlayer() {
            try {
                dOut.writeObject(getPlayer());
                dOut.flush();
            } catch (IOException ex) {
                System.out.println("Player not sent");
                ex.printStackTrace();
            }
        }

        /*
         * function to send strings
         */
        public void sendString(String str) {
            try {
                dOut.writeUTF(str);
                dOut.flush();
            } catch (IOException ex) {
                System.out.println("String not sent");
                ex.printStackTrace();
            }
        }

        /*
         * receive scoresheet
         */
        public void sendScores(int[] scores) {
            try {
                for (int i = 0; i < scores.length; i++) {
                    dOut.writeInt(scores[i]);
                }
                dOut.flush();

            } catch (IOException e) {
                System.out.println("Score sheet not received");
                e.printStackTrace();
            }
        }

        /*
         * receive scores of other players
         */
        public Player[] receivePlayer() {
            Player[] pl = new Player[3];
            try {
                Player p = (Player) dIn.readObject();
                pl[0] = p;
                p = (Player) dIn.readObject();
                pl[1] = p;
                p = (Player) dIn.readObject();
                pl[2] = p;
                return pl;

            } catch (IOException e) {
                System.out.println("Score sheet not received");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                System.out.println("class not found");
                e.printStackTrace();
            }
            return pl;
        }

        /*
         * receive scores of other players
         */
        public int[][] receiveScores() {
            try {
                int[][] sc = new int[3][15];
                for (int j = 0; j < 3; j++) {
                    for (int i = 0; i < 15; i++) {
                        sc[j][i] = dIn.readInt();
                    }
                    System.out.println();
                }

                return sc;
            } catch (Exception e) {
                System.out.println("Score sheet not received");
                e.printStackTrace();
            }
            return null;
        }

        /*
         * receive scores of other players
         */
        public int receiveRoundNo() {
            try {
                return dIn.readInt();

            } catch (IOException e) {
                System.out.println("Score sheet not received");
                e.printStackTrace();
            }
            return 0;
        }

        void terminate() {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Score sheet not received");
                e.printStackTrace();
            }
        }

    }
    public int[] getScoreSheet() {
        return scoreSheet;
    }

    public void setScoreSheet(int cat, int score) {
        this.scoreSheet[cat] = score;
    }

    public void setScoreSheet(int[] ss) {
        this.scoreSheet = ss;
    }
    public Player(String n) {
        name = n;
        for (int i = 0; i < scoreSheet.length; i++) {
            scoreSheet[i] = -1;
        }
    }
    public Player getPlayer() {
        return this;
    }
    public static void main(String args[]) {


    }

}
