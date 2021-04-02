package com.example.gamestatehw.citadels.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.citadels.cards.CharacterCard;

public class Thief extends CharacterCard {
    public Thief() {
        super("Thief",
                0,
                "Call the name of another character whom you wish to rob.\n" +
                        "When a player reveals that character to take his turn, you \n" +
                        "immediately take all of his gold.\n" +
                        "You cannot rob the rank 1 character (Assassin, Witch, or \n" +
                        "Magistrate), the killed character, or the bewitched character.",
                1,
                2);
    }

    @Override
    public void ability() {
        Log.d("Thief","Override works");
    }
}
