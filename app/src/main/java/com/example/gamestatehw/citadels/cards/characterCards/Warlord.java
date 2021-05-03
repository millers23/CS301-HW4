package com.example.gamestatehw.citadels.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.citadels.cards.Card;
import com.example.gamestatehw.citadels.cards.CharacterCard;
import com.example.gamestatehw.citadels.cards.districtCards.RedDistrict;
import com.example.gamestatehw.citadels.infoMessage.CitadelsState;
import com.example.gamestatehw.citadels.players.CitadelsPlayer;

import java.util.ArrayList;

public class Warlord extends CharacterCard {
    public Warlord() {
        super("Warlord",
                0,
                "You gain one gold for each military district in your city.\n" +
                        "You can destroy one district of your choice by paying one fewer \n" +
                        "gold than its building cost. So, you can destroy a one-cost\n" +
                        "district for free, a two-cost district for one gold, a three-cost \n" +
                        "district for two gold, and so on.\n" +
                        "You cannot destroy a district in a completed city, but you \n" +
                        "can destroy one of your own districts. Destroyed districts are \n" +
                        "discarded facedown to the bottom of the district deck.",
                1,
                8);
    }

    public void ability(CitadelsState state, CitadelsPlayer p) {
        ArrayList<Card> districts = p.getDistricts();

        for (int j = 0; j < districts.size(); j++) {
            for (int i = 0; i < districts.size(); i++) {
                Card districtCard = districts.get(j);
                if (districtCard instanceof RedDistrict) {   // for every instance of military districts
                    p.setGold(p.getGold() + 1);
                }
            }
        }
    }
}