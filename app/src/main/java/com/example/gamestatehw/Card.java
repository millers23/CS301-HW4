/**
 * Card class for the game, will be split into subclasses later
 *
 * @author Sebastian Miller, Kyle Mayhead, Daniel Lee, Axl Martinez-Ibarra
 */
package com.example.gamestatehw;
//subclasses are go-to
//behaviours: don't do all on the first pass, only change turn order
//            check base functionality
//            add behaviours
public class Card {
    //instance variables
    private int cost;
    private String name;
    private int type;

    //constructor
    public Card(String n, int c, int t) {
        cost = c;
        name = n;
        type = t;
    }

    /**
     * The methods in this class are almost exclusively Getters and Setters
     */
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

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
