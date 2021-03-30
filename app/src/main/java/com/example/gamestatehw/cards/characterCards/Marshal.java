package com.example.gamestatehw.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.cards.CharacterCard;

public class Marshal extends CharacterCard {
    public Marshal() {
        super("Marshal",
                0,
                "You gain one gold for each military district in your city.\n" +
                        "You can seize one district with a building cost of three or less \n" +
                        "in another player’s city by giving the owner gold equal to its \n" +
                        "building cost. The seized district is added to your city. \n" +
                        "You cannot seize a district in a completed city nor a district \n" +
                        "identical to a district already in your city.",
                1,
                8);
    }

    @Override
    public void ability() {
        Log.d("Marshal","Override works");
    }
}