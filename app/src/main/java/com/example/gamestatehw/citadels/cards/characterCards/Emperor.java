package com.example.gamestatehw.citadels.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.citadels.cards.CharacterCard;

public class Emperor extends CharacterCard {
    public Emperor() {
        super("Emperor",
                0,
                "You gain one gold for each noble district in your city.\n" +
                        "At some point during your turn, you must take the crown from \n" +
                        "the player who has it and give it to a different player, but not \n" +
                        "yourself. You take either one gold from his stash or one card at \n" +
                        "random from his hand. If he has neither gold in his stash nor \n" +
                        "cards in hand, you do not take anything.\n" +
                        "If you are killed, you skip your turn like any other character.\n" +
                        "At the end of the round, reveal the Emperor’s character card\n" +
                        "and, as the Emperor’s advisor, take the crown from the player \n" +
                        "who has it and give it to a different player, but not yourself.\n" +
                        "You do not take a resource from the new crowned player.\n" +
                        "Note: If the Emperor is discarded faceup at the start of the \n" +
                        "selection phase, randomly discard another character card faceup \n" +
                        "to replace it and shuffle the Emperor into the character deck.\n" +
                        "Note: The Emperor cannot be used in a 2-player game.",
                1,
                4);
    }

    @Override
    public void ability() {
        Log.d("Emperor","Override works");
    }
}