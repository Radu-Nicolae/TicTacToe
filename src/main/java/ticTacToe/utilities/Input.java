package ticTacToe.utilities;

import java.util.List;

public class Input {

    public static boolean isInputValid(List<Integer> playerInputs, List<Integer> cpuInputs, int input) {
        boolean isInputValid = false;

        if (input > 0 && input < 10) {
            if (!playerInputs.contains(input) && !cpuInputs.contains(input)) {
                isInputValid = true;
            }
        }

        return isInputValid;
    }
}
