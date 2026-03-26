package com.tictactoe;

public class GameUI {


    public static void displayBoard(Board board){
        byte num;
        for (byte row = 0; row < board.getSize(); row++) {
            System.out.print(" | ");
            for (byte col = 0; col < board.getSize(); col++){
                num = board.getBoard()[row][col];
                if (num == 0){
                    System.out.print("   ");
                } else if (num == 1) {
                    System.out.print(" " + Symbol.O.toString()+ " ");
                } else {
                    System.out.print(" "+ Symbol.X.toString()+ " ");
                }
            }
            System.out.println(" | ");
        }
    }

    public static void welcomeMsg(){
        System.out.println("Welcome to TacToe Game !");
    }

    public static void gameOverMsg(){
        System.out.println("Game Over !");
    }

    public static void announceWinner(Player winner){
        System.out.println("Winner is \n" + winner.toString());
    }

    public static void displayPossibleMoves(Board board){
        System.out.println("POSSIBLE MOVES : ");
        for (byte [] arr : board.getPossibleMoves()){
            System.out.print(arr[0] + " ");
            System.out.println(arr[1]);
        }
    }

    public static void player1Turn(){
        System.out.println("Player 1 Turn ...... ");
    }

    public static void player2Turn(){
        System.out.println("Player 2 Turn ...... ");
    }

    public static void minimaxTurn(){
        System.out.println("Minimax Turn ...... ");
        System.out.println("Minimax is thinking ...... ");
    }

    public static void thankYouMsg(){
        System.out.println("Thanks for playing !");
    }
}
