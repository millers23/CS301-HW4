package com.example.gamestatehw.GameFramework.actionMessage;

import com.example.gamestatehw.GameFramework.players.GamePlayer;
import com.example.gamestatehw.citadels.cards.Card;

public class RemoveDistrictAction extends GameAction {
    private Card cardToPlay;
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public RemoveDistrictAction(GamePlayer player, Card cardToPlay) {
        super(player);
        this.cardToPlay = cardToPlay;
    }
    public Card getCardToPlay(){
        return cardToPlay;
    }
}
