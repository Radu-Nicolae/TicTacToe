package ticTacToe.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumbers {

    public static List<List> winningNumbers() {
        List<List> winningNumbers = new ArrayList<List>();

        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> botRow = Arrays.asList(7, 8, 9);

        List<Integer> leftCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList(2, 5, 8);


        List<Integer> cross1 = Arrays.asList(1, 5, 9);
        List<Integer> cross2 = Arrays.asList(3, 5, 7);

        winningNumbers.add(topRow);
        winningNumbers.add(midRow);
        winningNumbers.add(botRow);
        winningNumbers.add(leftCol);
        winningNumbers.add(midCol);
        winningNumbers.add(cross1);
        winningNumbers.add(cross2);

        return winningNumbers;
    }
}
