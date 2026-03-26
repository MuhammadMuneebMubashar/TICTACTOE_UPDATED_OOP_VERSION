package com.tictactoe;

import com.tictactoe.Assets.GameAssets;

public class RuleClass {

    private Symbol rowWinCheck(){
        boolean lineComp ;
        for (byte row = 0; row < GameAssets.board.getSize(); row++) {
            if (GameAssets.board.getBoard()[row][0] == null) {
                continue;
            }
            lineComp = false;
            for (byte col = 0; col < GameAssets.board.getSize() - 1; col++) {
                if (GameAssets.board.getBoard()[row][col] != GameAssets.board.getBoard()[row][col+1]) {
                    lineComp = false;
                    break;
                }
                lineComp = true;
            }
            if (lineComp) {
                return GameAssets.board.getBoard()[row][0];
            }
        }
        return null;
    }

    private Symbol colWinCheck(){

        boolean lineComp ;
        for (byte col = 0; col < GameAssets.board.getSize(); col++) {
            if (GameAssets.board.getBoard()[0][col] == null) {
                continue;
            }
            lineComp = false;
            for (byte row = 0; row < GameAssets.board.getSize() - 1; row++) {
                if (GameAssets.board.getBoard()[row][col] != GameAssets.board.getBoard()[row+1][col]) {
                    lineComp = false;
                    break;
                }
                lineComp = true;
            }
            if (lineComp) {
                return GameAssets.board.getBoard()[0][col];
            }
        }
        return null;
    }

    private Symbol rightDiagonalWinCheck(){
        if (GameAssets.board.getBoard()[0][0] == null){
            return null;
        }
        for (byte row = 0; row < GameAssets.board.getSize() - 1; row++) {
            if (GameAssets.board.getBoard()[row][row] != GameAssets.board.getBoard()[row+1][row+1]) {
                return null;
            }
        }
        return GameAssets.board.getBoard()[0][0];
    }

    private Symbol leftDiagonalWinCheck(){
        if (GameAssets.board.getBoard()[0][GameAssets.board.getSize()-1] == null){
            return null;
        }
        for (byte row = (byte) (GameAssets.board.getSize()-1); row > 0; row--) {
            if (GameAssets.board.getBoard()[GameAssets.board.getSize() - row - 1][row] != GameAssets.board.getBoard()[GameAssets.board.getSize() - row][row-1]) {
                return null;
            }
        }
        return GameAssets.board.getBoard()[GameAssets.board.getSize()-1][GameAssets.board.getSize()-1];
    }

    private Symbol winCheck(){
        Symbol check;
        check = rowWinCheck();
        if (check != null){
            return check;
        }
        check = colWinCheck();
        if (check != null){
            return check;
        }
        check = rightDiagonalWinCheck();
        if (check != null){
            return check;
        }
        check = leftDiagonalWinCheck();
        if (check != null){
            return check;
        }
        return null;
    }

    public GameWinnerStatus getGameWinner(){
        Symbol check = winCheck();
        if (check == null && GameAssets.board.isComplete()){
            return GameWinnerStatus.DRAW;
        }
        if (check == GameAssets.player.getSymbol()){
            return GameWinnerStatus.PLAYER1;
        }
        if (check == GameAssets.opponent.getSymbol()){
        return GameWinnerStatus.PLAYER2;
        }
        return GameWinnerStatus.IN_PROGRESS;
    }

}
