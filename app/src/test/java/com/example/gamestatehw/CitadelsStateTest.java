package com.example.gamestatehw;

import android.content.pm.ActivityInfo;

import com.example.gamestatehw.citadels.cards.Card;
import com.example.gamestatehw.citadels.cards.characterCards.Architect;
import com.example.gamestatehw.citadels.cards.characterCards.Bishop;
import com.example.gamestatehw.citadels.cards.characterCards.Merchant;
import com.example.gamestatehw.citadels.cards.characterCards.Patrician;
import com.example.gamestatehw.citadels.infoMessage.CitadelsState;
import com.example.gamestatehw.citadels.cards.districtCards.BlueDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.GreenDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.RedDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.YellowDistrict;
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
    //Kyle created test
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
    //Kyle created test
    @Test
    public void getWhoseMove() {
        CitadelsState state = new CitadelsState();
        //testing default value
        assertEquals(1,state.getWhoseMove());
        state.setWhoseMove(100);
        //testing invalid number
        assertEquals(1,state.getWhoseMove());
        state.setWhoseMove(3);
        //testing valid number
        assertEquals(3,state.getGamePhase());
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


    // Test By Axl Martinez
    @Test
    public void ability() {
       // CitadelsState state = new CitadelsState(); // not working since init() is broken

        // create everything since init() is broken
        CitadelsPlayer p1 = new CitadelsPlayer("TEST1");
        ArrayList<Card> characterDeck = new ArrayList<>();
        ArrayList<Card> districtDeck = new ArrayList<>();
        ArrayList<Card> districts = new ArrayList<>();

        for (int i = 0; i < 11; i++) {
            BlueDistrict blueDistrict = new BlueDistrict();
            districtDeck.add(blueDistrict);
            RedDistrict redDistrict = new RedDistrict();
            districtDeck.add(redDistrict);
        }
        for (int i = 0; i < 12; i++) {
            YellowDistrict yellowDistrict = new YellowDistrict();
            districtDeck.add(yellowDistrict);
        }
        for (int i = 0; i < 20; i++) {
            GreenDistrict greenDistrict = new GreenDistrict();
            districtDeck.add(greenDistrict);
        }

        // create characters

        Architect architect = new Architect();
        characterDeck.add(architect);

        Merchant merchant = new Merchant();
        characterDeck.add(merchant);

        Bishop bishop = new Bishop();
        characterDeck.add(bishop);

        p1.setGold(100);

        //test Merchant
        p1.setCharacter(merchant);

        p1.addToDistrict(districts, districtDeck.get(50));
        p1.addToDistrict(districts, districtDeck.get(49));
        p1.addToDistrict(districts, districtDeck.get(48));
        p1.addToDistrict(districts, districtDeck.get(47));
        p1.addToDistrict(districts, districtDeck.get(5));
        p1.addToDistrict(districts, districtDeck.get(7));

        p1.setDistricts(districts);

        p1.Ability();

        // Test to see if gold is updated since we have districts in there
      assertNotEquals(100, p1.getGold());
      assertEquals(104, p1.getGold());

      // Must work for all since the code is similar except for what is being compared

    }
}