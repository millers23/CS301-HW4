package com.example.gamestatehw.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.cards.CharacterCard;

public class Assassin extends CharacterCard {
    public Assassin() {
        super("Assassin",
                0,
                "Call the name of another character whom you wish to kill.\n" +
                        "When the killed character is called to take his turn, he must\n" +
                        "remain silent and skip his entire turn for this round without\n" +
                        "revealing his character card.",
                1,
                1);
    }

    @Override
    public void ability() {
        Log.d("Assassin","Override works");
    }
}
