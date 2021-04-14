/**
 * Player class for the game, will be split into subclasses later
 *
 * @author Sebastian Miller, Kyle Mayhead, Daniel Lee, Axl Martinez-Ibarra
 */
package com.example.gamestatehw.citadels.players;

import com.example.gamestatehw.GameFramework.game.GameMainActivity;
import com.example.gamestatehw.GameFramework.infoMessage.GameInfo;
import com.example.gamestatehw.GameFramework.players.GamePlayer;
import com.example.gamestatehw.citadels.cards.Card;
import com.example.gamestatehw.citadels.cards.CharacterCard;

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

    //constructor
    public CitadelsPlayer(String n) {
        name = n;
        gold = 0;
        points = 0;
        numCards = 0;
        hand = null;
        character = null;
        districts = null;
    }

    /**
     * The methods in this class are almost exclusively Getters and Setters
     */
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getSelectedCard() { return selectedCard; }

    public void setSelectedCard(int selectedCard) { this.selectedCard = selectedCard; }

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
        this.districts = districts;
    }

    public void addToHand(ArrayList<Card> hand, Card card) {
        hand.add(card);
    }

    public void removeFromHand(ArrayList<Card> hand, Card card) {
        hand.remove(card);
    }

    public void removeFromHand(ArrayList<Card> hand, int index) {
        hand.remove(index);
    }

    public void addToDistrict(ArrayList<Card> hand, Card card) {
        hand.add(card);
    }

    public void removeFromDistricts(ArrayList<Card> hand, Card card) {
        hand.remove(card);
    }

    public void removeFromDistricts(ArrayList<Card> hand, int index) {
        hand.remove(index);
    }

    public void clearHand(ArrayList<Card> hand) {
        hand.clear();
    }

    public CharacterCard getCharacter() {
        return character;
    }

    public void setCharacter(CharacterCard character) { this.character = character; }
}
