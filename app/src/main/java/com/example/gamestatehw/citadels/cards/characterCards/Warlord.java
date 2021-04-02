package com.example.gamestatehw.citadels.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.citadels.cards.CharacterCard;

public class Warlord extends CharacterCard {
    public Warlord() {
        super("Warlord",
                0,
                "You gain one gold for each military district in your city.\n" +
                        "You can destroy one district of your choice by paying one fewer \n" +
                        "gold than its building cost. So, you can destroy a one-cost\n" +
                        "district for free, a two-cost district for one gold, a three-cost \n" +
                        "district for two gold, and so on.\n" +
                        "You cannot destroy a district in a completed city, but you \n" +
                        "can destroy one of your own districts. Destroyed districts are \n" +
                        "discarded facedown to the bottom of the district deck.",
                1,
                8);
    }

    @Override
    public void ability() {
        Log.d("Warlord","Override works");
    }
}