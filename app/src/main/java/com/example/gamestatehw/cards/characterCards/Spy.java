package com.example.gamestatehw.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.cards.CharacterCard;

public class Spy extends CharacterCard {
    public Spy() {
        super("Spy",
                0,
                "Choose another player and name a district type (noble,\n" +
                        "religious, trade, military, or unique). Then look at the\n" +
                        "cards in that player’s hand. For each card in his hand that\n" +
                        "matches the named district type, take one gold from that\n" +
                        "player’s stash and gain one card from the deck.\n" +
                        "If the player whose hand you looked at has more cards of\n" +
                        "matching districts than gold in his stash, you take all the gold\n" +
                        "in his stash, and you still gain cards for each of the matching.\n" +
                        "districts.",
                1,
                2);
    }

    @Override
    public void ability() {
        Log.d("Spy","Override works");
    }
}