package com.example.gamestatehw;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameState {
    private int numPlayers;
    //phase 0: picking the character
    //phase 1: player turns
    //phase 2: get points
    private int gamePhase;
    //who's turn it is
    private int playerTurn;
    //phase 0: pick card, get gold
    //phase 1: build, destroy, ability, end turn
    //phase 2: end turn
    private int turnPhase;

    private ArrayList<Player> players;
    private Card[] characterDeck;
    private Card[] districtDeck;

    public GameState() {
        characterDeck = new Card[18];
        for (int i = 0; i < 10; i++) {
            characterDeck[i] = new Card("NULL CHARACTER CARD", 0, 0);
        }
        districtDeck = new Card[80];
        for (int i = 0; i < 80; i++) {
            districtDeck[i] = new Card("NULL DISTRICT CARD", 0, 1);
        }
        gamePhase = 0;
        playerTurn = 0;
        turnPhase = 0;
    }

    public GameState(GameState original) {
        characterDeck = new Card[18];
        for (int i = 0; i < 10; i++) {
            characterDeck[i] = original.characterDeck[i];
        }
        districtDeck = new Card[80];
        for (int i = 0; i < 80; i++) {
            districtDeck[i] = original.districtDeck[i];
        }
        gamePhase = original.gamePhase;
        playerTurn = original.playerTurn;
        turnPhase = original.turnPhase;
    }
}
