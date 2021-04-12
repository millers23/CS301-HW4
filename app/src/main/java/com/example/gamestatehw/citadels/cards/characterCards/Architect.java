package com.example.gamestatehw.citadels.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.GameFramework.actionMessage.DrawCardAction;
import com.example.gamestatehw.citadels.cards.CharacterCard;
import com.example.gamestatehw.citadels.infoMessage.CitadelsState;
import com.example.gamestatehw.citadels.players.CitadelsPlayer;

public class Architect extends CharacterCard  /*implements CitadelsState*/ {
    public Architect() {
        super("Architect",
                0,
                "Gain two extra cards. You can use this ability regardless of\n" +
                        "which resource you gathered this turn.\n" +
                        "Your building limit this turn is three.",
                1,
                7);
    }

    @Override
    public void ability() {


        Log.d("Architect","Override works");

    }
}