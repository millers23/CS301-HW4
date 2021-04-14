package com.example.gamestatehw.GameFramework.actionMessage;

import com.example.gamestatehw.GameFramework.players.GamePlayer;
import com.example.gamestatehw.citadels.cards.Card;

public class BuildDistrictAction extends GameAction {
    private Card cardToPlay;
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public BuildDistrictAction(GamePlayer player, Card cardToPlay) {
        super(player);
        this.cardToPlay = cardToPlay;
    }
    public Card getCardToPlay(){
        return cardToPlay;
    }
}
