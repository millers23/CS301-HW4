package com.example.gamestatehw.citadels.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.citadels.cards.CharacterCard;

public class Queen extends CharacterCard {
    public Queen() {
        super("Queen",
                0,
                "If you are sitting next to the player who revealed the rank 4 \n" +
                        "character (King, Emperor, or Patrician), gain three gold. If \n" +
                        "this character is sitting next to you, but has been killed by the \n" +
                        "Assassin, you gain three gold when that card is revealed at the \n" +
                        "end of the round.\n" +
                        "Note: The Queen cannot be used in games with fewer than five \n" +
                        "players.",
                1,
                9);
    }

    public void ability() {
        Log.d("Queen","Override works");
    }
}