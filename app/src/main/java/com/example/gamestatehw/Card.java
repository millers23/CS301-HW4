package com.example.gamestatehw;

public class Card {
    private int cost;
    private String name;
    private int type;

    public Card(int c, String n, int t) {
        cost = c;
        name = n;
        type = t;
    }

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
