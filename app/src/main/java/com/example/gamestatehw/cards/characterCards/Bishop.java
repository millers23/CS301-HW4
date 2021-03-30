package com.example.gamestatehw.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.cards.CharacterCard;

public class Bishop extends CharacterCard {
    public Bishop() {
        super("Bishop",
                0,
                "You gain one card for each noble district in your city.\n" +
                        "At some point during your turn, you must take the crown. You \n" +
                        "are now the crowned player, so you call characters for the rest of \n" +
                        "the round, and you will be the first to choose a character during \n" +
                        "the next round (until another player chooses the Patrician).\n" +
                        "If you are killed, you skip your turn like any other character.\n" +
                        "At the end of the round, reveal the Patrician’s character card\n" +
                        "and take the crown as the Patrician’s heir.\n" +
                        "If you are bewitched, you still take the crown.\n" +
                        "Note: If the Patrician is discarded faceup at the start of the \n" +
                        "selection phase, randomly discard another character card faceup \n" +
                        "to replace it and shuffle the Patrician into the character deck.",
                1,
                4);
    }

    @Override
    public void ability() {
        Log.d("Bishop","Override works");
    }
}