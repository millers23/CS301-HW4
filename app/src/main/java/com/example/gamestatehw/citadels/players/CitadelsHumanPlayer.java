package com.example.gamestatehw.citadels.players;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;

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

    private ImageView selectedCard;

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

    public ImageView getSelectedCard() {
        return selectedCard;
    }

    public void setSelectedCard(ImageView selectedCard) {
        this.selectedCard = selectedCard;
    }

    @Override
    public void onClick(View v) {
        //selects a card from the deck that is available
        ImageView imageView = searchImageView(v);
        if (imageView.getVisibility() == View.VISIBLE &&
                imageView != null) {
            selectedCard = imageView;
        }

        //returns the correct game action for what button is pressed
        game.sendAction(searchGameAction(v));

        //resets the view
        v.invalidate();
    }

    private GameAction searchGameAction(View v) {
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
        return action;
    }

    private ImageView searchImageView(View v) {
        ImageView imageView = null;
        if (v.getId() == R.id.hand1) {
            imageView = v.findViewById(R.id.hand1);
        }
        else if (v.getId() == R.id.hand2) {
            imageView = v.findViewById(R.id.hand2);
        }
        else if (v.getId() == R.id.hand3) {
            imageView = v.findViewById(R.id.hand3);
        }
        else if (v.getId() == R.id.hand4) {
            imageView = v.findViewById(R.id.hand4);
        }
        else if (v.getId() == R.id.hand5) {
            imageView = v.findViewById(R.id.hand5);
        }
        else if (v.getId() == R.id.hand6) {
            imageView = v.findViewById(R.id.hand6);
        }
        else if (v.getId() == R.id.hand6) {
            imageView = v.findViewById(R.id.hand7);
        }
        else if (v.getId() == R.id.hand8) {
            imageView = v.findViewById(R.id.hand8);
        }
        return imageView;
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
