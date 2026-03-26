package com.tictactoe;

public class Player {

    private String playerName;
    private int draws;
    private int wins;
    private int losses;
    private int totalMatches;

    private Symbol symbol;

    public Player(String playerName, Symbol symbol) {
        this.playerName = playerName;
        this.symbol = symbol;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getDraws() {
        return draws;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getTotalMatches() {
        return totalMatches;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nName: ");
        sb.append(getPlayerName());
        sb.append("\nTotal Matches: ");
        sb.append(getTotalMatches());
        sb.append("\nDraws: ");
        sb.append(getDraws());
        sb.append("\nLosses: ");
        sb.append(getLosses());
        sb.append("\nWins: ");
        sb.append(getWins());
        sb.append("\n");
        return sb.toString();
    }

    private void incTotalMatches(){
        totalMatches++;
    }
    public void draw(){
        draws++;
        incTotalMatches();
    }
    public void win(){
        wins++;
        incTotalMatches();
    }
    public void loss(){
        losses++;
        incTotalMatches();
    }
    public void clearStats(){
        draws = 0;
        wins = 0;
        losses = 0;
        totalMatches = 0;
    }
}
