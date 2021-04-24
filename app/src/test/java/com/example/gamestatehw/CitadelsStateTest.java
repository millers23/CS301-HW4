package com.example.gamestatehw;

import android.content.pm.ActivityInfo;

import com.example.gamestatehw.citadels.cards.Card;
import com.example.gamestatehw.citadels.cards.characterCards.Architect;
import com.example.gamestatehw.citadels.cards.characterCards.Bishop;
import com.example.gamestatehw.citadels.cards.characterCards.Merchant;
import com.example.gamestatehw.citadels.cards.characterCards.Warlord;
import com.example.gamestatehw.citadels.infoMessage.CitadelsState;
import com.example.gamestatehw.citadels.cards.districtCards.BlueDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.GreenDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.RedDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.YellowDistrict;
import com.example.gamestatehw.citadels.players.CitadelsPlayer;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CitadelsStateTest {

    // Created by Sebastian edited by Axl
    @Test
    public void getPlayers() {
        CitadelsState state = new CitadelsState();
        CitadelsPlayer p = new CitadelsPlayer("TEST");
        state.addPlayer(p);
        ArrayList<CitadelsPlayer> players = state.getPlayers();
        assertEquals(players.get(0).getName(), p.getName());
    }
    // Created by Sebastian
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
    //Kyle created test edited by Axl
    @Test
    public void testGamePhase() {
        CitadelsState state = new CitadelsState();
        //testing default value of one
        assertEquals(0,state.getGamePhase());
        state.setGamePhase(43);
        //testing invalid phase
        assertEquals(43,state.getGamePhase());
        state.setGamePhase(3);
        //testing valid phase
        assertEquals(3,state.getGamePhase());
    }
    //Kyle created test edited by Axl
    @Test
    public void getWhoseMove() {
        CitadelsState state = new CitadelsState();
        //testing default value
        assertEquals(0,state.getWhoseMove());
    }

    //Created by Sebastian
    @Test
    public void setWhoseMove() {
        CitadelsState state = new CitadelsState();

        state.setWhoseMove(1);
        assertEquals(1, state.getWhoseMove());
    }

    //Created by Sebastian
    @Test
    public void getTurnPhase() {
        CitadelsState state = new CitadelsState();

        //check default value
        assertEquals(0, state.getTurnPhase());
    }

    //Created by Sebastian
    @Test
    public void setTurnPhase() {
        CitadelsState state = new CitadelsState();

        //different value from default
        state.setTurnPhase(1);
        assertEquals(1, state.getTurnPhase());
    }

    //Created by Sebastian
    @Test
    public void init() {
        CitadelsState state1 = new CitadelsState();
        CitadelsState state2 = new CitadelsState();

        //test that district and character decks are setup the same
        assertEquals(state1.getCharacterDeck().get(0).getName(),
                state2.getCharacterDeck().get(0).getName());
        assertEquals(state1.getDistrictDeck().get(0).getName(),
                state2.getDistrictDeck().get(0).getName());
    }

    //Created by Sebastian
    @Test
    public void randomCard() {
        CitadelsState state = new CitadelsState();

        //get two random cards
        Card c1 = state.randomCard();
        Card c2 = state.randomCard();

        //make sure they're not the same
        assertNotEquals(c1, c2);
    }

    //Created by Sebastian
    @Test
    public void calcScore() {
        CitadelsState state = new CitadelsState();
        CitadelsPlayer p1 = new CitadelsPlayer("TEST1");
        CitadelsPlayer p2 = new CitadelsPlayer("TEST2");

        ArrayList<CitadelsPlayer> players = new ArrayList<CitadelsPlayer>();
        players.add(p1);
        players.add(p2);

        p1.addToHand(new YellowDistrict());
        p1.addToHand(new GreenDistrict());
        p1.addToHand(new RedDistrict());
        p1.addToHand(new BlueDistrict());

        p2.addToHand(new YellowDistrict());

        state.calcScore(players);

        assertNotEquals(players.get(0).getPoints(), players.get(1).getPoints());
    }

    //Created by Sebastian
    @Test
    public void drawGold() {
        CitadelsState state = new CitadelsState();
        CitadelsPlayer p = new CitadelsPlayer("TEST");

        //should be able to draw gold because the default turn phase is 0
        assertEquals(true, state.drawGold(p));
        assertEquals(2, p.getGold());

        //change turn phase
        state.setTurnPhase(1);

        //can't draw gold unless it's the start of your turn
        assertEquals(false, state.drawGold(p));
    }

    @Test
    public void drawCard() {
        CitadelsState state = new CitadelsState();
        CitadelsPlayer p = new CitadelsPlayer("TEST");

        //should be able to draw gold because the default turn phase is 0
        assertEquals(true, state.drawCard(p));
        assertEquals(2, p.getHand().size());

        //change turn phase
        state.setTurnPhase(1);

        //can't draw gold unless it's the start of your turn
        assertEquals(false, state.drawCard(p));
    }

    @Test
    public void removeCard() {
        CitadelsState state = new CitadelsState();
        CitadelsPlayer p = new CitadelsPlayer("TEST");
        Card c = new Card("TEST",0,"NULL");

        assertEquals(false, state.removeCard(p, c));

        state.drawCard(p);
        Card cT = p.getHand().get(0);
        state.removeCard(p, cT);

        assertEquals(1, p.getHand().size());

        /*
        //testing remove by object
        p.addToHand(c);
        assertEquals(c, p.getHand().get(0));
        p.removeFromHand(c);
        assertEquals(false, p.getHand().contains(c));

        //testing remove by index
        p.addToHand(c);
        assertEquals(c, p.getHand().get(0));
        p.removeFromHand(0);
        assertEquals(false, p.getHand().contains(c));
        */
    }

    @Test
    public void buildDistrict() {
        CitadelsState state = new CitadelsState();
        CitadelsPlayer p = new CitadelsPlayer("TEST");

        //can't build because the turn phase isn't right
        assertEquals(false, state.buildDistrict(p, new RedDistrict()));

        //can't build because there isn't enough gold or a card in the hand
        state.setTurnPhase(1);
        assertEquals(false, state.buildDistrict(p, new RedDistrict()));

        //can't build because there isn't enough gold
        p.addToHand(new RedDistrict());
        assertEquals(false, state.buildDistrict(p, new RedDistrict()));

        //build successful
        p.setGold(1);
        assertEquals(true, state.buildDistrict(p, new RedDistrict()));
    }

    @Test
    public void removeDistrict() {
        CitadelsState state = new CitadelsState();
        CitadelsPlayer p = new CitadelsPlayer("TEST");

        //can't remove because the turn phase isn't right
        assertEquals(false, state.removeDistrict(p, new RedDistrict()));

        //can't remove because there isn't a card to remove
        state.setTurnPhase(1);
        assertEquals(false, state.buildDistrict(p, new RedDistrict()));

        //can remove
        p.addToHand(new RedDistrict());
        assertEquals(false, state.buildDistrict(p, new RedDistrict()));
    }

    @Test
    public void endTurn() {
        CitadelsState state = new CitadelsState();

        state.setTurnPhase(1);
        assertEquals(true, state.endTurn());
        assertEquals(0, state.getTurnPhase());
        assertEquals(0, state.getWhoseMove());
        assertEquals(0, state.getGamePhase());

        state.setTurnPhase(0);
        assertEquals(false, state.endTurn());
    }

    // Test By Axl Martinez
    @Test
    public void ability() {
       // CitadelsState state = new CitadelsState(); // not working since init() is broken

        // create everything since init() is broken
        CitadelsPlayer p1 = new CitadelsPlayer("TEST1");
        CitadelsPlayer p2 = new CitadelsPlayer("Test2");
        ArrayList<Card> characterDeck = new ArrayList<>();
        ArrayList<Card> districtDeck = new ArrayList<>();


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

        Warlord warlord = new Warlord();
        characterDeck.add(warlord);

        p1.setGold(100);
        p2.setGold(100);

        //test Merchant
        p1.setCharacter(merchant);
        p2.setCharacter(warlord);

        p1.addToDistrict(districtDeck.get(50));
        p1.addToDistrict(districtDeck.get(49));
        p1.addToDistrict(districtDeck.get(48));
        p1.addToDistrict(districtDeck.get(47));
        p1.addToDistrict(districtDeck.get(5));
        p1.addToDistrict(districtDeck.get(7));

        p2.addToDistrict(districtDeck.get(50));
        p2.addToDistrict(districtDeck.get(49));
        p2.addToDistrict(districtDeck.get(48));
        p2.addToDistrict(districtDeck.get(47));
        p2.addToDistrict(districtDeck.get(5));
        p2.addToDistrict(districtDeck.get(7));

        p1.Ability();
        p2.Ability();

        // Test to see if gold is updated since we have districts in there
      assertNotEquals(p2.getGold(), p1.getGold());
      assertEquals(104, p1.getGold());

      assertEquals(102,p2.getGold());

      // Must work for all since the code is similar except for what is being compared

    }
}