package ticTacToe.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GameUtilities {

    public static List<Boolean> isGameOver(List<Integer> playerInputs, List<Integer> cpuInputs){
        boolean isGameOver = false;
        boolean didPlayerWon = false;
        boolean didCpuWon = false;
        boolean isADraw = false;


        for (List l : WinningNumbers.winningNumbers()){
            if (playerInputs.containsAll(l)){
                isGameOver = true;
                didPlayerWon = true;
            }
            else if (cpuInputs.containsAll(l)){
                isGameOver = true;
                didCpuWon = true;
            }
            else if (cpuInputs.size() + playerInputs.size() == 9) {
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

    public static int easyMode(boolean isInputInvalid, List<Integer> playerInputs, List<Integer> cpuInputs, char[][]board, boolean isInputAvailable, char playerSymbol){
        int cpuInput;
        do {
            cpuInput = rnd.nextInt(9) + 1;
            isInputAvailable = Input.isInputValid(playerInputs, cpuInputs, cpuInput);

            if (isInputAvailable){
                isInputInvalid = false;
                cpuInputs.add(cpuInput);
                board = Board.boardReplace(board, playerSymbol, cpuInput);
            }
        }
        while (isInputInvalid);

        return cpuInput;
    }

}
