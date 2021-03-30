package com.example.gamestatehw.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.cards.CharacterCard;

public class Trader extends CharacterCard {
    public Trader() {
        super("Trader",
                0,
                "You gain one gold for each trade district in your city.\n" +
                        "Trade districts do not count toward your building limit this \n" +
                        "turn. This effectively means that you can build any number of \n" +
                        "trade districts in addition to your building limit.",
                1,
                6);
    }

    @Override
    public void ability() {
        Log.d("Trader","Override works");
    }
}