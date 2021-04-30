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
    private int turnPhase;

    private ArrayList<Card> characterDeck = new ArrayList<>();
    private ArrayList<Card> districtDeck = new ArrayList<>();
    public DistrictCard highlightedCard;

    private ArrayList<CitadelsPlayer> players = new ArrayList<>();

    /**
     * The Citadels class constructor. It all starts here.
     */
    public CitadelsState() {
        init();
        //leave special ability district cards for later
        gamePhase = 0;
        playerTurn = 0;
        turnPhase = 0;
    }

    /**
     * Copy constructor for CitadelsState
     * @param original - the original GameState that the new one will be a copy of
     */
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
     * Methods to add or remove players
     * @param p
     * @return
     */
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

    /**
     * Getters and Setters
     */
    public ArrayList<CitadelsPlayer> getPlayers() { return players; }
    public void setPlayers(ArrayList<CitadelsPlayer> players) { this.players = players; }
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
    public ArrayList<Card> getCharacterDeck() { return characterDeck; }
    public ArrayList<Card> getDistrictDeck() { return districtDeck; }

    /**
     * Init function for the constructor
     */
    public void init() {
        //add character cards to deck

        /*under development
        Architect architect = new Architect();
        characterDeck.add(architect);
        */

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

    /**
     * Draws a random card from the deck
     * @return - the drawn card
     */
    public Card randomCard() {
        int i = (int) ((Math.random() * districtDeck.size()));
        Card card = districtDeck.get(i);
        return card;
    }

    /**
     * Calculates the score for every player in the game
     */
    public void calcScore() {
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

    /**
     * Adds gold to the player's coffers
     * @param p - the player in question
     * @return - success or failure depending on what phase of the turn it is
     */
    public boolean drawGold(CitadelsPlayer p) {
        if (turnPhase == 0) {
            p.addGold(2);
            turnPhase++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds two cards to the player's inventory
     * @param p - the player in question
     * @return - success or failure depending on what phase of the turn it is
     */
    public boolean drawCard(CitadelsPlayer p) {
        if (turnPhase == 0) {
            p.addToHand(randomCard());
            p.addToHand(randomCard());
            turnPhase++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes a card from the player's deck
     * @param p - the player
     * @param c - the card to be removed
     * @return - success or failure depending on what phase of the turn it is
     */
    public boolean removeCard(CitadelsPlayer p, Card c) {
        ArrayList<Card> d = p.getHand();
        if (d.contains(c)) {
            d.remove(c);
            return true;
        } else {
            return false;
        }
    }

    /**
     * "Builds" a district if the given conditions allow it
     * @param p - the player
     * @param c - the district card to be "built"
     * @return - success or failure depending on what phase of the turn it is or if the player has
     * enough gold to make the district
     */
    public boolean buildDistrict(CitadelsPlayer p, DistrictCard c) {
        if (turnPhase == 1) {
            if (p.getGold() >= c.getCost()) {
                p.removeFromHand(c);
                p.addToDistrict(c);
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

    /**
     * Removes a "built" district
     * @param p - the player
     * @param c - the card to be removed
     * @return - success or failure depending on what phase of the turn it is
     */
    public boolean removeDistrict(CitadelsPlayer p, DistrictCard c) {
        if (turnPhase == 1) {
            p.removeFromDistricts(c);
            turnPhase++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Uses the player character's ability. Currently they are all able to be used at any time.
     * @param p - the player (their character is stored here)
     * @return - success or failure depending on what phase of the turn it is
     */
    public boolean useAbility(CitadelsPlayer p) {
        //each character has their own ability
        //there are 18 of them
        //oh boy
        /*CharacterCard character = p.getCharacter();
        ArrayList<Card> districts = p.getDistricts();

        if (character instanceof Architect) {
            p.addToHand(randomCard());
            p.addToHand(randomCard());
            return true;
        }
        if (character instanceof Merchant) {
            for (int j = 0; j < districts.size(); j++) {
                for (int i = 0; i < districts.size(); i++) {
                    Card districtCard = districts.get(j);
                    if (districtCard instanceof GreenDistrict) {  // for every instance of trade districts
                        p.setGold(p.getGold() + 1);
                    }
                }
            }
            return true;
        }
        if (character instanceof Bishop) {
            for (int j = 0; j < districts.size(); j++) {
                for (int i = 0; i < districts.size(); i++) {
                    Card districtCard = districts.get(j);
                    if (districtCard instanceof BlueDistrict) {   // for every instance of religion districts
                        p.setGold(p.getGold() + 1);
                    }
                }
            }
            return true;
        }
        if (character instanceof Warlord) {
            for (int j = 0; j < districts.size(); j++) {
                for (int i = 0; i < districts.size(); i++) {
                    Card districtCard = districts.get(j);
                    if (districtCard instanceof RedDistrict) {   // for every instance of military districts
                        p.setGold(p.getGold() + 1);
                    }
                }
            }
            return true;
        }
        if (character instanceof King) {
            for (int j = 0; j < districts.size(); j++) {
                for (int i = 0; i < districts.size(); i++) {
                    Card districtCard = districts.get(j);
                    if (districtCard instanceof YellowDistrict) {   // for every instance of noble districts
                        p.setGold(p.getGold() + 1);
                    }
                }
            }
            return true;
        }
        return false;*/
        p.getCharacter().ability(this, p);
        return true;
    }

    /**
     * Ends the player's turn and advances the game.
     * @return - success or failure depending on what phase of the turn it is
     */
    public boolean endTurn() {
        if (turnPhase == 1 || turnPhase == 2) {
            turnPhase = 0;
            if (playerTurn < numPlayers) {
                playerTurn++;
                //trigger ready screen
            } else {
                playerTurn = 0;
                gamePhase = 0;
                //trigger the character select
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Basic toString method
     * @return - the values of all the instance variables
     */
    @Override
    public String toString() {
        return "CitadelsState{" +
                "numPlayers=" + numPlayers +
                ", gamePhase=" + gamePhase +
                ", playerTurn=" + playerTurn +
                ", turnPhase=" + turnPhase +
                ", characterDeck=" + characterDeck +
                ", districtDeck=" + districtDeck +
                ", highlightedCard=" + highlightedCard +
                ", players=" + players +
                ", (GameState) numSetupTurns=" + numSetupTurns +
                ", (GameState) currentSetupTurn=" + currentSetupTurn +
                '}';
    }
}
