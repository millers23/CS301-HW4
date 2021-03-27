package com.example.gamestatehw.cards;

public class CharacterCard extends Card {
    int usablePhase;
    int number;

    public CharacterCard(String n, int t, String d, int p, int nu) {
        super(n, t, d);
        usablePhase = p;
        number = nu;
    }

    public void abilitiy() {
        return;
    }
}
