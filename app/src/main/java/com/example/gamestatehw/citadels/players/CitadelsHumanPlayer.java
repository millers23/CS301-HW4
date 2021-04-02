package com.example.gamestatehw.citadels.players;

import android.view.View;

import com.example.gamestatehw.GameFramework.game.GameMainActivity;
import com.example.gamestatehw.GameFramework.infoMessage.GameInfo;
import com.example.gamestatehw.GameFramework.players.GameHumanPlayer;

public class CitadelsHumanPlayer extends GameHumanPlayer implements View.OnClickListener  {
    /**
     * constructor
     *
     * @param name the name of the player
     */
    public CitadelsHumanPlayer(String name) {
        super(name);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public View getTopView() {
        return null;
    }

    @Override
    public void receiveInfo(GameInfo info) {

    }

    @Override
    public void setAsGui(GameMainActivity activity) {

    }
}
