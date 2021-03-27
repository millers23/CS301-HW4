package com.example.gamestatehw.cards;

public enum CharacterCards {;
    ASSASSIN("Assassin", "stone cold killer", 1, 1, 1);

    private final String name;
    private final String desc;
    private final int type;
    private final int uph;
    private final int num;

    CharacterCards(String name, String desc, int type, int uph, int num) {
        this.name = name;
        this.desc = desc;
        this.type = type;
        this.uph = uph;
        this.num = num;
    }
}