package com.example.gamestatehw.citadels.cards;

public class DistrictCard extends Card {
    private int cost;
    private String description;
    private int color;

    public DistrictCard(String n, int t, String d, int c, int cl) {
        super(n, t, d);
        cost = c;
        color = cl;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
