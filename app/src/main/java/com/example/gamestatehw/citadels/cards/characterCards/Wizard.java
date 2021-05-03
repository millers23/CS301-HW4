package com.example.gamestatehw.citadels.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.citadels.cards.CharacterCard;

public class Wizard extends CharacterCard {
    public Wizard() {
        super("Wizard",
                0,
                "Look at another player’s hand of cards and choose one of those \n" +
                        "cards. Then either pay to immediately build the chosen card in \n" +
                        "your city or add it to your hand. If you immediately build it,\n" +
                        "it does not count toward your building limit, which means you \n" +
                        "can build another district this turn.\n" +
                        "During this turn, you can build districts that are identical to any \n" +
                        "other district already in your city.",
                1,
                3);
    }

    public void ability() {
        Log.d("Wizard","Override works");
    }
}