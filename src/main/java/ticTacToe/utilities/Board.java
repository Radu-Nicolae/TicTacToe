package ticTacToe.utilities;

public class Board {

    /*
            | X |
         ---+---+---
            |   |
         ---+---+---
            |   |
     */

    public static char[][] getBoard() {

        return new char[][]{
                {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' '},
                {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-'},
                {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' '},
                {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-'},
                {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' '},
        };
    }

    public static char[][] getBoardWithNumbers() {
        return new char[][]{
                {' ', '1', ' ', '|', ' ', '2', ' ', '|', ' ', '3'},
                {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-'},
                {' ', '4', ' ', '|', ' ', '5', ' ', '|', ' ', '6'},
                {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-'},
                {' ', '7', ' ', '|', ' ', '8', ' ', '|', ' ', '9'},
        };
    }

    public static void printBoard(char[][] board) {

        int boardLength = 10;
        int boardHeight = 5;

        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardLength; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }

        System.out.println("");
    }


    public static char[][] boardReplace(char[][] board, char symbol, int input) {

        switch (input) {
            case 1:
                board[0][1] = symbol;
                break;
            case 2:
                board[0][5] = symbol;
                break;
            case 3:
                board[0][9] = symbol;
                break;
            case 4:
                board[2][1] = symbol;
                break;
            case 5:
                board[2][5] = symbol;
                break;
            case 6:
                board[2][9] = symbol;
                break;
            case 7:
                board[4][1] = symbol;
                break;
            case 8:
                board[4][5] = symbol;
                break;
            case 9:
                board[4][9] = symbol;
                break;
        }

        return board;
    }
}
