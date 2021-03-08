package com.example.gamestatehw;

import java.util.ArrayList;

public class GameState {
    int numPlayers;
    int turnNum;
    //phase 1: picking the character
    //phase 2: player turns
    int roundPhase;
    //phase 1: pick card, get gold
    //phase 2: build, destroy, ability, end turn
    //phase 3: end turn
    int turnPhase;
    ArrayList<Player> players;

    public GameState(ArrayList<Player> p) {
        numPlayers = p.size();
        players = p;
        turnNum = 1;
        roundPhase = 1;
        turnPhase = 1;
    }

    public void init() {

    }

    public void turn(Player p) {
        if (turnPhase == 1) {

        }
        else if (turnPhase == 2) {

        }
        else if (turnPhase == 3) {

        }
    }
}
