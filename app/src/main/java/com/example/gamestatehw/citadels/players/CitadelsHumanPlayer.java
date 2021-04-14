package com.example.gamestatehw.citadels.players;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
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
import com.example.gamestatehw.citadels.cards.Card;
import com.example.gamestatehw.citadels.cards.DistrictCard;
import com.example.gamestatehw.citadels.infoMessage.CitadelsState;
import com.example.gamestatehw.citadels.views.CitadelsGameView;

public class CitadelsHumanPlayer extends GameHumanPlayer implements View.OnClickListener {
    //Tag for logging
    private static final String TAG = "CitadelsHumanPlayer";

    // the surface view
    private CitadelsGameView view;

    private int selectedCard;

    // the ID for the layout to use
    private int layoutId;

    private CitadelsState state;
    /**
     * constructor
     *
     * @param name the name of the player
     */
    public CitadelsHumanPlayer(String name, int layoutID) {
        super(name);
        this.layoutId = layoutID;
    }

    public int getSelectedCard() {
        return selectedCard;
    }

    public void setSelectedCard(int selectedCard) {
        this.selectedCard = selectedCard;
    }

    @Override
    public void onClick(View v) {
        if(searchImageView(v) != -1){
            selectedCard = searchImageView(v);
        }
        else if (v.getId() == R.id.endButton) {
            GameAction action = new EndTurnAction(this);
            game.sendAction(action);
        }
        else if (v.getId() == R.id.goldButton) {
            GameAction action = new DrawGoldAction(this);
            game.sendAction(action);
        }
        else if (v.getId() == R.id.cardButton) {
            GameAction action = new DrawCardAction(this);
            game.sendAction(action);
        }
        else if (v.getId() == R.id.abilityButton) {
            GameAction action = new UseAbilityAction(this);
            game.sendAction(action);
        }
        else if (v.getId() == R.id.buildButton) {
            DistrictCard cardToPlay = (DistrictCard)state.getPlayers().get(state.getWhoseMove()).getHand().get(selectedCard);
            game.sendAction(new BuildDistrictAction(this, cardToPlay));
        }
        else if (v.getId() == R.id.removeButton) {
            DistrictCard cardToPlay = (DistrictCard)state.getPlayers().get(state.getWhoseMove()).getHand().get(selectedCard);
            game.sendAction(new RemoveDistrictAction(this, cardToPlay));
        }
        //selects a card from the deck that is available
        //selectedCard = searchImageView(v);

        //returns the correct game action for what button is pressed
        //game.sendAction(searchGameAction(v));

        //resets the view
        v.invalidate();
    }

    private int searchImageView(View v) {
        ImageView imageView = null;
        if (v.getId() == R.id.hand1) {
            imageView = v.findViewById(R.id.hand1);
            if (imageView.getVisibility() == View.VISIBLE) {
                return 0;
            }
            return -1;
        }
        else if (v.getId() == R.id.hand2) {
            if (imageView.getVisibility() == View.VISIBLE) {
                return 1;
            }
            return -1;
        }
        else if (v.getId() == R.id.hand3) {
            if (imageView.getVisibility() == View.VISIBLE) {
                return 2;
            }
            return -1;
        }
        else if (v.getId() == R.id.hand4) {
            if (imageView.getVisibility() == View.VISIBLE) {
                return 3;
            }
            return -1;
        }
        else if (v.getId() == R.id.hand5) {
            if (imageView.getVisibility() == View.VISIBLE) {
                return 4;
            }
            return -1;
        }
        else if (v.getId() == R.id.hand6) {
            if (imageView.getVisibility() == View.VISIBLE) {
                return 5;
            }
            return -1;
        }
        else if (v.getId() == R.id.hand7) {
            if (imageView.getVisibility() == View.VISIBLE) {
                return 6;
            }
            return -1;
        }
        else if (v.getId() == R.id.hand8) {
            if (imageView.getVisibility() == View.VISIBLE) {
                return 7;
            }
            return -1;
        }
        return -1;
    }

    @Override
    public View getTopView() {
        return myActivity.findViewById(R.id.top_gui_layout);
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
            state = (CitadelsState)info;
            //right here need to update the user interface to show everything that is in the state
            //things like imageview or anything drawing

            view.setState((CitadelsState)info);
            view.invalidate();
            Logger.log(TAG, "receiving");
        }
    }

    @Override
    public void setAsGui(GameMainActivity activity) {
        myActivity = activity;
        myActivity.setContentView(layoutId);
        //this method is the onCreate so add listeners here
        Button endButton = myActivity.findViewById(R.id.endButton);
        endButton.setOnClickListener(this);
        ImageView imageView = myActivity.findViewById(R.id.hand1);
        imageView.setOnClickListener(this);
        imageView = myActivity.findViewById(R.id.hand2);
        imageView.setOnClickListener(this);
        imageView = myActivity.findViewById(R.id.hand3);
        imageView.setOnClickListener(this);
        imageView = myActivity.findViewById(R.id.hand4);
        imageView.setOnClickListener(this);
        imageView = myActivity.findViewById(R.id.hand5);
        imageView.setOnClickListener(this);
        imageView = myActivity.findViewById(R.id.hand6);
        imageView.setOnClickListener(this);
        imageView = myActivity.findViewById(R.id.hand7);
        imageView.setOnClickListener(this);
        imageView = myActivity.findViewById(R.id.hand8);
        imageView.setOnClickListener(this);
    }
}
