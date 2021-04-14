/**
 * Player class for the game, will be split into subclasses later
 *
 * @author Sebastian Miller
 */
package com.example.gamestatehw.citadels.players;

import com.example.gamestatehw.citadels.cards.Card;
import com.example.gamestatehw.citadels.cards.characterCards.Merchant;
import com.example.gamestatehw.citadels.cards.districtCards.BlueDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.GreenDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.RedDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.YellowDistrict;

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

    // By Axl
    @Test
    public void setNumCards() {
        CitadelsPlayer p = new CitadelsPlayer("TEST");

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

        p.addToHand(p.getHand(), districtDeck.get(1));
        p.addToHand(p.getHand(), districtDeck.get(2));
        p.addToHand(p.getHand(), districtDeck.get(3));
        p.addToHand(p.getHand(), districtDeck.get(4));

        p.setNumCards(p.getHand().size());

        assertEquals(4, p.getNumCards());

    }

    @Test
    public void getHand() {
        CitadelsPlayer p = new CitadelsPlayer("TEST");
        assertEquals(new ArrayList(), p.getHand());
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

    // by Axl
    @Test
    public void getDistricts() {
        CitadelsPlayer p1 = new CitadelsPlayer("TEST");
        assertEquals(new ArrayList(), p1.getDistricts());

    }

    //By Axl
    @Test
    public void setDistricts() {
        CitadelsPlayer p1 = new CitadelsPlayer("TEST");
        Card c = new Card("TEST_CARD",0,"TEST");
        ArrayList<Card> h = new ArrayList<Card>();
        h.add(c);
        p1.setDistricts(h);
        assertNotEquals(new ArrayList(), p1.getDistricts());

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

    // By Axl
    @Test
    public void addToDistrict() {
        CitadelsPlayer p = new CitadelsPlayer("TEST");

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

        p.addToDistrict(p.getDistricts(),districtDeck.get(49));

        assertNotEquals(new ArrayList(), p.getDistricts());
    }

    @Test
    public void removeFromDistricts() {
    }

    @Test
    public void testRemoveFromDistricts() {
    }

    // By Axl
    @Test
    public void clearHand() {
        CitadelsPlayer p1 = new CitadelsPlayer("TEST");
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

        p1.addToHand(p1.getHand(),districtDeck.get(50));

        assertNotEquals(new ArrayList(), p1.getHand());

        p1.clearHand(p1.getHand());

        assertEquals(new ArrayList(), p1.getHand());

    }
    //By Axl
    @Test
    public void getCharacter() {
        CitadelsPlayer p = new CitadelsPlayer("TEST");
        assertEquals(null, p.getCharacter());
    }

    // By Axl
    @Test
    public void setCharacter() {
        CitadelsPlayer p = new CitadelsPlayer("TEST");
        ArrayList<Card> characterDeck = new ArrayList<>();

        Merchant merchant = new Merchant();
        characterDeck.add(merchant);

        p.setCharacter(merchant);

        assertEquals(merchant, p.getCharacter());

    }
}