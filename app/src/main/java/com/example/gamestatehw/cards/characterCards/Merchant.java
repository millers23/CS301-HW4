package com.example.gamestatehw.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.cards.CharacterCard;

public class Merchant extends CharacterCard {
    public Merchant() {
        super("Merchant",
                0,
                "You gain one gold for each trade district in your city.\n" +
                        "You gain one extra gold. You can use this ability regardless of \n" +
                        "which resource you gathered this turn.",
                1,
                6);
    }

    @Override
    public void ability() {
        Log.d("Merchant","Override works");
    }
}