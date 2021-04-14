/**
 * Player class for the game, will be split into subclasses later
 *
 * @author Sebastian Miller
 */
package com.example.gamestatehw.citadels.players;

import com.example.gamestatehw.citadels.cards.Card;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CitadelsPlayerTest {

    @Test
    public void getName() {
        CitadelsPlayer p = new CitadelsPlayer("TEST");
        assertEquals("TEST", p.getName());
    }

    @Test
    public void setName() {
        CitadelsPlayer p = new CitadelsPlayer("TEST1");
        p.setName("TEST2");
        assertEquals("TEST2", p.getName());
    }

    @Test
    public void getGold() {
        CitadelsPlayer p = new CitadelsPlayer("TEST");
        assertEquals(0, p.getGold());
    }

    @Test
    public void setGold() {
        CitadelsPlayer p = new CitadelsPlayer("TEST");
        p.setGold(1);
        assertEquals(1, p.getGold());
    }

    @Test
    public void getSelectedCard() {
        //this test is going to suck egg
    }

    @Test
    public void setSelectedCard() {
        //so is this one
    }

    @Test
    public void getPoints() {
        CitadelsPlayer p = new CitadelsPlayer("TEST");
        assertEquals(0, p.getPoints());
    }

    @Test
    public void setPoints() {
        CitadelsPlayer p = new CitadelsPlayer("TEST");
        p.setPoints(1);
        assertEquals(1, p.getPoints());
    }

    @Test
    public void getNumCards() {
        CitadelsPlayer p = new CitadelsPlayer("TEST");
        assertEquals(0, p.getNumCards());
    }

    @Test
    public void setNumCards() {
        //this test might suck
    }

    @Test
    public void getHand() {
        CitadelsPlayer p = new CitadelsPlayer("TEST");
        assertEquals(null, p.getHand());
    }

    @Test
    public void setHand() {
        CitadelsPlayer p = new CitadelsPlayer("TEST");
        Card c = new Card("TEST_CARD",0,"TEST");
        ArrayList<Card> h = new ArrayList<Card>();
        h.add(c);
        p.setHand(h);
        assertEquals(h, p.getHand());
    }

    @Test
    public void getDistricts() {
    }

    @Test
    public void setDistricts() {
    }

    @Test
    public void addToHand() {
        CitadelsPlayer p = new CitadelsPlayer("TEST");
        Card c = new Card("TEST_CARD",0,"TEST");
        ArrayList<Card> h = new ArrayList<Card>();
        h.add(c);
        p.addToHand(p.getHand(), c);
        assertEquals(h, p.getHand());
    }

    @Test
    public void removeFromHand() {
    }

    @Test
    public void testRemoveFromHand() {
    }

    @Test
    public void addToDistrict() {
    }

    @Test
    public void removeFromDistricts() {
    }

    @Test
    public void testRemoveFromDistricts() {
    }

    @Test
    public void clearHand() {
    }

    @Test
    public void getCharacter() {
    }

    @Test
    public void setCharacter() {
    }
}