package com.example.gamestatehw;

import java.util.ArrayList;

public class Player {
    private int gold;
    private int points;
    private int numCards;
    private ArrayList<Card> hand;
    private Card character;

    public Player(ArrayList<Card> h, Card c) {
        gold = 0;
        points = 0;
        numCards = h.size();
        hand = h;
        character = c;
    }
}
