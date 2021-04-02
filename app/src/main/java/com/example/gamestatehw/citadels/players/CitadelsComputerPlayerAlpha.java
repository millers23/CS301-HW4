package com.example.gamestatehw.citadels.players;

import com.example.gamestatehw.GameFramework.infoMessage.GameInfo;
import com.example.gamestatehw.GameFramework.players.GameComputerPlayer;

public class CitadelsComputerPlayerAlpha extends GameComputerPlayer {
    /**
     * constructor
     *
     * @param name the player's name (e.g., "John")
     */
    public CitadelsComputerPlayerAlpha(String name) {
        super(name);
    }

    @Override
    protected void receiveInfo(GameInfo info) {
        //do some computations

        //sleep for a sec
        sleep(1);

        //game.sendAction();
    }
}
