package com.example.gamestatehw.citadels.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.citadels.cards.CharacterCard;

public class Navigator extends CharacterCard {
    public Navigator() {
        super("Navigator",
                0,
                "You gain either four gold or four cards. You can use this ability \n" +
                        "regardless of which resource you gathered this turn.\n" +
                        "You cannot build any districts during your turn—not even \n" +
                        "districts that do not count toward your building limit.",
                1,
                7);
    }

    @Override
    public void ability() {
        Log.d("Navigator","Override works");
    }
}