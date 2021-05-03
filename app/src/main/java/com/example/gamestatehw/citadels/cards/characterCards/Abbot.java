package com.example.gamestatehw.citadels.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.citadels.cards.CharacterCard;

public class Abbot extends CharacterCard {
    public Abbot() {
        super("Abbot",
                0,
                "You gain either one gold or one card for each religious\n" +
                        "district in your city. You can choose any combination of the two \n" +
                        "resources; for example, if you have three religious districts, \n" +
                        "you can use this ability to gain three gold and zero cards, two \n" +
                        "gold and one card, one gold and two cards, or zero gold and\n" +
                        "three cards. You must declare the combination of resources you \n" +
                        "wish to take before taking them.\n" +
                        "If at any point during your turn you are not the player with the \n" +
                        "most gold, the richest player must give you one gold from his \n" +
                        "stash. If there is a tie for the richest player, choose which of\n" +
                        "the tied players must give you one of his gold. If you are among \n" +
                        "those tied for the richest player, you do not receive any gold.",
                1,
                5);
    }

    public void ability() {
        Log.d("Abbot","Override works");
    }
}