package ticTacToe;

import ticTacToe.utilities.*;

import java.util.*;

public class GameComputer {

    static Scanner scn = new Scanner(System.in);
    static Random rnd = new Random();

    public static void playWithCPU(){
        boolean isInputInvalid = true;
        boolean playerStartsFirst;
        boolean isGameNotOver = true;
        String input;
        List<Boolean> booleans;

        Messages.computerChoice();

        System.out.println("\n");
        Board.printBoard(Board.getBoardWithNumbers());
        System.out.println("During the game you will select numbers from 1 to 9 as shown above");

        System.out.println("\n Select who starts: ");
        System.out.println("1. You");
        System.out.println("2. Computer");

        System.out.print("Your answer: ");

        do {
            input = scn.nextLine();
            if (input.equalsIgnoreCase("1") || input.equalsIgnoreCase("2")){
                isInputInvalid = false;
            }
            else {
                System.out.print("Please enter a valid input: ");
            }
        }
        while (isInputInvalid);

        isInputInvalid = true;
        boolean isGameOver = true;
        int playerInput;
        int cpuInput;
        ArrayList<Integer> playerInputs = new ArrayList<Integer>();
        ArrayList<Integer> cpuInputs = new ArrayList<Integer>();

        playerStartsFirst = input.equalsIgnoreCase("1");

        char[][] board = Board.getBoard();
        boolean isInputAvailable = false;
        char playerSymbol;

        do {
            isInputInvalid = true;

            if (playerStartsFirst){
                System.out.print("\nYour turn: ");
                playerSymbol = 'X';
            }
            else {
                playerSymbol = '0';
            }

            if (playerStartsFirst){
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
                isInputInvalid = true;
                Board.printBoard(board);

            }
            else {
                cpuInput = GameUtilities.easyMode(isInputInvalid,playerInputs,cpuInputs,board,isInputAvailable,playerSymbol);
                board = Board.boardReplace(board, playerSymbol, cpuInput);
                System.out.print("\nCPU's turn: " + cpuInput + "\n");
                Board.printBoard(board);
            }

            playerStartsFirst = !playerStartsFirst;
            booleans = GameUtilities.isGameOver(playerInputs, cpuInputs);

            if (booleans.get(0)){ //if gameOver == true
                if (booleans.get(1)){ //if didPlayerWon == true
                    System.out.println("Congrads! You won!");
                    isGameNotOver = false;
                }
                else if (booleans.get(2)){ //if didCpuWon == true
                    System.out.println("CPU won :(");
                    isGameNotOver = false;
                }
                else { //if it's a draw
                    System.out.println("It's a draw!");
                    isGameNotOver = false;
                }
            }

        }
        while (isGameNotOver);



    }
}
