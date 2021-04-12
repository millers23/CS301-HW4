package com.example.gamestatehw.citadels.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.GameFramework.actionMessage.DrawCardAction;
import com.example.gamestatehw.citadels.cards.CharacterCard;
import com.example.gamestatehw.citadels.infoMessage.CitadelsState;

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
        int X;
        for(X = 0; X != 2 ; X++){ // loop twice to add 2 random cards
            //setTurnPhase(0); // This is to make sure it does not skip the drawing
            //drawCard(getPlayer());  //the actual drawing action like if he chose to draw
        }

        Log.d("Architect","Override works");

    }
}