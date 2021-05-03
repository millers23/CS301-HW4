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

public class CitadelsComputerPlayerBeta extends GameComputerPlayer {
    /**
     * constructor
     *
     * @param name the player's name (e.g., "John") except it's a computer with no feelings (yet)
     */
    public CitadelsComputerPlayerBeta(String name) {
        super(name);
    }

    /**
     * Behold: a slightly less dumb AI.
     * @param info - the current CitadelsState
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        //sleep for a sec
        sleep(1);
        CitadelsState state = (CitadelsState) info;
        ArrayList<CitadelsPlayer> players = state.getPlayers();
        CitadelsPlayer p = state.getPlayers().get(state.getWhoseMove());
        ArrayList<Card> h = p.getHand();
        ArrayList<Card> d = p.getDistricts();

        //calculates the average amount of gold that other players have
        int averageGold = 0;
        for (int i = 0; i < players.size(); i++) {
            averageGold += players.get(i).getGold();
        }
        averageGold -= p.getGold();
        averageGold = (int)averageGold / players.size();
        //draws gold if it has less gold than other players
        if (p.getGold() < averageGold) {
            game.sendAction(new DrawGoldAction(this));
        }
        else {
            game.sendAction(new DrawCardAction(this));
        }

        //calculates the average number of districts that other players have
        int averageDistricts = 0;
        for (int i = 0; i < players.size(); i++) {
            averageGold += players.get(i).getDistricts().size();
        }
        averageDistricts -= p.getDistricts().size();
        averageDistricts = (int)averageDistricts / players.size();
        //builds a district if it has less and has the gold to, otherwise skips its turn
        Card c = h.get((int)Math.random() * h.size());
        if (p.getDistricts().size() < averageDistricts &&
            p.getGold() > 2) {
            game.sendAction(new BuildDistrictAction(this, c));
            game.sendAction(new EndTurnAction(this));
        }
        else {
            game.sendAction(new EndTurnAction(this));
        }
    }
}
