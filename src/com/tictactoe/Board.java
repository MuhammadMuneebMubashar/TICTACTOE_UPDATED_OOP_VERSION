package com.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {

    public static byte minBoardSize = 3;
    public static byte maxBoardSize = 20;

    private byte size;
    private ArrayList<byte[]> possibleMoves ;
    private byte [] [] board;

    public Board(byte size) {
        this.size = size;
        generateBoard(size);
        setPossibleMoves(size);
    }

    public boolean isPositionValid(byte [] position){
        if (possibleMoves.isEmpty()){
            return false;
        }

        for (byte [] b : possibleMoves) {
            if (Arrays.equals(b, position)) {
                return true;
            }
        }
       return false;
    }

    private void generateBoard(byte size){
        board = new byte[size][size];
    }

    private void setPossibleMoves(byte size){
        possibleMoves = new ArrayList<>(size * size);
        for (byte row = 0; row < size; row++) {
            for (byte col = 0; col < size; col++) {
                possibleMoves.add(new byte[] {row, col});
            }
        }
    }

    public byte getSize() {
        return size;
    }

    public ArrayList<byte[]> getPossibleMoves() {
        return possibleMoves;
    }

    public byte[][] getBoard() {
        return board;
    }

    public void setPosition(byte [] position, Symbol symbol) {
        isPositionValid(position);
        board[position[0]][position[1]] = (byte) ((symbol == Symbol.O) ? 1 : 2);
        deletePossiblePosition(position);
    }

    private void deletePossiblePosition(byte [] position) {
       for (int i = 0; i < possibleMoves.size(); i++) {
           if (Arrays.equals(possibleMoves.get(i), position)) {
               possibleMoves.remove(possibleMoves.get(i));
           }
       }
    }

    public boolean isComplete(){
        return (possibleMoves.isEmpty());
    }
}
