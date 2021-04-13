package com.example.gamestatehw;

import android.content.pm.ActivityInfo;

import com.example.gamestatehw.citadels.cards.Card;
import com.example.gamestatehw.citadels.cards.characterCards.Architect;
import com.example.gamestatehw.citadels.cards.characterCards.Merchant;
import com.example.gamestatehw.citadels.cards.characterCards.Patrician;
import com.example.gamestatehw.citadels.infoMessage.CitadelsState;
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
    //Kyle tests
    @Test
    public void testGamePhase() {
        CitadelsState state = new CitadelsState();
        //testing default value of one
        assertEquals(1,state.getGamePhase());
        state.setGamePhase(43);
        //testing invalid phase
        assertEquals(1,state.getGamePhase());
        state.setGamePhase(3);
        //testing valid phase
        assertEquals(3,state.getGamePhase());
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

    @Test
    public void ability() {
        CitadelsState state = new CitadelsState();
        CitadelsPlayer p1 = new CitadelsPlayer("TEST1");
        ArrayList<Card> characterDeck = new ArrayList<>();

        Architect architect = new Architect();
        characterDeck.add(architect);
        Merchant merchant = new Merchant();
        characterDeck.add(merchant);
        Patrician patrician = new Patrician();

        p1.setGold(100);
        p1.setCharacter(merchant);
        //p1.

        //ability();

    }
}