package com.example.gamestatehw.citadels.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.citadels.cards.CharacterCard;

public class Cardinal extends CharacterCard {
    public Cardinal() {
        super("Cardinal",
                0,
                "You gain one card for each religious district in your city.\n" +
                        "If you want to build a district, but you do not have enough gold to \n" +
                        "do so, you can take the remaining gold needed from one player. \n" +
                        "For each gold you take, you must give that player one card from \n" +
                        "your hand. Then you must pay to build that district in your city.\n" +
                        "A player cannot deny you his gold, and you cannot take more \n" +
                        "gold than is needed to build the intended district.",
                1,
                5);
    }

    public void ability() {
        Log.d("Cardinal","Override works");
    }
}