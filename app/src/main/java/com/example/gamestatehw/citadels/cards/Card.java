/**
 * Card class for the game, will be split into subclasses later
 *
 * @author Sebastian Miller, Kyle Mayhead, Daniel Lee, Axl Martinez-Ibarra
 */
package com.example.gamestatehw.citadels.cards;
//subclasses are go-to
//behaviours: don't do all on the first pass, only change turn order
//            check base functionality
//            add behaviours
public class Card {
    //instance variables
    private String name;
    private int type;
    private String description;
    //image goes here

    //constructor
    public Card(String n, int t, String d) {
        name = n;
        type = t;
        description = d;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
