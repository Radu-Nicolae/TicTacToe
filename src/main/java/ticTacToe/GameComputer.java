package ticTacToe;

import ticTacToe.utilities.*;

import java.util.*;

public class GameComputer {

    static Scanner scn = new Scanner(System.in);
    static Random rnd = new Random();

    public static void playWithCPU() {
        boolean isInputInvalid = true;
        boolean playerStartsFirst;
        boolean isGameNotOver = true;
        String input;
        String toBeConvertedInputDifficulty;
        int inputDifficulty;
        List<Boolean> booleans;

        Messages.computerChoice();

        Messages.chooseDificulty();
        System.out.print("\nYour answer: ");
        do {
            toBeConvertedInputDifficulty = scn.next();
            if (toBeConvertedInputDifficulty.equalsIgnoreCase("1") || toBeConvertedInputDifficulty.equalsIgnoreCase("2")
                    || toBeConvertedInputDifficulty.equalsIgnoreCase("3")) {
                isInputInvalid = false;
            } else {
                System.out.print("\nPlease enter a valid input!");
            }
        }
        while (isInputInvalid);
        inputDifficulty = Integer.parseInt(toBeConvertedInputDifficulty);

        switch (inputDifficulty) {
            case 1:
                System.out.println("\nYou have chosen easy mode!");
                break;
            case 2:
                System.out.println("\nYou have chosen medium mode!");
                break;
            case 3:
                System.out.println("\nYou have chosen hard mode!");
                break;
        }

        isInputInvalid = true;

        System.out.println("\n");
        Board.printBoard(Board.getBoardWithNumbers());
        System.out.println("During the game you will select numbers from 1 to 9 as shown above");

        System.out.println("\nSelect who starts: ");
        System.out.println("1. You");
        System.out.println("2. Computer");

        System.out.print("Your answer: ");

        do {
            input = scn.next();
            if (input.equalsIgnoreCase("1") || input.equalsIgnoreCase("2")) {
                isInputInvalid = false;
            } else {
                System.out.print("\nPlease enter a valid input: ");
            }
        }
        while (isInputInvalid);

        int playerInput;
        int cpuInput;
        ArrayList<Integer> playerInputs = new ArrayList<Integer>();
        ArrayList<Integer> cpuInputs = new ArrayList<Integer>();

        playerStartsFirst = input.equalsIgnoreCase("1");

        char[][] board = Board.getBoard();
        boolean isInputAvailable = false;
        boolean playAgain = false;
        char playerSymbol;

        do {
            System.out.println("\n");
            Board.printBoard(Board.getBoard());
            do {
                isInputInvalid = true;

                if (playerStartsFirst) {
                    System.out.print("\nYour turn: ");
                    playerSymbol = 'X';
                } else {
                    playerSymbol = '0';
                }

                if (playerStartsFirst) {
                    do {
                        if (playerStartsFirst) {
                            playerInput = scn.nextInt();
                            isInputAvailable = Input.isInputValid(playerInputs, cpuInputs, playerInput);

                            if (isInputAvailable) {
                                isInputInvalid = false;
                                playerInputs.add(playerInput);
                                board = Board.boardReplace(board, playerSymbol, playerInput);
                            } else {
                                System.out.print("Please enter a valid input: ");
                            }
                        }

                    }
                    while (isInputInvalid);
                    Board.printBoard(board);

                } else {
                    switch (inputDifficulty) {
                        case 1:
                            cpuInput = GameUtilities.easyMode(playerInputs, cpuInputs, board, isInputAvailable, playerSymbol);
                            board = Board.boardReplace(board, playerSymbol, cpuInput);
                            System.out.print("\nCPU's turn: " + cpuInput + "\n");
                            Board.printBoard(board);
                            break;
                        case 2:
                            cpuInput = GameUtilities.mediumMode(playerInputs, cpuInputs, board, isInputAvailable, playerSymbol);
                            board = Board.boardReplace(board, playerSymbol, cpuInput);
                            System.out.print("\nCPU's turn: " + cpuInput + "\n");
                            Board.printBoard(board);
                            break;
                        case 3:
                            cpuInput = GameUtilities.hardMode(playerInputs, cpuInputs, board, isInputAvailable, playerSymbol);
                            board = Board.boardReplace(board, playerSymbol, cpuInput);
                            System.out.print("\nCPU's turn: " + cpuInput + "\n");
                            Board.printBoard(board);
                            break;
                    }

                }

                playerStartsFirst = !playerStartsFirst;
                booleans = GameUtilities.isGameOver(playerInputs, cpuInputs);

                if (booleans.get(0)) { //if gameOver == true
                    if (booleans.get(1)) { //if didPlayerWon == true
                        System.out.println("Congrads! You won!");
                        isGameNotOver = false;
                    } else if (booleans.get(2)) { //if didCpuWon == true
                        System.out.println("CPU won :(");
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
                input = scn.next();
                if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")) {
                    isInputInvalid = false;
                } else {
                    System.out.print("Please enter a valid input: ");
                }
            }
            while (isInputInvalid);
            if (input.equalsIgnoreCase("yes")) {
                playAgain = true;
            } else {
                System.out.println("\nChange game difficulty?");
                System.out.print("Your answer: ");
                isInputInvalid = true;
                do {
                    input = scn.next();
                    if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")) {
                        isInputInvalid = false;
                    } else {
                        System.out.print("\nPlease enter a valid input: ");
                    }
                }
                while (isInputInvalid);
                isInputInvalid = true;

                if (input.equalsIgnoreCase("yes")) {
                    Messages.chooseDificulty();
                    System.out.print("\nYour answer: ");
                    do {
                        toBeConvertedInputDifficulty = scn.next();
                        if (toBeConvertedInputDifficulty.equalsIgnoreCase("1") || toBeConvertedInputDifficulty.equalsIgnoreCase("2")
                                || toBeConvertedInputDifficulty.equalsIgnoreCase("3")) {
                            isInputInvalid = false;
                        } else {
                            System.out.print("\nPlease enter a valid input!");
                        }
                    }
                    while (isInputInvalid);
                    inputDifficulty = Integer.parseInt(toBeConvertedInputDifficulty);

                    switch (inputDifficulty) {
                        case 1:
                            System.out.println("\nYou have chosen easy mode!");
                            playAgain = true;
                            break;
                        case 2:
                            System.out.println("\nYou have chosen medium mode!");
                            playAgain = true;
                            break;
                        case 3:
                            System.out.println("\nYou have chosen hard mode!");
                            playAgain = true;
                            break;
                    }
                } else {
                    playAgain = false;
                }
            }

            board = Board.getBoard();
            cpuInputs.clear();
            playerInputs.clear();
            isGameNotOver = true;
        }
        while (playAgain);


        Messages.goodBye();

    }
}
