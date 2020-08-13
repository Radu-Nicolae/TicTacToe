package ticTacToe;

import ticTacToe.utilities.Messages;
import ticTacToe.utilities.Players;

import java.util.List;

public class Game {

    public static void Game(){
        Messages.welcomeMessage();

        GameComputer.playWithCPU();
    }
}
