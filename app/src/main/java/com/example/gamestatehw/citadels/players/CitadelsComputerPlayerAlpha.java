package com.example.gamestatehw.citadels.players;

import com.example.gamestatehw.GameFramework.actionMessage.BuildDistrictAction;
import com.example.gamestatehw.GameFramework.actionMessage.DrawCardAction;
import com.example.gamestatehw.GameFramework.actionMessage.DrawGoldAction;
import com.example.gamestatehw.GameFramework.actionMessage.EndTurnAction;
import com.example.gamestatehw.GameFramework.actionMessage.RemoveDistrictAction;
import com.example.gamestatehw.GameFramework.infoMessage.GameInfo;
import com.example.gamestatehw.GameFramework.infoMessage.GameState;
import com.example.gamestatehw.GameFramework.players.GameComputerPlayer;
import com.example.gamestatehw.citadels.cards.Card;
import com.example.gamestatehw.citadels.cards.DistrictCard;
import com.example.gamestatehw.citadels.infoMessage.CitadelsState;

import java.util.ArrayList;

public class CitadelsComputerPlayerAlpha extends GameComputerPlayer {
    /**
     * constructor
     *
     * @param name the player's name (e.g., "John") except it's a computer with no feelings (yet)
     */
    public CitadelsComputerPlayerAlpha(String name) {
        super(name);
    }

    /**
     * Behold: a very dumb AI.
     * "I don't know what's going on here, but I'll act like I do!"
     * @param info - the current CitadelsState
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        //sleep for a sec
        sleep(1);
        CitadelsState state = (CitadelsState) info;

        //initial choices that have to be made
        int choice = (int)Math.random() * 2;
        if (choice == 0) {
            game.sendAction(new DrawCardAction(this));
        }
        else {
            game.sendAction(new DrawGoldAction(this));
        }

        //tertiary choices, this AI does not care if a portion of their turn is wasted
        choice = (int)Math.random() * 3;
        CitadelsPlayer p = state.getPlayers().get(state.getWhoseMove());
        ArrayList<Card> h = p.getHand();
        ArrayList<Card> d = p.getDistricts();
        if (choice == 0) {
            Card c = h.get((int)Math.random() * h.size());
            game.sendAction(new BuildDistrictAction(this, c));
            game.sendAction(new EndTurnAction(this));
        }
        else if (choice == 1) {
            Card c = d.get((int)Math.random() * d.size());
            game.sendAction(new RemoveDistrictAction(this, c));
            game.sendAction(new EndTurnAction(this));
        }
        else {
            game.sendAction(new EndTurnAction(this));
        }
    }
}
