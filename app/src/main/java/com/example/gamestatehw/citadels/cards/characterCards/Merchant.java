package com.example.gamestatehw.citadels.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.citadels.cards.Card;
import com.example.gamestatehw.citadels.cards.CharacterCard;
import com.example.gamestatehw.citadels.cards.UniqueDistrictCard;
import com.example.gamestatehw.citadels.cards.districtCards.BlueDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.GreenDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.RedDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.YellowDistrict;
import com.example.gamestatehw.citadels.players.CitadelsPlayer;

import java.util.ArrayList;

public class Merchant extends CharacterCard /* Implements CitadelsState*/ {
    public Merchant() {
        super("Merchant",
                0,
                "You gain one gold for each trade district in your city.\n" +
                        "You gain one extra gold. You can use this ability regardless of \n" +
                        "which resource you gathered this turn.",
                1,
                6);
    }

    public void ability(CitadelsPlayer p) {
        for (int j = 0; j < p.getDistricts().size(); j++) {
            ArrayList<Card> district = p.getDistricts();
            Card districtCard = district.get(j);
            if (districtCard instanceof GreenDistrict) {  // for every instance of trade districts
                p.setGold(p.getGold() + 1);
            }
        }
    }
}