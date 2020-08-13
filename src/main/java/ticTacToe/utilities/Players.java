package ticTacToe.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Players {

    static Scanner scn = new Scanner(System.in);

    public static List<String> getPLayers() {
        List<String> players = new ArrayList<String>();
        String player1;
        String player2;

        System.out.println("\nPLease enter your names!");
        System.out.print("Player 1: ");
        player1 = scn.next();

        System.out.print("\nPlayer 2: ");
        player2 = scn.next();

        players.add(player1);
        players.add(player2);

        return players;
    }


    public static String getPlayer(){
        String player;

        System.out.print("Please enter your name: ");
        player = scn.next();

        return player;
    }
}
