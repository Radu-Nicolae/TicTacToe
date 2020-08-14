package ticTacToe.utilities;

public class Messages {

    public static void welcomeMessage(){
        System.out.println("=============================");
        System.out.println("|  Welcome to Tic Tac Toe!  |");
        System.out.println("=============================");
    }

    public static void computerChoice(){
        System.out.println("\n---------------------------------------");
        System.out.println("|  You have chosen to play with CPU!  |");
        System.out.println("---------------------------------------");
    }

    public static void chooseDificulty(){
        System.out.println("Choose game difficulty:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
    }

    public static void goodBye(){
        System.out.println("\n=======================================");
        System.out.println("|  Thank you for playing Tic Tac Toe  |");
        System.out.println("|           Have a nice day!          |");
        System.out.println("=======================================");
    }

}
