package com.example.gamestatehw.citadels.infoMessage;

import com.example.gamestatehw.citadels.players.CitadelsPlayer;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CitadelsStateTest {

    @Test
    public void getPlayers() {
        CitadelsState state = new CitadelsState();
        CitadelsPlayer p = new CitadelsPlayer("TEST");
        state.addPlayer(p);
        ArrayList<CitadelsPlayer> players = state.getPlayers();
        assertNull(players.get(0).getName(), p.getName());
    }

    @Test
    public void setPlayers() {
        CitadelsState state = new CitadelsState();
        CitadelsPlayer p1 = new CitadelsPlayer("TEST1");
        CitadelsPlayer p2 = new CitadelsPlayer("TEST2");
        state.addPlayer(p1);

        ArrayList<CitadelsPlayer> players = state.getPlayers();
        players.add(p2);
        state.setPlayers(players);
        assertEquals(state.getPlayers(), players);
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