package com.example.gamestatehw.citadels.infoMessage;

import com.example.gamestatehw.citadels.players.CitadelsPlayer;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CitadelsStateTest {

    @Test
    public void getPlayers() {
        CitadelsState state = new CitadelsState();

        state.addPlayer();
        ArrayList<CitadelsPlayer> players = state.getPlayers();
        assertNull(players);
    }

    @Test
    public void setPlayers() {
    }

    @Test
    public void getGamePhase() {
    }

    @Test
    public void setGamePhase() {
    }

    @Test
    public void getWhoseMove() {
    }

    @Test
    public void setWhoseMove() {
    }

    @Test
    public void getTurnPhase() {
    }

    @Test
    public void setTurnPhase() {
    }

    @Test
    public void init() {
    }

    @Test
    public void randomCard() {
    }

    @Test
    public void calcScore() {
    }

    @Test
    public void drawGold() {
    }

    @Test
    public void drawCard() {
    }

    @Test
    public void removeCard() {
    }

    @Test
    public void buildDistrict() {
    }

    @Test
    public void removeDistrict() {
    }

    @Test
    public void useAbility() {
    }

    @Test
    public void endTurn() {
    }
}