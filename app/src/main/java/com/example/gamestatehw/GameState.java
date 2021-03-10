package com.example.gamestatehw;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameState {
    private int numPlayers;
    private int turnNum;
    //phase 1: picking the character
    //phase 2: player turns
    private int roundPhase;
    //phase 1: pick card, get gold
    //phase 2: build, destroy, ability, end turn
    //phase 3: end turn
    private int turnPhase;

    public GameState() {
        turnNum = 1;
        roundPhase = 1;
        turnPhase = 1;
    }

    @Override
    public String toString() {
        return "GameState{" +
                "numPlayers=" + numPlayers +
                ", turnNum=" + turnNum +
                ", roundPhase=" + roundPhase +
                ", turnPhase=" + turnPhase +
                '}';
    }

    public void turn(Player p) {
        if (turnPhase == 1) {
            //enable Draw Card and Gain Gold
        }
        else if (turnPhase == 2) {
            //enable Build, Destroy, Ability, and End Turn
        }
        else if (turnPhase == 3) {
            //enable End Turn
        }
    }
}
