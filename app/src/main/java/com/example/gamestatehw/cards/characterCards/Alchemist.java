package com.example.gamestatehw.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.cards.CharacterCard;

public class Alchemist extends CharacterCard {
    public Alchemist() {
        super("Alchemist",
                0,
                "At the end of your turn, you receive back all the gold you paid to \n" +
                        "build districts this turn, but not gold you paid for other reasons \n" +
                        "(such as the Smithy’s effect or the Tax Collector’s tax). This \n" +
                        "effectively means that you can build districts “for free,” but only\n" +
                        "if you would have had enough gold to build them.",
                1,
                6);
    }

    @Override
    public void ability() {
        Log.d("Alchemist","Override works");
    }
}