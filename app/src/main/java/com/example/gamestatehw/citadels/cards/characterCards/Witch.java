package com.example.gamestatehw.citadels.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.citadels.cards.CharacterCard;

public class Witch extends CharacterCard {
    public Witch() {
        super("Witch",
                0,
                "First you must gather resources, then you must call the name \n" +
                        "of another character whom you wish to bewitch, and then your \n" +
                        "turn is put on hold. You cannot build at this time, and the only \n" +
                        "district effects you can use are those that occur when gathering \n" +
                        "resources (Gold Mine, Library, or Observatory).\n" +
                        "When the bewitched character is called to take his turn, he \n" +
                        "gathers resources and his turn immediately ends. He cannot \n" +
                        "build a district or use any of his character’s abilities—not even \n" +
                        "those that provide “extra” resources (like the Merchant’s extra \n" +
                        "gold). The only district effects that the bewitched player can\n" +
                        "use are those that occur when gathering resources.\n" +
                        "Now you resume your turn as if you were playing the bewitched \n" +
                        "character; you use that character’s abilities, including those that \n" +
                        "provide extra resources, passive abilities (such as the Bishop’s \n" +
                        "protection against rank 8 characters or the Architect’s increased \n" +
                        "building limit), and restrictions (such as the Navigator’s inability \n" +
                        "to build districts). You play with the cards in your hand, pay with \n" +
                        "the gold in your stash, gain resources from districts in your city, \n" +
                        "and build new districts in your city. You cannot use effects from \n" +
                        "unique districts owned by the bewitched player.\n" +
                        "If the Blackmailer is bewitched, you assign threat markers, \n" +
                        "receive bribes from threatened players, and choose to reveal the \n" +
                        "threat marker if the targeted player does not pay.\n" +
                        "If the King or Patrician is bewitched, he still takes the crown. If \n" +
                        "the Emperor is bewitched, you choose whom to give the crown \n" +
                        "to and take the resource from that player.",
                0,
                1);
    }

    public void ability() {
        Log.d("Witch","Override works");
    }
}