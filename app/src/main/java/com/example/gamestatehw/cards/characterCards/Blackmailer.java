package com.example.gamestatehw.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.cards.CharacterCard;

public class Blackmailer extends CharacterCard {
    public Blackmailer() {
        super("Blackmailer",
                0,
                "Take the two threat markers and assign them facedown to two\n" +
                        "different character tokens of your choice. One of the markers\n" +
                        "shows the flowered lace on its face; both players are threatened,\n" +
                        "but only the player marked with the flowered lace is targeted.\n" +
                        "When a threatened player is called to take his turn, he must\n" +
                        "immediately gather resources and then resolve the threat:\n" +
                        "he can bribe you by giving you half his gold (rounded down),\n" +
                        "which removes his threat marker without revealing it. A\n" +
                        "threatened player with only one gold in his stash can bribe\n" +
                        "you by giving you zero gold. If he does not bribe you, you may\n" +
                        "reveal his threat marker by flipping it faceup. If you reveal the\n" +
                        "flowered lace, you immediately take all his gold.\n" +
                        "A threatened player must resolve the threat before he is able to use\n" +
                        "any of his character abilities or build districts, and the only district\n" +
                        "effects he can use before resolving the threat are those that occur\n" +
                        "when gathering resources (Gold Mine, Library, or Observatory).\n" +
                        "You cannot assign threat markers to the rank 1 character\n" +
                        "(Assassin, Witch, or Magistrate), the killed character, or\n" +
                        "the bewitched character. You can assign threat markers to\n" +
                        "characters who have been assigned warrant markers.",
                1,
                2);
    }

    @Override
    public void ability() {
        Log.d("Blackmailer","Override works");
    }
}