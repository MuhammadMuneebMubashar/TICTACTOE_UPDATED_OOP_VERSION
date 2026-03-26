package com.tictactoe;

import java.util.Scanner;

public class UserInput {
    private static Scanner input = new Scanner(System.in);


    public static GameMode gameModeInput(){
        System.out.println("Hello !");
        System.out.println("Let's start the game ! Choose game mode :");
        System.out.println("1. Player vs Player");
        System.out.println("2. Player vs AI");
        int gameMode;
        while (true){
            System.out.println(" >>>> : ");
            gameMode = input.nextInt();
            if (gameMode == 1 || gameMode == 2){
                input.next();
                return (gameMode == 1)
                        ? GameMode.Player_VS_Player:
                        GameMode.Player_VS_AI;
            }
        }

    }
    public static String playerNameInput(){
        String x = "";
        while (true){
            if (x.isBlank()){
                System.out.println("Enter your name : ");
                x = input.nextLine();
            }else {
                return x;
            }
        }
    }


    public static byte [] UserMoveInput(Board board){
        byte [] x = new byte[2];
        while (true){
            System.out.println("Enter Row and column : ");
            System.out.print("ROW >>> : ");
            x[0] = input.nextByte();
            System.out.print("COLUMN >>> : ");
            x[1] = input.nextByte();
            if (board.isPositionValid(x)){
                input.next();
                return x;
            }
            System.out.println("Consider possible moves !");
        }
    }

    public static String userNameInput(){
        String x = "";
        while (true){
            if (x.isBlank()){
                System.out.print("Please enter your name : ");
                x =  input.nextLine();
            }else{
                return x;
            }
        }
    }

    public static byte boardSizeInput(){
        byte x ;
        while (true){
            System.out.println("Enter board size between 3 - 20: ");
            x = input.nextByte();
            if (x >= 3 && x <= 20){
                input.next();
                return x;
            }
        }
    }

    public static byte newGameInput(){
        byte x;
        while (true){
            System.out.println("Do you want to play again ? (1 for yes, 0 for no) : ");
            x = input.nextByte();
            if (x == 1 ||x == 0){
                input.next();
                return x;
            }
        }
    }
    public static boolean newPlayerInput(){
        boolean x;
        while (true){
            System.out.println("Do you wanto change player ? true/false : ");
            if (input.hasNextBoolean()){
                x = input.nextBoolean();
                return x;
            }
        }
    }
}
