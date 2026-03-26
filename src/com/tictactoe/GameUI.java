package com.tictactoe;

import com.tictactoe.Assets.GameAssets;

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

    public static void matchDrawMsg(){
        System.out.println("Match draw !");
    }

    public static void announceWinner(Player winner){
        System.out.printf("Winner is : %s%n%s",
                winner.getSymbol()
                , winner.toString());
    }

    public static void displayPossibleMoves(Board board){
        System.out.println("POSSIBLE MOVES : ");
        for (byte [] arr : board.getPossibleMoves()){
            System.out.print(arr[0] + " ");
            System.out.println(arr[1]);
        }
    }

    public static void player1Turn(){
        System.out.printf("%s Turn ...... %s%n" ,
                GameAssets.player.getPlayerName(),
                GameAssets.player.getSymbol().toString());
    }

    public static void player2Turn(){
        System.out.printf("%s Turn ...... %s%n" ,
                GameAssets.opponent.getPlayerName(),
                GameAssets.opponent.getSymbol().toString());
    }

    public static void thankYouMsg(){
        System.out.println("Thanks for playing !");
    }
}
