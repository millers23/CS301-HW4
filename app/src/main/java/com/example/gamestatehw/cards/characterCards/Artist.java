package com.example.gamestatehw.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.cards.CharacterCard;

public class Artist extends CharacterCard {
    public Artist() {
        super("Artist",
                0,
                "You can beautify up to two of your districts by assigning them\n" +
                        "each one gold from your stash. The cost of a beautified district\n" +
                        "is permanently increased by one, so a beautified district scores\n" +
                        "one more point at the end of the game, the Warlord must pay\n" +
                        "one more gold to destroy a beautified district, etc. (keep the\n" +
                        "gold on the card as a reminder). A district can be beautified\n" +
                        "only once.",
                1,
                9);
    }

    @Override
    public void ability() {
        Log.d("Artist","Override works");
    }
}