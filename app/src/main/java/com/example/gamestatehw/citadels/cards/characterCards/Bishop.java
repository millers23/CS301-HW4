package com.example.gamestatehw.citadels.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.citadels.cards.Card;
import com.example.gamestatehw.citadels.cards.CharacterCard;
import com.example.gamestatehw.citadels.cards.districtCards.BlueDistrict;
import com.example.gamestatehw.citadels.infoMessage.CitadelsState;
import com.example.gamestatehw.citadels.players.CitadelsPlayer;

import java.util.ArrayList;


public class Bishop extends CharacterCard {
    public Bishop() {
        super("Bishop",
                0,
                "You gain one card for each noble district in your city.\n" +
                        "At some point during your turn, you must take the crown. You \n" +
                        "are now the crowned player, so you call characters for the rest of \n" +
                        "the round, and you will be the first to choose a character during \n" +
                        "the next round (until another player chooses the Patrician).\n" +
                        "If you are killed, you skip your turn like any other character.\n" +
                        "At the end of the round, reveal the Patrician’s character card\n" +
                        "and take the crown as the Patrician’s heir.\n" +
                        "If you are bewitched, you still take the crown.\n" +
                        "Note: If the Patrician is discarded faceup at the start of the \n" +
                        "selection phase, randomly discard another character card faceup \n" +
                        "to replace it and shuffle the Patrician into the character deck.",
                1,
                4);
    }

    public void ability(CitadelsState state, CitadelsPlayer p) {
        ArrayList<Card> districts = p.getDistricts();

        for (int j = 0; j < districts.size(); j++) {
            for (int i = 0; i < districts.size(); i++) {
                Card districtCard = districts.get(j);
                if (districtCard instanceof BlueDistrict) {   // for every instance of religion districts
                    p.setGold(p.getGold() + 1);
                }
            }
        }
    }
}