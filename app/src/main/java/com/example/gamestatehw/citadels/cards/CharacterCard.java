package com.example.gamestatehw.citadels.cards;

import com.example.gamestatehw.citadels.infoMessage.CitadelsState;
import com.example.gamestatehw.citadels.players.CitadelsPlayer;

public class CharacterCard extends Card {
    int usablePhase;
    int number;

    public CharacterCard(String n, int t, String d, int p, int nu) {
        super(n, t, d);
        usablePhase = p;
        number = nu;
    }

    public int getUsablePhase() {
        return usablePhase;
    }

    public void setUsablePhase(int usablePhase) {
        this.usablePhase = usablePhase;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void ability(CitadelsState state, CitadelsPlayer p) {
        //override me
    }
}
