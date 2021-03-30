package com.example.gamestatehw.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.cards.CharacterCard;

public class Seer extends CharacterCard {
    public Seer() {
        super("Seer",
                0,
                "Take a card at random from each other player’s hand and add\n" +
                        "those cards to your hand. Then give one card from your hand\n" +
                        "to each player you took a card from. If a player has no cards in\n" +
                        "hand, you neither take a card from him nor give him a card.\n" +
                        "Taken cards can be kept and given back in several different\n" +
                        "combinations: you can give a player the exact same card back,\n" +
                        "you can give a card taken from one player to another, or you can\n" +
                        "keep a card taken and give back a card from your original hand.\n" +
                        "Your building limit this turn is two.",
                1,
                3);
    }

    @Override
    public void ability() {
        Log.d("Seer","Override works");
    }
}