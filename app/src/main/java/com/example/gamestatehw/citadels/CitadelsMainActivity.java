package com.example.gamestatehw.citadels;

import android.content.pm.ActivityInfo;

import com.example.gamestatehw.GameFramework.game.GameMainActivity;
import com.example.gamestatehw.GameFramework.game.LocalGame;
import com.example.gamestatehw.GameFramework.gameConfiguration.GameConfig;
import com.example.gamestatehw.GameFramework.gameConfiguration.GamePlayerType;
import com.example.gamestatehw.GameFramework.infoMessage.GameState;
import com.example.gamestatehw.GameFramework.players.GamePlayer;
import com.example.gamestatehw.GameFramework.utilities.Logger;
//import com.example.gamestatehw.GameFramework.utilities.Saving;
import com.example.gamestatehw.R;
import com.example.gamestatehw.citadels.infoMessage.CitadelsState;
import com.example.gamestatehw.citadels.players.CitadelsComputerPlayerAlpha;
import com.example.gamestatehw.citadels.players.CitadelsHumanPlayer;

import java.util.ArrayList;

public class CitadelsMainActivity extends GameMainActivity {
    //Tag for logging
    private static final String TAG = "CitadelsMainActivity";
    public static final int PORT_NUMBER = 5213;

    /**
     * a tic-tac-toe game is for two players. The default is human vs. computer
     */
    @Override
    public GameConfig createDefaultConfig() {

        // Define the allowed player types
        ArrayList<GamePlayerType> playerTypes = new ArrayList<GamePlayerType>();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        // yellow-on-blue GUI
        playerTypes.add(new GamePlayerType("Local Human Player (blue-yellow)") {
            public GamePlayer createPlayer(String name) {
                return new CitadelsHumanPlayer(name, R.layout.cit_human_player);
            }
        });


        // dumb computer player
        playerTypes.add(new GamePlayerType("Computer Player (dumb)") {
            public GamePlayer createPlayer(String name) {
                return new CitadelsComputerPlayerAlpha(name);
            }
        });

        // smarter computer player
        playerTypes.add(new GamePlayerType("Computer Player (smart)") {
            public GamePlayer createPlayer(String name) {
                return new CitadelsComputerPlayerAlpha(name);
            }
        });


        // Create a game configuration class for Tic-tac-toe
        GameConfig defaultConfig = new GameConfig(playerTypes, 1,8, "Citadels", PORT_NUMBER);

        // Add the default players
        defaultConfig.addPlayer("Human", 0); // yellow-on-blue GUI
        defaultConfig.addPlayer("Computer", 3); // dumb computer player

        // Set the initial information for the remote player
        defaultConfig.setRemoteData("Remote Player", "", 1); // red-on-yellow GUI

        //done!
        return defaultConfig;

    }//createDefaultConfig

    /**
     * createLocalGame
     *
     * Creates a new game that runs on the server tablet,
     * @param gameState
     * 				the gameState for this game or null for a new game
     *
     * @return a new, game-specific instance of a sub-class of the LocalGame
     *         class.
     */
    @Override
    public LocalGame createLocalGame(GameState gameState) {
        if(gameState == null)
            return new CitadelsLocalGame();
        return new CitadelsLocalGame((CitadelsState) gameState);
    }

    /**
     * saveGame, adds this games prepend to the filename
     *
     * @param gameName
     * 				Desired save name
     * @return String representation of the save
     */
    @Override
    public GameState saveGame(String gameName) {
        return super.saveGame(getGameString(gameName));
    }

    /**
     * loadGame, adds this games prepend to the desire file to open and creates the game specific state
     * @param gameName
     * 				The file to open
     * @return The loaded GameState
     */
    @Override
    public CitadelsState loadGame(String gameName){
        String appName = getGameString(gameName);
        super.loadGame(appName);
        Logger.log(TAG, "Loading: " + gameName);
        //return (GameState) new CitadelsState((CitadelsState) Saving.readFromFile(appName, this.getApplicationContext()));
        return null;
    }
}