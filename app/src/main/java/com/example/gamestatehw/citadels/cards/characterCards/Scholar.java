package com.example.gamestatehw.citadels.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.citadels.cards.CharacterCard;

public class Scholar extends CharacterCard {
    public Scholar() {
        super("Scholar",
                0,
                "Draw seven cards from the deck and choose one to add to your \n" +
                        "hand. Shuffle the other six cards back into the district deck and \n" +
                        "place it facedown in the center of the table.\n" +
                        "Your building limit this turn is two.",
                1,
                7);
    }

    @Override
    public void ability() {
        Log.d("Scholar","Override works");
    }
}