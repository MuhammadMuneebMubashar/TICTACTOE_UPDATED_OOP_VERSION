package com.tictactoe.GamePlay;

import com.tictactoe.*;
import com.tictactoe.Assets.GameAssets;

public class PVP {

    private static boolean IsgameEnd() {
        GameWinnerStatus status = GameAssets.Rule.getGameWinner(GameAssets.board);
        switch (status) {
            case GameWinnerStatus.PLAYER1:
                GameUI.announceWinner(GameAssets.player);
                break;
            case GameWinnerStatus.PLAYER2:
                GameUI.announceWinner(GameAssets.opponent);
                break;
            case GameWinnerStatus.DRAW:
                GameUI.gameOverMsg();
                break;
            default:
                return false;
        }
        return true;
    }

    private static void startPlayers() {
        String name = UserInput.userNameInput();
        GameAssets.player = new Player(name, Symbol.O);
        name = UserInput.userNameInput();
        GameAssets.opponent = new Player(name, Symbol.X);
    }

    private static void setStage() {
        GameUI.displayBoard(GameAssets.board);
        GameUI.displayPossibleMoves(GameAssets.board);
    }

    private static void player1Turn() {
        setStage();
        GameUI.player1Turn();
        byte[] move = UserInput.UserMoveInput(GameAssets.board);
        GameAssets.board.setPosition(move, Symbol.O);
    }

    private static void opponentTurn() {
        setStage();
        GameUI.player2Turn();
        byte[] move = UserInput.UserMoveInput(GameAssets.board);
        GameAssets.board.setPosition(move, Symbol.X);
    }

    public static void play(boolean newPlayers) {
        if (newPlayers) {
            startPlayers();
        }
        while (true) {
            player1Turn();
            if (IsgameEnd()) {
                return;
            }
            opponentTurn();
            if (IsgameEnd()) {
                return;
            }
        }
    }
}
