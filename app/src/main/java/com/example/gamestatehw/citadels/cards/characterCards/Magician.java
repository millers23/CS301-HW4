package com.example.gamestatehw.citadels.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.citadels.cards.CharacterCard;

public class Magician extends CharacterCard {
    public Magician() {
        super("Magician",
                0,
                "You can do one of the following:\n" +
                        "1. Exchange your entire hand of cards with another player’s\n" +
                        "hand of cards; if you have zero cards in your hand, you\n" +
                        "simply take the other player’s cards.\n" +
                        "2. Discard any number of cards from your hand facedown\n" +
                        "to the bottom of the district deck to gain an equal\n" +
                        "number of cards from the district deck.",
                1,
                3);
    }

    @Override
    public void ability() {
        Log.d("Magician","Override works");
    }
}