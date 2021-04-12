package com.example.gamestatehw.citadels.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.citadels.cards.CharacterCard;

public class King extends CharacterCard {
    public King() {
        super("King",
                0,
                "You gain one gold for each noble district in your city.\n" +
                        "At some point during your turn, you must take the crown. You \n" +
                        "are now the crowned player, so you call characters for the rest\n" +
                        "of the round, and you will be the first to choose a character \n" +
                        "during the next round (until another player chooses the King).\n" +
                        "If you are killed, you skip your turn like any other character.\n" +
                        "At the end of the round, reveal the King’s character card and\n" +
                        "take the crown as the King’s heir.\n" +
                        "If you are bewitched, you still take the crown.\n" +
                        "Note: If the King is discarded faceup at the start of the selection \n" +
                        "phase, randomly discard another character card faceup to\n" +
                        "replace it and shuffle the King into the character deck.",
                1,
                4);
    }

    @Override
    public void ability() {

        Log.d("King","Override works");
    }
}