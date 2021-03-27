package com.example.gamestatehw.cards;

import android.graphics.Color;

public class DistrictCard extends Card {
    private int cost;
    private String description;
    private Color color;

    public DistrictCard(String n, int t, String d, int c, Color cl) {
        super(n, t, d);
        cost = c;
        color = cl;
    }
}
