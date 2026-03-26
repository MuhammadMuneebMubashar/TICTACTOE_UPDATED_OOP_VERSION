package com.tictactoe;

public class Player {

    protected String playerName;
    protected int draws;
    protected int wins;
    protected int losses;
    protected int totalMatches;
    protected boolean turn;

    protected Symbol symbol;

    public Player(String playerName, Symbol symbol) {
        if (playerName.isBlank()){
            this.playerName = "Anonymous";
        }else{
            this.playerName = playerName;
        }
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
        return sb.toString();
    }

    public void draw(){
        draws++;
    }
    public void win(){
        wins++;
    }
    public void loss(){
        losses++;
    }
    public void clearStats(){
        draws = 0;
        wins = 0;
        losses = 0;
    }
}
