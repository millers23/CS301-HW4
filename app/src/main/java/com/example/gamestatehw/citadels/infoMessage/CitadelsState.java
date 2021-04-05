/**
 * GameState class. Used to store all the major information of the game and calculate
 * changes to player points and decks.
 *
 * @author Sebastian Miller, Kyle Mayhead, Daniel Lee, Axl Martinez-Ibarra
 */
package com.example.gamestatehw.citadels.infoMessage;

import com.example.gamestatehw.GameFramework.infoMessage.GameState;
import com.example.gamestatehw.citadels.cards.characterCards.Seer;
import com.example.gamestatehw.citadels.cards.characterCards.Thief;
import com.example.gamestatehw.citadels.players.Player;
import com.example.gamestatehw.citadels.cards.Card;
import com.example.gamestatehw.citadels.cards.CharacterCard;
import com.example.gamestatehw.citadels.cards.DistrictCard;
import com.example.gamestatehw.citadels.cards.characterCards.Assassin;
import com.example.gamestatehw.citadels.cards.districtCards.BlueDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.GreenDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.RedDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.YellowDistrict;

import java.io.Serializable;
import java.util.ArrayList;

public class CitadelsState extends GameState implements Serializable {
    private int numPlayers;
    //phase 0: picking the character
    //phase 1: player turns
    //phase 2: get points
    private int gamePhase;//make an enum
    //who's turn it is
    private int playerTurn;
    //phase 0: pick card, get gold
    //phase 1: build, destroy, ability, end turn
    //phase 2: end turn
    private int turnPhase;//make an enum

    private ArrayList<Card> characterDeck;
    private ArrayList<Card> districtDeck;

    private ArrayList<Player> players;

    //constructor
    public CitadelsState() {
        init();
        //leave special ability district cards for later
        gamePhase = 0;
        playerTurn = 0;
        turnPhase = 0;
    }

    //copy constructor
    public CitadelsState(CitadelsState original) {
        for (int i = 0; i < 10; i++) {
            characterDeck.add(original.characterDeck.get(i));
        }
        for (int i = 0; i < 80; i++) {
            districtDeck.add(original.districtDeck.get(i));
        }
        gamePhase = original.gamePhase;
        playerTurn = original.playerTurn;
        turnPhase = original.turnPhase;
    }

   /**
    * Getters and Setters
    */
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

    public void init() {
        //add character cards to deck
        Assassin assassin = new Assassin();
        characterDeck.add(assassin);
        Thief thief = new Thief();
        characterDeck.add(thief);
        Seer seer = new Seer();
        characterDeck.add(seer);

        //add districts to deck
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
        //unique districts go here
    }

    //draws a random card from the deck
    public Card randomCard() {
        int i = (int)((Math.random() * 55) + 1);
        Card card = districtDeck.get(i);
        return card;
    }

    //tallies the score of a given player with the needed extra parameters
    public int getScore(Player p, boolean firstToEight, boolean tiebreaker,
                        boolean doubleTiebreaker) {
        int score = 0;
        //get total cost of districts
        //add 3 if one district in each color
        //add 4 for first to eight bonus
        //add 2 if eight districts built and not first
        return score;
    }

    //adds gold to the player's inventory
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

    //adds two random cards to the player's inventory
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

    //removes a card from the player's deck
    public boolean removeCard(Player p, Card c) {
        ArrayList<Card> d = p.getHand();
        if (d.contains(c)) {
            d.remove(c);
            return true;
        }
        else {
            return false;
        }
    }

    //builds a district if the player is able to
    public boolean buildDistrict(Player p, DistrictCard c) {
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

    //removes a district if the player is able to
    public boolean removeDistrict(Player p, DistrictCard c) {
        if (turnPhase == 1) {
            p.removeFromDistricts(p.getDistricts(), c);
            turnPhase++;
            return true;
        }
        else {
            return false;
        }
    }

    //uses player character's ability
    public boolean useAbility(Player p) {
        //each character has their own ability
        //there are 18 of them
        //oh boy
        CharacterCard character = p.getCharacter();
        if (turnPhase == 0) {
            if (character instanceof Assassin) {
                character.ability();
                turnPhase++;
                return true;
            }
            else {
                return false;
            }
        }
        else if (turnPhase == 1) {
            if (character instanceof Assassin) {
                character.ability();
                turnPhase++;
                return true;
            }
            else {
                return false;
            }
        }
        else if(turnPhase == 2) {
            if (character instanceof Assassin) {
                character.ability();
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

    //ends the player's turn
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

    //toString method
   @Override
    public String toString() {
        return "GameState{" +
               "numPlayers=" + numPlayers +
               ", gamePhase=" + gamePhase +
               ", playerTurn=" + playerTurn +
               ", turnPhase=" + turnPhase +
               ", characterDeck=" + characterDeck.toString() +
               ", districtDeck=" + districtDeck.toString() +
               '}';
    }
}
