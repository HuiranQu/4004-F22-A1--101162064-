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
            count += this.scoreSheet[i];
        }
        return count;
    }

    public int getLowerScore() {
        int count = 0;
        for (int i = 6; i < 13; i++) {
            count += this.scoreSheet[i];
        }
        return count;
    }

    public int getScore() {
        int sc = getLowerScore() + getUpperScore();
        sc += scoreSheet[13]+scoreSheet[14];
        if (sc < 0){
            sc = 0;
        }
        return sc;
    }

    public int[] playRound(int[] dieRoll,String ID) {
        Scanner myObj = new Scanner(System.in);
        int count = 1;
        int stop = 0;
        int sorceress = 0;
        int island = 0;
        int[] store = {0,0,0,0,0,0,0,0};
        game.printDieRoll(dieRoll);
        System.out.println("1 = coin, 2 = Diamond, 3 = Monkey, 4 = Parrot, 5 = Sword, 6 = Skull");
        System.out.println("");
        System.out.println("The Fortune card you have is: " + ID);
        System.out.println("");
        while (stop == 0) {
            ArrayList<Integer> skullroll = new ArrayList<Integer>();      //store the index of the skull dice.
            int skull = 0;
            int reroll = 1;
            for (int i = 0; i < dieRoll.length; i++) {
                if (dieRoll[i] == 6) {
                    skull++;
                    skullroll.add(i);
                }
            }
            if (ID == "1Skull"){
                skull = skull + 1;
            }
            if (ID == "2Skulls"){
                skull = skull + 2;
            }
            if (count ==1 && skull >3){
                System.out.println("Go to Island of Skull");
                island = 1;
            }
            if (skull == 3 && count == 1 ) {             //first roll with 3 skull dices.
                stop = 1;
                System.out.println("roll with 3 skull dice.");
                break;
            }
            if (skull >= 3 && count > 1) {             //second+ roll with 3 and more dies.
                stop = 1;
                System.out.println("roll with 3 and more skull dice.");
                break;
            }
            if (ID == "Sorceress" && sorceress == 1 && skull>=3){
                stop = 1;
                System.out.println("roll with 3 and more skull dice.");
                break;
            }
            if (skull != 3) {
                System.out.println("Select an action: ");
                if (count < 100) {
                    System.out.println("(1) Choose dice number to roll again");
                }
                System.out.println("(2) Score this round");
                if (ID == "Chest"){
                    System.out.println("(3) Choose dice to put in Chest:");
                }
                int act = myObj.nextInt();
                if (act == 1 && count < 100) {
                    System.out.println("Select the die to re-roll: (1,2...) ");
                    String[] die = (myObj.next()).replaceAll("\\s", "").split(",");
                    if (ID == "Sorceress"){                     //if the sorceress roll one skull
                        for (int j = 0;j<die.length;j++){
                            if (dieRoll[Integer.parseInt(die[j])] == 6){
                                sorceress = 1;
                            }
                        }
                    }
                    if (die.length <= 1) {                               //must use at least two dice,
                        System.out.println("Must roll at least two dices");
                        continue;
                    }
                    if (island == 1){                //has at least one skull in each reroll.
                        int s = 0;
                        for (int i = 0;i<die.length;i++){
                            if (dieRoll[Integer.parseInt(die[i])] == 6){
                                s++;
                            }
                        }
                        if (s == 0){
                            break;
                        }
                    }
                    if (ID == "Sorceress" && sorceress == 1){
                        for (int i = 0;i< die.length;i++){                  //cannot re-roll the skull die.
                            for (int k = 0;k<skullroll.size();k++){
                                if (Integer.parseInt(die[i])-1 == skullroll.get(k)) {      //compare the reroll with the skull dice index.
                                    System.out.println("cannot reroll the skull die again");
                                    reroll = 0;
                                }
                            }
                        }
                    }
                    if (ID != "Sorceress"){
                        for (int i = 0;i< die.length;i++){                  //cannot re-roll the skull die.
                            for (int k = 0;k<skullroll.size();k++){
                                if (Integer.parseInt(die[i])-1 == skullroll.get(k)) {      //compare the reroll with the skull dice index.
                                    System.out.println("cannot reroll the skull die");
                                    reroll = 0;
                                }
                            }
                        }
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
                    if (island == 1){
                        setScoreSheet(island(players,dieRoll,ID));
                    }else{
                        setScoreSheet(scoreRound(r, dieRoll, ID));
                    }
                    if (ID == "Chest" && skull >= 3){
                        System.out.println("Die with 3 and more skulls");
                        setScoreSheet(scoreRound(r, store,ID));
                    }
                    if (ID == "Chest" && skull < 3) {
                        for (int i = 0; i < 8; i++) {
                            if (dieRoll[i] != 0) {
                                for (int j = 0; j < 8; j++) {
                                    if (store[j] == 0) {
                                        store[j] = dieRoll[i];
                                        break;
                                    }
                                }
                            }
                        }
                        setScoreSheet(scoreRound(r, store, ID));
                    }
                    stop = 1;
                }
                if (act == 3){
                    System.out.println("Place(1) or take out(2) ?");
                    int chestAct = myObj.nextInt();
                    if (chestAct == 1){
                        System.out.println("Which dice do you want put in Chest?(e.g 1,2...)");
                        String[] die = (myObj.next()).replaceAll("\\s", "").split(",");
                        for(int i = 0;i<die.length;i++){
                            store[i] = dieRoll[Integer.parseInt(die[i])];
                            dieRoll[Integer.parseInt(die[i])] = 0;
                        }
                    }
                    if (chestAct == 2){
                        System.out.println("Which dice do you want take in Chest?(e.g 1,2...)");
                        String[] die = (myObj.next()).replaceAll("\\s", "").split(",");
                        for(int i = 0;i<die.length;i++){
                            dieRoll[Integer.parseInt(die[i])] = store[i];
                            store[i] = 0;
                        }
                    }
                }
            }
        }
        System.out.println("This turn ends");
        return this.scoreSheet;
    }

    public int[] scoreRound(int r, int[] dieRoll,String ID) {
        int totalscore = 0;
        int skull = 0;
        int Full  = 0;
        for (int i = 0;i<dieRoll.length;i++){
            if (dieRoll[i] == 6){
                skull++;
            }
        }
        if (ID == "Coin"){                    //coin F card
            dieRoll[8] = 1;
        }
        if (ID == "Diamond"){                //Diamond F card
            dieRoll[8] = 2;
        }
        if (ID == "Monkey&Parrot"){                //transform every monkey into parrot.
            for (int i= 0;i<dieRoll.length;i++){
                if (dieRoll[i] == 3){
                    dieRoll[i] = 4;
                }
            }
        }
        if (ID == "1Skull"){
            skull = skull + 1;
        }
        if (ID == "2Skulls"){
            skull = skull + 2;
        }
        Full = game.scoreFullchest(dieRoll);
        System.out.println("Set:" + game.scoreSet(dieRoll));
        System.out.println("Full:" + Full);
        totalscore = game.scoreSet(dieRoll)+game.scoreCandD(dieRoll)+Full;
        if (ID == "Captain"){
            totalscore = 2*totalscore;
        }
        if(skull > 2){
            totalscore = 0;
            System.out.println("Die for 3 or more skulls");
        }
        if ((ID == "2Swords(300 pts)")){
            int sword = 0;
            for (int i = 0;i<dieRoll.length;i++){
                if (dieRoll[i] == 5){
                    sword++;
                }
            }
            if (sword < 2||skull>2){//lose in sea battle or die with 3 or more skulls both lose points.
                if (this.getScore()>=300){
                    totalscore = -300;
                    System.out.println("Die in Sea Battle, -300 Points");
                }else{
                    totalscore = -1*this.getScore();
                    System.out.println("Die in Sea Battle,- "+this.getScore()+" Points, score cannot less than 0");
                }
            }else{
                totalscore = totalscore + 300;
            }
        }
        if ((ID == "3Swords(500 pts)")){
            int sword = 0;
            for (int i = 0;i<dieRoll.length;i++){
                if (dieRoll[i] == 5){
                    sword++;
                }
            }
            if (sword < 3 || skull>2){                         //lose in sea battle or die with 3 or more skulls both lose points.
                if (this.getScore()>=500){
                    totalscore = -500;
                    System.out.println("Die in Sea Battle, -500 Points");
                }else{
                    totalscore = -1*this.getScore();
                    System.out.println("Die in Sea Battle,- "+this.getScore()+" Points, score cannot less than 0");
                }
            }else{
                totalscore = totalscore + 500;
            }
        }
        if ((ID == "4Swords(1000 pts)")){
            int sword = 0;
            for (int i = 0;i<dieRoll.length;i++){
                if (dieRoll[i] == 5){
                    sword++;
                }
            }
            if (sword < 4 || skull>2){                                     //lose in sea battle or die with 3 or more skulls both lose points.
                if (this.getScore()>=1000){
                    totalscore = -1000;
                    System.out.println("Die in Sea Battle, -1000 Points");
                }else{
                    totalscore = -1*this.getScore();
                    System.out.println("Die in Sea Battle,- "+this.getScore()+" Points, score cannot less than 0");
                }
            }else{
                totalscore = totalscore + 1000;
            }
        }
        setScoreSheet(r,totalscore);
        return getScoreSheet();
    }

    public int[] island(Player[] pls,int[] die,String ID){
        int skull = 0;
        int reduce = 0;
        for (int i = 0;i<die.length;i++){
            if (die[i] == 6){
                skull++;
            }
        }
        if (ID == "2Skulls"){
            skull = skull +2;
        }
        if (ID == "1Skull"){
            skull = skull + 1;
        }
        reduce = -100*skull;
        if (ID == "Captain"){
            reduce = 2*reduce;
        }
        for (int i = 0;i<pls.length;i++){
                if (pls[i].getName() != this.getName()){
                    if (pls[i].getScore() >= reduce){
                        pls[i].setScoreSheet(14,reduce);
                    }else {
                        pls[i].setScoreSheet(14,0);
                    }
                }
        }
        return getScoreSheet();
    }

    /*
     * ----------Network Stuff------------
     */

    /*
     * send the to do to test server
     */
    public void sendStringToServer(String str) {
        clientConnection.sendString(str);
    }

    public void connectToClient() {
        clientConnection = new Client();
    }

    public void connectToClient(int port) {
        clientConnection = new Client(port);
    }

    public void killClient() {
        clientConnection.terminate();
    }

    public void initializePlayers() {
        for (int i = 0; i < 3; i++) {
            players[i] = new Player(" ");
        }
    }

    /*
     * update turns
     */
    public void printPlayerScores(Player[] pl) {
        // print the score sheets

        if (playerId == 1) {
            game.printScoreSheet(pl[0]);
            game.printScoreSheet(pl[1]);
            game.printScoreSheet(pl[2]);
        } else if (playerId == 2) {
            game.printScoreSheet(pl[1]);
            game.printScoreSheet(pl[0]);
            game.printScoreSheet(pl[2]);
        } else {
            game.printScoreSheet(pl[2]);
            game.printScoreSheet(pl[0]);
            game.printScoreSheet(pl[1]);
        }
    }

    public void startGame() {
        // receive players once for names
        players = clientConnection.receivePlayer();
        while (true) {
            int round = clientConnection.receiveRoundNo();
            if (round == -1)
                break;
            System.out.println("\n \n \n ********Round Number " + round + "********");
            int[][] pl = clientConnection.receiveScores();
            for (int i = 0; i < 3; i++) {
                players[i].setScoreSheet(pl[i]);
            }
            printPlayerScores(players);
            int[] dieRoll = game.rollDice();
            String Fortune = game.getFortune();
            clientConnection.sendScores(playRound(dieRoll,Fortune));
        }
    }

    public void startoneGame() {
        // receive players once for names
        players = clientConnection.receivePlayer();
        int round = clientConnection.receiveRoundNo();
        //System.out.println("\n \n \n ********Round Number " + round + "********");
        int[][] pl = clientConnection.receiveScores();
        for (int i = 0; i < 3; i++) {
            players[i].setScoreSheet(pl[i]);
        }
        printPlayerScores(players);
        int[] dieRoll = game.rollDice();
        String F = game.getFortune();
        clientConnection.sendScores(playRound(dieRoll,F));
    }
    public Player returnWinner() {
        if (this.getScore()>=3000){
            for (int i = 0; i < 3; i++) {
                if (players[i].getName()!=this.getName()){
                    players[i].startoneGame();
                }
            }															//if one player has score above 3000, other player play one more round
        }
        try {                                             // After all finish, if one more player have more than 3000, heighest win
            int[][] pl = clientConnection.receiveScores();     //If no one above 3000, game contiune.
            for (int i = 0; i < 3; i++) {
                players[i].setScoreSheet(pl[i]);
            }
            printPlayerScores(players);
            Player win = (Player) clientConnection.dIn.readObject();
            if (playerId == win.playerId) {
                System.out.println("You win!");
            } else {
                System.out.println("The winner is " + win.name);
            }

            System.out.println("Game over!");
            return win;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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

    public String getName() {
        return name;
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
            scoreSheet[i] = 0;
        }
    }
    public Player getPlayer() {
        return this;
    }
    public static void main(String args[]) {


    }

}
