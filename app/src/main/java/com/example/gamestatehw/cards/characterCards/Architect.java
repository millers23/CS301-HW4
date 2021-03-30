package com.example.gamestatehw.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.cards.CharacterCard;

public class Architect extends CharacterCard {
    public Architect() {
        super("Architect",
                0,
                "Gain two extra cards. You can use this ability regardless of\n" +
                        "which resource you gathered this turn.\n" +
                        "Your building limit this turn is three.",
                1,
                7);
    }

    @Override
    public void ability() {
        Log.d("Architect","Override works");
    }
}