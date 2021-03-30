package com.example.gamestatehw.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.cards.CharacterCard;

public class Diplomat extends CharacterCard {
    public Diplomat() {
        super("Diplomat",
                0,
                "You gain one gold for each military district in your city.\n" +
                        "You can exchange one district in another player’s city for one \n" +
                        "district in your city. If the other player’s district has a higher \n" +
                        "cost than your district, you must give that player the difference \n" +
                        "in gold from your stash. If your district has a higher cost than \n" +
                        "the other player’s district, that player does not owe you any gold \n" +
                        "in return.\n" +
                        "You cannot exchange for a district in a completed city nor for \n" +
                        "a district identical to a district already in your city, but you can \n" +
                        "exchange one of your districts if you have a completed city. \n" +
                        "Also, the district coming from your city cannot be identical to a \n" +
                        "district already in the other player’s city.",
                1,
                8);
    }

    @Override
    public void ability() {
        Log.d("Diplomat","Override works");
    }
}