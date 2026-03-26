package com.tictactoe;

public class RuleClass {

    private byte rowWinCheck(Board board){
        boolean lineComp ;
        for (byte row = 0; row < board.getSize(); row++) {
            if (board.getBoard()[row][0] == 0) {
                continue;
            }
            lineComp = false;
            for (byte col = 0; col < board.getSize() - 1; col++) {
                if (board.getBoard()[row][col] != board.getBoard()[row][col+1]) {
                    lineComp = false;
                    break;
                }
                lineComp = true;
            }
            if (lineComp) {
                return board.getBoard()[row][0];
            }
        }
        return 0;
    }

    private byte colWinCheck(Board board){

        boolean lineComp ;
        for (byte col = 0; col < board.getSize(); col++) {
            if (board.getBoard()[0][col] == 0) {
                continue;
            }
            lineComp = false;
            for (byte row = 0; row < board.getSize() - 1; row++) {
                if (board.getBoard()[row][col] != board.getBoard()[row+1][col]) {
                    lineComp = false;
                    break;
                }
                lineComp = true;
            }
            if (lineComp) {
                return board.getBoard()[0][col];
            }
        }
        return 0;
    }

    private byte rightDiagonalWinCheck(Board board){
        if (board.getBoard()[0][0] == 0){
            return 0;
        }
        for (byte row = 0; row < board.getSize() - 1; row++) {
            if (board.getBoard()[row][row] != board.getBoard()[row+1][row+1]) {
                return 0;
            }
        }
        return board.getBoard()[0][0];
    }

    private byte leftDiagonalWinCheck(Board board){
        if (board.getBoard()[0][board.getSize()-1] == 0){
            return 0;
        }
        for (byte row = (byte) (board.getSize()-1); row > 0; row--) {
            if (board.getBoard()[board.getSize() - row - 1][row] != board.getBoard()[board.getSize() - row][row-1]) {
                return 0;
            }
        }
        return board.getBoard()[board.getSize()-1][board.getSize()-1];
    }

    private byte winCheck(Board board){
        byte check;
        check = rowWinCheck(board);
        if (check != 0){
            return check;
        }
        check = colWinCheck(board);
        if (check != 0){
            return check;
        }
        check = rightDiagonalWinCheck(board);
        if (check != 0){
            return check;
        }
        check = leftDiagonalWinCheck(board);
        if (check != 0){
            return check;
        }
        return 0;
    }

    public GameWinnerStatus getGameWinner(Board board){
        if (board.isComplete()){
            byte check = winCheck(board);
            if (check == 0){
                return GameWinnerStatus.DRAW;
            }
            if (check == 1){
                return GameWinnerStatus.PLAYER1;
            }
            return GameWinnerStatus.PLAYER2;
        }
        return GameWinnerStatus.IN_PROGRESS;
    }
}
