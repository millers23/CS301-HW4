package com.example.gamestatehw;

import android.graphics.Color;

import com.example.gamestatehw.citadels.cards.Card;
import com.example.gamestatehw.citadels.cards.CharacterCard;
import com.example.gamestatehw.citadels.cards.DistrictCard;
import com.example.gamestatehw.citadels.cards.UniqueDistrictCard;
import com.example.gamestatehw.citadels.cards.characterCards.Abbot;
import com.example.gamestatehw.citadels.cards.characterCards.Alchemist;
import com.example.gamestatehw.citadels.cards.characterCards.Architect;
import com.example.gamestatehw.citadels.cards.characterCards.Artist;
import com.example.gamestatehw.citadels.cards.characterCards.Assassin;
import com.example.gamestatehw.citadels.cards.characterCards.Bishop;
import com.example.gamestatehw.citadels.cards.characterCards.Blackmailer;
import com.example.gamestatehw.citadels.cards.characterCards.Cardinal;
import com.example.gamestatehw.citadels.cards.characterCards.Diplomat;
import com.example.gamestatehw.citadels.cards.characterCards.Emperor;
import com.example.gamestatehw.citadels.cards.characterCards.King;
import com.example.gamestatehw.citadels.cards.characterCards.Magician;
import com.example.gamestatehw.citadels.cards.characterCards.Magistrate;
import com.example.gamestatehw.citadels.cards.characterCards.Marshal;
import com.example.gamestatehw.citadels.cards.characterCards.Merchant;
import com.example.gamestatehw.citadels.cards.characterCards.Navigator;
import com.example.gamestatehw.citadels.cards.characterCards.Patrician;
import com.example.gamestatehw.citadels.cards.characterCards.Queen;
import com.example.gamestatehw.citadels.cards.characterCards.Scholar;
import com.example.gamestatehw.citadels.cards.characterCards.Seer;
import com.example.gamestatehw.citadels.cards.characterCards.Spy;
import com.example.gamestatehw.citadels.cards.characterCards.TaxCollector;
import com.example.gamestatehw.citadels.cards.characterCards.Thief;
import com.example.gamestatehw.citadels.cards.characterCards.Trader;
import com.example.gamestatehw.citadels.cards.characterCards.Warlord;
import com.example.gamestatehw.citadels.cards.characterCards.Witch;
import com.example.gamestatehw.citadels.cards.characterCards.Wizard;
import com.example.gamestatehw.citadels.cards.districtCards.BlueDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.GreenDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.RedDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.YellowDistrict;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {
    //Created by Sebastian
    @Test
    public void testCard() {
        Card c = new Card("TEST",0,"NULL");

        assertEquals("TEST", c.getName());
        assertEquals(0, c.getType());

        c.setName("TEST1");
        c.setType(1);

        assertEquals("TEST1", c.getName());
        assertEquals(1, c.getType());
    }

    //Created by Sebastian
    @Test
    public void testCharacterCard() {
        CharacterCard c = new CharacterCard("TEST",0,"NULL", 0, 0);

        assertEquals(0, c.getUsablePhase());
        assertEquals(0, c.getNumber());

        c.setUsablePhase(1);
        c.setNumber(1);

        assertEquals(1, c.getUsablePhase());
        assertEquals(1, c.getNumber());
    }

    //Created by Sebastian
    @Test
    public void testDistrictCard() {
        DistrictCard c = new DistrictCard("TEST",0,"NULL",0, Color.BLACK);

        assertEquals(0, c.getCost());
        assertEquals(Color.BLACK, c.getColor());

        c.setCost(1);
        c.setColor(Color.WHITE);

        assertEquals(1, c.getCost());
        assertEquals(Color.WHITE, c.getColor());
    }

    //Created by Sebastian
    @Test
    public void testUniqueDistrictCard() {
        UniqueDistrictCard c = new UniqueDistrictCard("TEST",0,"NULL",0, Color.BLACK);
        //nothing to test
    }

    //Created by Sebastian
    @Test
    public void testDistrictCards() {
        //blue district test
        BlueDistrict b = new BlueDistrict();
        districtHelper(b,"Religious",1,1,Color.BLUE);

        //green district test
        GreenDistrict g = new GreenDistrict();
        districtHelper(g,"Trade",1,1,Color.GREEN);

        //red district test
        RedDistrict r = new RedDistrict();
        districtHelper(r,"Military",1,1,Color.RED);

        //yellow district test
        YellowDistrict y = new YellowDistrict();
        districtHelper(y,"Noble",1,1,Color.YELLOW);
    }

    //Created by Sebastian
    public void districtHelper(DistrictCard c, String name, int type, int cost, int color) {
        assertEquals(name,c.getName());
        assertEquals(type,c.getType());
        assertNotEquals("",c.getDescription());
        assertEquals(cost,c.getCost());
        assertEquals(color,c.getColor());
    }

    //Created by Sebastian
    @Test
    public void testCharacterCards() {
        Abbot abbot = new Abbot();
        characterHelper(abbot,"Abbot",0,1,5);

        Alchemist alchemist = new Alchemist();
        characterHelper(alchemist,"Alchemist",0,1,6);

        Architect architect = new Architect();
        characterHelper(architect,"Architect",0,1,7);

        Artist artist = new Artist();
        characterHelper(artist,"Artist",0,1,9);

        Assassin assassin = new Assassin();
        characterHelper(assassin,"Assassin",0,1,1);

        Bishop bishop = new Bishop();
        characterHelper(bishop,"Bishop",0,1,4);

        Blackmailer blackmailer = new Blackmailer();
        characterHelper(blackmailer,"Blackmailer",0,1,2);

        Cardinal cardinal = new Cardinal();
        characterHelper(cardinal,"Cardinal",0,1,5);

        Diplomat diplomat = new Diplomat();
        characterHelper(diplomat,"Diplomat",0,1,8);

        Emperor emperor = new Emperor();
        characterHelper(emperor,"Emperor",0,1,4);

        King king = new King();
        characterHelper(king,"King",0,1,4);

        Magician magician = new Magician();
        characterHelper(magician,"Magician",0,1,3);

        Magistrate magistrate = new Magistrate();
        characterHelper(magistrate,"Magistrate",0,1,1);

        Marshal marshal = new Marshal();
        characterHelper(marshal,"Marshal",0,1,8);

        Merchant merchant = new Merchant();
        characterHelper(merchant,"Merchant",0,1,6);

        Navigator navigator = new Navigator();
        characterHelper(navigator,"Navigator",0,1,7);

        Patrician patrician = new Patrician();
        characterHelper(patrician,"Patrician",0,1,5);

        Queen queen = new Queen();
        characterHelper(queen,"Queen",0,1,9);

        Scholar scholar = new Scholar();
        characterHelper(scholar,"Scholar",0,1,7);

        Seer seer = new Seer();
        characterHelper(seer,"Seer",0,1,3);

        Spy spy = new Spy();
        characterHelper(spy,"Spy",0,1,2);

        TaxCollector taxCollector = new TaxCollector();
        characterHelper(taxCollector,"TaxCollector",0,1,9);

        Thief thief = new Thief();
        characterHelper(thief,"Thief",0,1,2);

        Trader trader = new Trader();
        characterHelper(trader,"Trader",0,1,6);

        Warlord warlord = new Warlord();
        characterHelper(warlord,"Warlord",0,1,8);

        Witch witch = new Witch();
        characterHelper(witch,"Witch",0,0,1);

        Wizard wizard = new Wizard();
        characterHelper(wizard,"Wizard",0,1,3);

    }

    //Created by Sebastian
    public void characterHelper(CharacterCard c, String name, int type, int phase, int number) {
        assertEquals(name,c.getName());
        assertEquals(type,c.getType());
        assertEquals(phase,c.getUsablePhase());
        assertEquals(number,c.getNumber());
    }
}
