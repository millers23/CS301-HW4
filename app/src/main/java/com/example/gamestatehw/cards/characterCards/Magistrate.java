package com.example.gamestatehw.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.cards.CharacterCard;

public class Magistrate extends CharacterCard {
    public Magistrate() {
        super("Magistrate",
                0,
                "Take the three warrant markers and assign them facedown\n" +
                "to three different character tokens of your choice. One of the\n" +
                "markers shows the signed warrant on its face; only the player\n" +
                "marked with the signed warrant is targeted.\n" +
                "If the targeted player pays to build a district during his turn,\n" +
                "you may reveal his warrant marker by flipping it faceup. If you\n" +
                "do, you confiscate that district from him and build it in your\n" +
                "city instead for free.\n" +
                "The confiscated district never enters the targeted player’s city,\n" +
                "but it does count toward the targeted player’s building limit for\n" +
                "the turn. The targeted player receives back all gold paid for that\n" +
                "district. If he is able to build more than one district during his\n" +
                "turn, you can confiscate only the first district he pays to build.\n" +
                "Note: You cannot confiscate a district if you have an identical \n" +
                "district (with the same name) already in your city.",
                1,
                1);
    }

    @Override
    public void ability() {
        Log.d("Magistrate","Override works");
    }
}
