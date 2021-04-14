/**
 * GameState class. Used to store all the major information of the game and calculate
 * changes to player points and decks.
 *
 * @author Sebastian Miller, Kyle Mayhead, Daniel Lee, Axl Martinez-Ibarra
 */
package com.example.gamestatehw.citadels.infoMessage;

import com.example.gamestatehw.GameFramework.infoMessage.GameState;
import com.example.gamestatehw.citadels.cards.UniqueDistrictCard;
import com.example.gamestatehw.citadels.cards.characterCards.Architect;
import com.example.gamestatehw.citadels.cards.characterCards.Bishop;
import com.example.gamestatehw.citadels.cards.characterCards.King;
import com.example.gamestatehw.citadels.cards.characterCards.Merchant;
import com.example.gamestatehw.citadels.cards.characterCards.Patrician;
import com.example.gamestatehw.citadels.cards.characterCards.Seer;
import com.example.gamestatehw.citadels.cards.characterCards.Thief;
import com.example.gamestatehw.citadels.cards.characterCards.Warlord;
import com.example.gamestatehw.citadels.players.CitadelsPlayer;
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
    public DistrictCard highlightedCard;

    private ArrayList<CitadelsPlayer> players;

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
        for (int i = 0; i < original.characterDeck.size(); i++) {
            characterDeck.add(original.characterDeck.get(i));
        }
        for (int i = 0; i < original.districtDeck.size(); i++) {
            districtDeck.add(original.districtDeck.get(i));
        }
        gamePhase = original.gamePhase;
        playerTurn = original.playerTurn;
        turnPhase = original.turnPhase;
        players = original.getPlayers();
    }

    /**
     * Getters and Setters
     */
    public ArrayList<CitadelsPlayer> getPlayers() { return players; }

    public void setPlayers(ArrayList<CitadelsPlayer> players) { this.players = players; }

    public boolean addPlayer(CitadelsPlayer p) {
        if (players.contains(p) == true) {
            return false;
        }
        else {
            players.add(p);
            return true;
        }
    }

    public boolean removePlayer(CitadelsPlayer p) {
        if (players.contains(p) == true) {
            players.remove(p);
            return true;
        }
        else {
            return false;
        }
    }

    public int getGamePhase() {
        return gamePhase;
    }

    public void setGamePhase(int gamePhase) {
        this.gamePhase = gamePhase;
    }

    public int getWhoseMove() { return playerTurn; }

    public void setWhoseMove(int playerTurn) {
        this.playerTurn = playerTurn;
    }

    public int getTurnPhase() {
        return turnPhase;
    }

    public void setTurnPhase(int turnPhase) {
        this.turnPhase = turnPhase;
    }

    public void setHighlightedCard(){this.highlightedCard = highlightedCard;}

    public DistrictCard getHighlightedCard(){return highlightedCard;}

    public void init() {
        //add character cards to deck

        // under development
       // Architect architect = new Architect();
      //  characterDeck.add(architect);

        Merchant merchant = new Merchant();
        characterDeck.add(merchant);

        Bishop bishop = new Bishop();
        characterDeck.add(bishop);

        Warlord warlord = new Warlord();
        characterDeck.add(warlord);

        King king = new King();
        characterDeck.add(king);

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
        int i = (int) ((Math.random() * 55) + 1);
        Card card = districtDeck.get(i);
        return card;
    }

    //tallies the score of a given player with the needed extra parameters
    public void calcScore(ArrayList<CitadelsPlayer> players) {
        for (int i = 0; i < players.size(); i++) {
            int score = 0;
            int red = 0;
            int blue = 0;
            int green = 0;
            int yellow = 0;
            int unique = 0;
            CitadelsPlayer p = players.get(i);
            for (int j = 0; j < p.getDistricts().size(); j++) {
                ArrayList<Card> district = p.getDistricts();
                Card districtCard = district.get(j);
                if (districtCard instanceof RedDistrict) {
                    red++;
                }
                if (districtCard instanceof BlueDistrict) {
                    blue++;
                }
                if (districtCard instanceof GreenDistrict) {
                    green++;
                }
                if (districtCard instanceof YellowDistrict) {
                    yellow++;
                }
                if (districtCard instanceof UniqueDistrictCard) {
                    unique++;
                }
            }
            for (int j = 0; j < p.getDistricts().size(); j++) {
                DistrictCard c = (DistrictCard)p.getDistricts().get(j);
                score += c.getCost();
            }
            if (red > 0 && blue > 0 && green > 0 && yellow > 0 && unique > 0) {
                score += 3;
            }
            /*if (firstToFull) {
                score += 4;
            }
            if (!firstToFull && red > 0 && blue > 0 && green > 0 && yellow > 0 && unique > 0) {
                score += 2;
            }*/
            for (int j = 0; j < p.getDistricts().size(); j++) {
                if (p.getDistricts().get(j) instanceof UniqueDistrictCard) {
                    UniqueDistrictCard card = (UniqueDistrictCard)p.getDistricts().get(j);
                    score += card.getCost();
                }
            }
            p.setPoints(score);
        }
    }

    //adds gold to the player's inventory
    public boolean drawGold(CitadelsPlayer p) {
        if (turnPhase == 0) {
            p.setGold(p.getGold() + 2);
            turnPhase++;
            return true;
        } else {
            return false;
        }
    }

    //adds two random cards to the player's inventory
    public boolean drawCard(CitadelsPlayer p) {
        if (turnPhase == 0) {
            p.addToHand(p.getHand(), randomCard());
            p.addToHand(p.getHand(), randomCard());
            turnPhase++;
            return true;
        } else {
            return false;
        }
    }

    //removes a card from the player's deck
    public boolean removeCard(CitadelsPlayer p, Card c) {
        ArrayList<Card> d = p.getHand();
        if (d.contains(c)) {
            d.remove(c);
            return true;
        } else {
            return false;
        }
    }

    //builds a district if the player is able to
    public boolean buildDistrict(CitadelsPlayer p, DistrictCard c) {
        if (turnPhase == 1) {
            if (p.getGold() >= c.getCost()) {
                p.removeFromHand(p.getHand(), c);
                p.addToDistrict(p.getDistricts(), c);
                p.setGold(p.getGold() - c.getCost());
                turnPhase++;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    //removes a district if the player is able to
    public boolean removeDistrict(CitadelsPlayer p, DistrictCard c) {
        if (turnPhase == 1) {
            p.removeFromDistricts(p.getDistricts(), c);
            turnPhase++;
            return true;
        } else {
            return false;
        }
    }

    //uses player character's ability
    public boolean useAbility(CitadelsPlayer p) {
        //each character has their own ability
        //there are 18 of them
        //oh boy
        CharacterCard character = p.getCharacter();
        if (turnPhase == 0) {
            if (character instanceof Assassin) {
                character.ability();
                turnPhase++;
                return true;
            } else {
                return false;
            }
        } else if (turnPhase == 1) {
            if (character instanceof Assassin) {
                character.ability();
                turnPhase++;
                return true;
            } else {
                return false;
            }
        } else if (turnPhase == 2) {
            if (character instanceof Assassin) {
                character.ability();
                turnPhase++;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    //ends the player's turn
    public boolean endTurn() {
        if (turnPhase == 1 || turnPhase == 2) {
            turnPhase = 0;
            if (playerTurn < numPlayers) {
                playerTurn++;
            } else {
                playerTurn = 1;
            }
            return true;
        } else {
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
