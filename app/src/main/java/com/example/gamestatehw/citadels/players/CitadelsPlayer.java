/**
 * Player class for the game, will be split into subclasses later
 *
 * @author Sebastian Miller, Kyle Mayhead, Daniel Lee, Axl Martinez-Ibarra
 */
package com.example.gamestatehw.citadels.players;

import com.example.gamestatehw.citadels.cards.Card;
import com.example.gamestatehw.citadels.cards.CharacterCard;
import com.example.gamestatehw.citadels.cards.characterCards.Architect;
import com.example.gamestatehw.citadels.cards.characterCards.Assassin;
import com.example.gamestatehw.citadels.cards.characterCards.Bishop;
import com.example.gamestatehw.citadels.cards.characterCards.King;
import com.example.gamestatehw.citadels.cards.characterCards.Merchant;
import com.example.gamestatehw.citadels.cards.characterCards.Thief;
import com.example.gamestatehw.citadels.cards.characterCards.Warlord;
import com.example.gamestatehw.citadels.cards.districtCards.BlueDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.GreenDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.RedDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.YellowDistrict;

import java.util.ArrayList;

public class CitadelsPlayer {
    //instance variables
    private String name;
    private int gold;
    private int points;
    private int numCards;
    private ArrayList<Card> hand;
    private ArrayList<Card> districts;
    private CharacterCard character;
    public int selectedCard = 0;

    /**
     * CitadelsPlayer constructor, holds all the player-specific data
     * @param n - the name of the player
     */
    public CitadelsPlayer(String n) {
        name = n;
        gold = 0;
        points = 0;
        numCards = 0;
        hand = new ArrayList<>();
        character = null;
        districts = new ArrayList<>();
    }

    /**
     * CitadelsPlayer copy constructor
     * @param original - the original player to copy
     */
    public CitadelsPlayer(CitadelsPlayer original) {
        name = original.name;
        gold = original.gold;
        points = original.points;
        numCards = original.numCards;
        hand = original.hand;
        character = original.character;
        districts = original.districts;
    }

    /**
     * The methods in this class are almost exclusively Getters and Setters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void addGold(int gold) { this.gold += gold; }

    public void subtractGold(int gold) { this.gold -= gold; }

    public int getSelectedCard() {
        return selectedCard;
    }

    public void setSelectedCard(int selectedCard) {
        this.selectedCard = selectedCard;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getNumCards() {
        return numCards;
    }

    public void setNumCards(int numCards) {
        this.numCards = numCards;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public ArrayList<Card> getDistricts() {
        return districts;
    }

    public void setDistricts(ArrayList<Card> hand) {
        this.districts = hand;
    }

    public void addToHand(Card card) {
        hand.add(card);
    }

    public void removeFromHand(Card card) {
        hand.remove(card);
    }

    public void removeFromHand(int index) {
        hand.remove(index);
    }

    public void addToDistrict(Card card) {
        hand.add(card);
    }

    public void removeFromDistricts(Card card) {
        hand.remove(card);
    }

    public void removeFromDistricts(int index) {
        hand.remove(index);
    }

    public void clearHand() {
        hand.clear();
    }

    public CharacterCard getCharacter() {
        return character;
    }

    public void setCharacter(CharacterCard character) {
        this.character = character;
    }
}
