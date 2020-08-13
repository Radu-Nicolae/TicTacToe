package ticTacToe.utilities;

import java.util.*;

public class GameUtilities {

    public static List<Boolean> isGameOver(List<Integer> playerInputs, List<Integer> cpuInputs) {
        boolean isGameOver = false;
        boolean didPlayerWon = false;
        boolean didCpuWon = false;
        boolean isADraw = false;


        for (List l : WinningNumbers.winningNumbers()) {
            if (playerInputs.containsAll(l)) {
                isGameOver = true;
                didPlayerWon = true;
            } else if (cpuInputs.containsAll(l)) {
                isGameOver = true;
                didCpuWon = true;
            } else if (cpuInputs.size() + playerInputs.size() == 9) {
                isGameOver = true;
                isADraw = true;
            }
        }

        List<Boolean> booleans = new ArrayList<Boolean>();
        booleans.add(isGameOver);
        booleans.add(didPlayerWon);
        booleans.add(didCpuWon);
        booleans.add(isADraw);

        return booleans;
    }

    static Random rnd = new Random();

    public static int easyMode(boolean isInputInvalid, List<Integer> playerInputs, List<Integer> cpuInputs, char[][] board, boolean isInputAvailable, char playerSymbol) {
        int cpuInput;
        do {
            cpuInput = rnd.nextInt(9) + 1;
            isInputAvailable = Input.isInputValid(playerInputs, cpuInputs, cpuInput);

            if (isInputAvailable) {
                isInputInvalid = false;
                cpuInputs.add(cpuInput);
                board = Board.boardReplace(board, playerSymbol, cpuInput);
            }
        }
        while (isInputInvalid);

        return cpuInput;
    }


    public static int mediumMode(boolean isInputInvalid, List<Integer> playerInputs, List<Integer> cpuInputs, char[][] board, boolean isInputAvailable, char playerSymbol) {
        int cpuInput;
        isInputInvalid = true;


        cpuInput = remainingInput(playerInputs, board);
        isInputAvailable = Input.isInputValid(playerInputs, cpuInputs, cpuInput);

        if (isInputAvailable) {
            isInputInvalid = false;
            cpuInputs.add(cpuInput);
            board = Board.boardReplace(board, playerSymbol, cpuInput);
        } else {
            do {
                cpuInput = rnd.nextInt(9) + 1;
                isInputAvailable = Input.isInputValid(playerInputs, cpuInputs, cpuInput);

                if (isInputAvailable) {
                    isInputInvalid = false;
                    cpuInputs.add(cpuInput);
                    board = Board.boardReplace(board, playerSymbol, cpuInput);
                }
            }
            while (isInputInvalid);
        }

        return cpuInput;

//        List<Integer> corners = new ArrayList<Integer>();
//        corners.add(1);
//        corners.add(3);
//        corners.add(7);
//        corners.add(9);
//
//        if (playerInputs.size() == 1){
//            if (playerInputs.get(0) !=  5){
//                cpuInput = 5;
//            }
//            else {
//                cpuInput = corners.get(rnd.nextInt(4) + 1);
//            }
//        }


    }

    


    public static int remainingInput(List<Integer> playerInputs, char[][] board) {
        int cpuInput = 0;


        if (playerInputs.contains(1)) {
            if (playerInputs.contains(2)) {
                if (board[0][9] == ' ') {
                    cpuInput = 3;
                }
            }
            if (playerInputs.contains(3)) {
                if (board[0][5] == ' ') {
                    cpuInput = 2;
                }
            }
            if (playerInputs.contains(5)) {
                if (board[4][9] == ' ') {
                    cpuInput = 9;
                }
            }
            if (playerInputs.contains(9)) {
                if (board[2][5] == ' ') {
                    cpuInput = 5;
                }
            }
            if (playerInputs.contains(4)) {
                if (board[4][1] == ' ') {
                    cpuInput = 7;
                }
            }
            if (playerInputs.contains(7)) {
                if (board[2][1] == ' ') {
                    cpuInput = 4;
                }
            }

            if (playerInputs.contains(2)) {
                if (playerInputs.contains(3)) {
                    if (board[0][1] == ' ') {
                        cpuInput = 1;
                    }
                }
                if (playerInputs.contains(5)) {
                    if (board[4][5] == ' ') {
                        cpuInput = 8;
                    }
                }
                if (playerInputs.contains(8)) {
                    if (board[2][5] == ' ') {
                        cpuInput = 5;
                    }
                }
            }

            if (playerInputs.contains(3)) {
                if (playerInputs.contains(5)) {
                    if (board[4][1] == ' ') {
                        cpuInput = 7;
                    }
                }
                if (playerInputs.contains(7)) {
                    if (board[2][5] == ' ') {
                        cpuInput = 5;
                    }
                }
                if (playerInputs.contains(6)) {
                    if (board[4][9] == ' ') {
                        cpuInput = 9;
                    }
                }
                if (playerInputs.contains(9)) {
                    if (board[2][9] == ' ') {
                        cpuInput = 6;
                    }
                }
            }

            if (playerInputs.contains(4)) {
                if (playerInputs.contains(7)) {
                    if (board[0][1] == ' ') {
                        cpuInput = 1;
                    }
                }
                if (playerInputs.contains(5)) {
                    if (playerInputs.contains(4)) {
                        if (board[2][9] == ' ') {
                            cpuInput = 6;
                        }
                    }
                }
                if (playerInputs.contains(6)) {
                    if (playerInputs.contains(4)) {
                        if (board[2][5] == ' ') {
                            cpuInput = 5;
                        }
                    }
                }
            }

            if (playerInputs.contains(5)) {
                if (playerInputs.contains(8)) {
                    if (board[0][5] == ' ') {
                        cpuInput = 2;
                    }
                }
                if (playerInputs.contains(9)) {
                    if (playerInputs.contains(5)) {
                        if (board[0][1] == ' ') {
                            cpuInput = 1;
                        }
                    }
                }
                if (playerInputs.contains(7)) {
                    if (playerInputs.contains(5)) {
                        if (board[0][9] == ' ') {
                            cpuInput = 3;
                        }
                    }
                }
                if (playerInputs.contains(6)) {
                    if (playerInputs.contains(5)) {
                        if (board[2][1] == ' ') {
                            cpuInput = 4;
                        }
                    }
                }
            }

            if (playerInputs.contains(6)) {
                if (playerInputs.contains(9)) {
                    cpuInput = 3;
                }
            }

            if (playerInputs.contains(7)) {
                if (playerInputs.contains(8)) {
                    if (board[4][9] == ' ') {
                        cpuInput = 9;
                    }
                }
                if (playerInputs.contains(9)) {
                    if (board[4][5] == ' ') {
                        cpuInput = 8;
                    }
                }
            }

            if (playerInputs.contains(8)) {
                if (playerInputs.contains(9)) {
                    if (board[4][1] == ' ') {
                        cpuInput = 7;
                    }
                }
            }


        }

        return cpuInput;
    }
}
