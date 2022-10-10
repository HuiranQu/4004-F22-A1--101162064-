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


    public static void main(String args[]) {


    }

}
