package com.tictactoe.GamePlay;

import com.tictactoe.*;
import com.tictactoe.Assets.GameAssets;

public class PVP {

    private static boolean IsgameEnd() {
        GameWinnerStatus status = GameAssets.Rule.getGameWinner(GameAssets.board);
        switch (status) {
            case GameWinnerStatus.PLAYER1:
                GameAssets.player.win();
                GameAssets.opponent.loss();
                GameUI.announceWinner(GameAssets.player);
                break;
            case GameWinnerStatus.PLAYER2:
                GameAssets.opponent.win();
                GameAssets.player.loss();
                GameUI.announceWinner(GameAssets.opponent);
                break;
            case GameWinnerStatus.DRAW:
                GameAssets.player.draw();
                GameAssets.opponent.draw();
                GameUI.matchDrawMsg();
                break;
            default:
                return false;
        }
        return true;
    }

    private static void startPlayers() {
        String name1 = UserInput.playerNameInput();
        String name2 = UserInput.playerNameInput();
        if (name1.equals(name2)) {
            name2+='I';
        }
        GameAssets.player = new Player(name1, Symbol.O);
        GameAssets.opponent = new Player(name2, Symbol.X);
    }

    private static void setStage() {
        GameUI.displayBoard(GameAssets.board);
        GameUI.displayPossibleMoves(GameAssets.board);
    }

    private static void player1Turn() {
        setStage();
        GameUI.player1Turn();
        byte[] move = UserInput.userMoveInput(GameAssets.board);
        GameAssets.board.setPosition(move, Symbol.O);
    }

    private static void opponentTurn() {
        setStage();
        GameUI.player2Turn();
        byte[] move = UserInput.userMoveInput(GameAssets.board);
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
