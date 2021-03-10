package com.example.gamestatehw;

import java.util.ArrayList;

public class Player {
    private String name;
    private int gold;
    private int points;
    private int numCards;
    private ArrayList<Card> hand;
    private Card character;

    public Player(String n) {
        name = n;
        gold = 0;
        points = 0;
        numCards = 0;
        hand = null;
        character = null;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
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

    public void addToHand(ArrayList<Card> hand, Card card) {
        hand.add(card);
    }

    public void removeFromHand(ArrayList<Card> hand, Card card) {
        hand.remove(card);
    }

    public void removeFromHand(ArrayList<Card> hand, int index) {
        hand.remove(index);
    }

    public void clearHand(ArrayList<Card> hand) {
        hand.clear();
    }

    public Card getCharacter() {
        return character;
    }

    public void setCharacter(Card character) {
        this.character = character;
    }
}
