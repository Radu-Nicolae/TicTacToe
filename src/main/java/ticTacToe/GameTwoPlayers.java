package ticTacToe;

import ticTacToe.utilities.Board;
import ticTacToe.utilities.GameUtilities;
import ticTacToe.utilities.Input;
import ticTacToe.utilities.Messages;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameTwoPlayers {

    static Scanner scn = new Scanner(System.in);

    public static void playWithFriend() {
        String player1;
        String player2;
        List<Integer> player1Inputs = new ArrayList<Integer>();
        List<Integer> player2Inputs = new ArrayList<Integer>();
        List<Boolean> booleans;
        String whoStartsFirst;
        boolean player1Starts;
        boolean isInputInvalid = true;
        int input;
        String inputString;
        boolean isGameNotOver = true;
        boolean playAgain;
        char player1Symbol = '0';
        char player2Symbol = '0';

        Messages.playersChoice();

        System.out.print("\nEnter player's 1 name: ");
        player1 = scn.nextLine();
        System.out.print("\nEnter player's 2 name: ");
        player2 = scn.nextLine();

        System.out.print("\n\nSelect who starts first: ");
        do {
            whoStartsFirst = scn.nextLine();
            if (whoStartsFirst.equalsIgnoreCase(player1) || whoStartsFirst.equalsIgnoreCase(player2)) {
                isInputInvalid = false;
            } else {
                System.out.print("\nPlease enter one of your names: ");
            }
        }
        while (isInputInvalid);

        if (whoStartsFirst.equalsIgnoreCase(player1)) {
            player1Symbol = 'X';
        } else {
            player2Symbol = '0';
        }

        player1Starts = whoStartsFirst.equalsIgnoreCase(player1);

        System.out.println("\n");
        Board.printBoard(Board.getBoardWithNumbers());
        System.out.println("During the game you will select a number from one to 9 as shown above.");
        char[][] board = Board.getBoard();

        do {
            do {
                isInputInvalid = true;
                if (player1Starts) {
                    System.out.print(player1 + "'s turn: ");
                    do {
                        input = scn.nextInt();
                        if (Input.isInputValid(player1Inputs, player2Inputs, input)) {
                            isInputInvalid = false;
                        } else {
                            System.out.print("\nPlease enter a valid input: ");
                        }
                    }
                    while (isInputInvalid);

                    player1Inputs.add(input);
                    board = Board.boardReplace(board, player1Symbol, input);
                } else {
                    System.out.print(player2 + "'s turn: ");
                    do {
                        input = scn.nextInt();
                        if (Input.isInputValid(player1Inputs, player2Inputs, input)) {
                            isInputInvalid = false;
                        } else {
                            System.out.print("\nPlease enter a valid input: ");
                        }
                    }
                    while (isInputInvalid);
                    player2Inputs.add(input);
                    board = Board.boardReplace(board, player2Symbol, input);
                }

                Board.printBoard(board);


                player1Starts = !player1Starts;
                booleans = GameUtilities.isGameOver(player1Inputs, player2Inputs);

                if (booleans.get(0)) { //if gameOver == true
                    if (booleans.get(1)) { //if didPlayerWon == true
                        System.out.println("Congrads! " + player1 + " won the game!");
                        isGameNotOver = false;
                    } else if (booleans.get(2)) { //if didCpuWon == true
                        System.out.println("Congrads! " + player2 + " won the game!");
                        isGameNotOver = false;
                    } else { //if it's a draw
                        System.out.println("It's a draw!");
                        isGameNotOver = false;
                    }
                }
            }
            while (isGameNotOver);

            isInputInvalid = true;
            System.out.println("\nPlay again?");
            System.out.print("Your answer: ");

            do {
                inputString = scn.next();
                if (inputString.equalsIgnoreCase("yes") || inputString.equalsIgnoreCase("no")) {
                    isInputInvalid = false;
                } else {
                    System.out.print("Please enter a valid input: ");
                }
            }
            while (isInputInvalid);
            playAgain = inputString.equalsIgnoreCase("yes");

            board = Board.getBoard();
            player1Inputs.clear();
            player2Inputs.clear();
            isGameNotOver = true;
        }
        while (playAgain);

        Messages.goodBye();
    }
}
