package com.tictactoe;
import com.tictactoe.GamePlay.*;
import com.tictactoe.Assets.GameAssets;

public class GameEngine {

    public void resetStage(){
        GameAssets.board = null;
    }

    public void playGame(){
        GameUI.welcomeMsg();
        GameMode mode;
        byte size;
        boolean newPlayer = true;
        GameAssets.Rule = new RuleClass();

        while (true){
            mode = UserInput.gameModeInput();
            size = UserInput.boardSizeInput();
            GameAssets.board = new Board(size);
            switch(mode){
                case GameMode.Player_VS_Player:
                    PVP.play(newPlayer);
                    break;
                case GameMode.Player_VS_AI:
//                    PVE.play(size);
                    break;
                default:
                    return;
            }
            if (UserInput.newGameInput() == 2){
                GameUI.thankYouMsg();
                return;
            }
            if (! UserInput.newPlayerInput()){
                newPlayer = false;
            }
        }
    }
}
