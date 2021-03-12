       package com.example.gamestatehw;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

       public class GameState {
    private int numPlayers;
    //phase 0: picking the character
    //phase 1: player turns
    //phase 2: get points
    private int gamePhase;
    //who's turn it is
    private int playerTurn;
    //phase 0: pick card, get gold
    //phase 1: build, destroy, ability, end turn
    //phase 2: end turn
    private int turnPhase;

    private Card[] characterDeck;
    private Card[] districtDeck;

    //player 1 data
    private int p1Gold;
    private Card p1Char;
    private ArrayList<Card> p1Deck;
    private ArrayList<Integer> p1Districts;
    private int p1Score;
    //player 2 data
    private int p2Gold;
    private Card p2Char;
    private ArrayList<Card> p2Deck;
    private ArrayList<Integer> p2Districts;
    private int p2Score;
    //player 3 data
    private int p3Gold;
    private Card p3Char;
    private ArrayList<Card> p3Deck;
    private ArrayList<Integer> p3Districts;
    private int p3Score;
    //player 4 data
    private int p4Gold;
    private Card p4Char;
    private ArrayList<Card> p4Deck;
    private ArrayList<Card> p4Districts;
    private int p4Score;
    //current max players: 4

    public GameState() {
        characterDeck = new Card[18];
        for (int i = 0; i < 10; i++) {
            characterDeck[i] = new Card("NULL CHARACTER CARD", 0, 0);
        }
        districtDeck = new Card[80];
        for (int i = 0; i < 80; i++) {
            districtDeck[i] = new Card("NULL DISTRICT CARD", 0, 1);
        }
        gamePhase = 0;
        playerTurn = 0;
        turnPhase = 0;
    }

    public GameState(GameState original) {
        characterDeck = new Card[18];
        for (int i = 0; i < 10; i++) {
            characterDeck[i] = original.characterDeck[i];
        }
        districtDeck = new Card[80];
        for (int i = 0; i < 80; i++) {
            districtDeck[i] = original.districtDeck[i];
        }
        gamePhase = original.gamePhase;
        playerTurn = original.playerTurn;
        turnPhase = original.turnPhase;
    }

    public int getGamePhase() {
        return gamePhase;
    }

    public void setGamePhase(int gamePhase) {
        this.gamePhase = gamePhase;
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }

    public int getTurnPhase() {
        return turnPhase;
    }

    public void setTurnPhase(int turnPhase) {
        this.turnPhase = turnPhase;
    }

    public Card randomCard() {
        Card card = new Card("NULL DISTRICT CARD", 0, 1);
        return card;
    }

    public int getScore(Player p, boolean firstToEight, boolean tiebreaker,
                        boolean doubleTiebreaker) {
        int score = 0;
        //get total cost of districts
        //add 3 if one district in each color
        //add 4 for first to eight bonus
        //add 2 if eight districts built and not first
        return score;
    }

    public boolean drawGold(Player p) {
        if (turnPhase == 0) {
            p.setGold(p.getGold() + 2);
            turnPhase++;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean drawCard(Player p) {
        if (turnPhase == 0) {
            p.addToHand(p.getHand(), randomCard());
            p.addToHand(p.getHand(), randomCard());
            turnPhase++;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean buildDistrict(Player p, Card c) {
        if (turnPhase == 1) {
            if (p.getGold() >= c.getCost()) {
                p.removeFromHand(p.getHand(), c);
                p.addToDistrict(p.getDistricts(), c);
                p.setGold(p.getGold() - c.getCost());
                turnPhase++;
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public boolean removeDistrict(Player p, Card c) {
        if (turnPhase == 1) {
            p.removeFromDistricts(p.getDistricts(), c);
            turnPhase++;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean useAbility(Player p) {
        if (turnPhase == 1) {
            //placeholder for when we input the deck
            //each character has their own ability
            //oh boy
            if (p.getCharacter() == null) {
                turnPhase++;
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    public boolean endTurn() {
        if (turnPhase == 1 || turnPhase == 2) {
            turnPhase = 0;
            if (playerTurn < numPlayers) {
                playerTurn++;
            }
            else {
                playerTurn = 1;
            }
            return true;
        }
        else {
            return false;
        }
    }

   @Override
    public String toString() {
        return "GameState{" +
               "numPlayers=" + numPlayers +
               ", gamePhase=" + gamePhase +
               ", playerTurn=" + playerTurn +
               ", turnPhase=" + turnPhase +
               ", characterDeck=" + Arrays.toString(characterDeck) +
               ", districtDeck=" + Arrays.toString(districtDeck) +
               ", p1Gold=" + p1Gold +
               ", p1Char=" + p1Char +
               ", p1Deck=" + p1Deck +
               ", p1Districts=" + p1Districts +
               ", p1Score=" + p1Score +
               ", p2Gold=" + p2Gold +
               ", p2Char=" + p2Char +
               ", p2Deck=" + p2Deck +
               ", p2Districts=" + p2Districts +
               ", p2Score=" + p2Score +
               ", p3Gold=" + p3Gold +
               ", p3Char=" + p3Char +
               ", p3Deck=" + p3Deck +
               ", p3Districts=" + p3Districts +
               ", p3Score=" + p3Score +
               ", p4Gold=" + p4Gold +
               ", p4Char=" + p4Char +
               ", p4Deck=" + p4Deck +
               ", p4Districts=" + p4Districts +
               ", p4Score=" + p4Score +
               '}';
    }
}
