package com.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {


    private static final  Scanner input = new Scanner(System.in);
    private static final byte opt1 = 1;
    private static final byte opt2 = 2;

    /**
     * Prompts the player to choose a game mode.
     *
     * @return selected {@link GameMode}
     */
    public static GameMode gameModeInput(){
        System.out.println("Hello !");
        System.out.println("Let's start the game !");
        System.out.println("1. Player vs Player");
        System.out.println("2. Player vs AI");
        int gameMode = 0;
        do {
            System.out.println(" >>>> : ");
            gameMode = numberInput();
        } while (gameMode != opt1 && gameMode != opt2);
        return (gameMode == opt1)
                ? GameMode.Player_VS_Player:
                GameMode.Player_VS_AI;
    }

    /**
     * Prompts the player to enter a non-blank name.
     *
     * @return validated player name
     */
    public static String playerNameInput(){
        String x = "";
        do{
            System.out.print("Hey champ ! Enter your name : ");
            x = input.nextLine().trim();
        }while (x.isBlank());
        return x;
    }

    /**
     * Prompts for a valid board position (row and column).
     *
     * @param board current game board used for position validation
     * @return array containing row and column indexes
     */
    public static byte [] userMoveInput(Board board){
        byte [] x = {-1 , -1};
        do {
            System.out.println("Enter Row and column : ");
            System.out.print("ROW >>> : ");
            x[0] = numberInput();
            System.out.print("COLUMN >>> : ");
            x[1] =  numberInput();
        } while (! board.isPositionValid(x));

        return x;
    }

    /**
     * Prompts for a board size within allowed limits.
     *
     * @return validated board size
     */
    public static byte boardSizeInput(){
        byte x = 0;
        do {
            System.out.printf("Enter board size between : %d - %d%n",
                    Board.minBoardSize, Board.maxBoardSize);
            x = numberInput();
        } while (x < Board.minBoardSize || x > Board.maxBoardSize);
        return x;
    }

    /**
     * Asks whether a new game should start.
     *
     * @return 1 for yes, 2 for no
     */
    public static byte newGameInput(){
        byte x = 0;
        do{
            System.out.println("Do you want to play again ? (1 for yes, 2 for no) : ");
            x = numberInput();
        } while (x!= opt1 && x != opt2);
        return x;
    }

    /**
     * Asks whether players should be changed before the next game.
     *
     * @return {@code true} if players should be changed, otherwise {@code false}
     */
    public static boolean newPlayerInput(){
        byte x = 0;
        do {
            System.out.println("Do you wanto change player ? 1 . Yes\n 2 . No\n: ");
             x = numberInput();
        } while (x != opt1 && x != opt2);
        return x == opt1;
    }

    /**
     * Reads a numeric value as a byte from input.
     *
     * @return entered number, or {@code -1} when input is invalid
     */
    private static byte numberInput(){
        byte x = -1;
        try{
            x = input.nextByte();
        }catch (InputMismatchException e){
            System.out.println("Wrong input");
        }
        // Consume the remaining input buffer (including invalid tokens).
        input.nextLine();
        return x;
    }
}
