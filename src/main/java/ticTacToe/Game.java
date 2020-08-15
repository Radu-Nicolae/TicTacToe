package ticTacToe;

import ticTacToe.utilities.Messages;

import java.util.Scanner;

public class Game {

    static Scanner scn = new Scanner(System.in);

    public static void playGame() {
        String input;
        boolean isInputIncorrect = true;

        Messages.welcomeMessage();
        Messages.againstWho();
        System.out.print("Your answer: ");

        do {
            input = scn.next();
            if (input.equalsIgnoreCase("1") || input.equalsIgnoreCase("2")) {
                isInputIncorrect = false;
            } else {
                System.out.print("Please enter a valid input: ");
            }
        }
        while (isInputIncorrect);

        if (input.equalsIgnoreCase("1")) {
            GameTwoPlayers.playWithFriend();
        } else {
            GameComputer.playWithCPU();
        }
    }
}
