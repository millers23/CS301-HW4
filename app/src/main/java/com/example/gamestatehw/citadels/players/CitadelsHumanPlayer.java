package com.example.gamestatehw.citadels.players;

import android.graphics.Color;
import android.view.View;

import com.example.gamestatehw.GameFramework.actionMessage.BuildDistrictAction;
import com.example.gamestatehw.GameFramework.actionMessage.DrawCardAction;
import com.example.gamestatehw.GameFramework.actionMessage.DrawGoldAction;
import com.example.gamestatehw.GameFramework.actionMessage.EndTurnAction;
import com.example.gamestatehw.GameFramework.actionMessage.GameAction;
import com.example.gamestatehw.GameFramework.actionMessage.RemoveDistrictAction;
import com.example.gamestatehw.GameFramework.actionMessage.UseAbilityAction;
import com.example.gamestatehw.GameFramework.game.GameMainActivity;
import com.example.gamestatehw.GameFramework.infoMessage.GameInfo;
import com.example.gamestatehw.GameFramework.infoMessage.IllegalMoveInfo;
import com.example.gamestatehw.GameFramework.infoMessage.NotYourTurnInfo;
import com.example.gamestatehw.GameFramework.players.GameHumanPlayer;
import com.example.gamestatehw.GameFramework.utilities.Logger;
import com.example.gamestatehw.R;
import com.example.gamestatehw.citadels.infoMessage.CitadelsState;
import com.example.gamestatehw.citadels.views.CitadelsGameView;

public class CitadelsHumanPlayer extends GameHumanPlayer implements View.OnClickListener {
    //Tag for logging
    private static final String TAG = "CitadelsHumanPlayer";

    // the surface view
    private CitadelsGameView view;

    // the ID for the layout to use
    private int layoutId;

    /**
     * constructor
     *
     * @param name the name of the player
     */
    public CitadelsHumanPlayer(String name, int layoutID) {
        super(name);
        this.layoutId = layoutID;
    }

    @Override
    public void onClick(View v) {
        GameAction action = null;
        if (v.getId() == R.id.cardButton) {
            action = new DrawCardAction(this);
        }
        else if (v.getId() == R.id.goldButton) {
            action = new DrawGoldAction(this);
        }
        else if (v.getId() == R.id.buildButton) {
            action = new BuildDistrictAction(this);
        }
        else if (v.getId() == R.id.removeButton) {
            action = new RemoveDistrictAction(this);
        }
        else if (v.getId() == R.id.abilityButton) {
            action = new UseAbilityAction(this);
        }
        else if (v.getId() == R.id.endButton) {
            action = new EndTurnAction(this);
        }
        game.sendAction(action);
        v.invalidate();
    }

    @Override
    public View getTopView() {
        return null;
    }

    @Override
    public void receiveInfo(GameInfo info) {
        if (view == null) return;

        if (info instanceof IllegalMoveInfo || info instanceof NotYourTurnInfo) {
            // if the move was out of turn or otherwise illegal, flash the screen
            view.flash(Color.RED, 50);
        }
        else if (!(info instanceof CitadelsState))
            // if we do not have a TTTState, ignore
            return;
        else {
            view.setState((CitadelsState)info);
            view.invalidate();
            Logger.log(TAG, "receiving");
        }
    }

    @Override
    public void setAsGui(GameMainActivity activity) {

    }
}
