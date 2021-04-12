package com.example.gamestatehw.citadels.cards.characterCards;

import android.util.Log;

import com.example.gamestatehw.citadels.cards.CharacterCard;

public class TaxCollector extends CharacterCard {
    public TaxCollector() {
        super("TaxCollector",
                0,
                "When the Tax Collector is one of the characters in the game, \n" +
                        "players are charged a property tax for building districts. \n" +
                        "Immediately after a player builds a district, he places one gold \n" +
                        "from his stash on the Tax Collector’s character token. This \n" +
                        "applies even when a player builds a district that he has not paid \n" +
                        "to build. If a player builds more than one district, he is charged \n" +
                        "the property tax for each district built. If a player has no gold \n" +
                        "remaining in his stash after building a district, he is not charged\n" +
                        "a tax. The Tax Collector himself is not charged a tax.\n" +
                        "At any time during your turn, you can take all gold from the Tax \n" +
                        "Collector’s character token into your stash.\n" +
                        "Even if the Tax Collector does not appear during a round \n" +
                        "(because it was not chosen, it was discarded at the start of the \n" +
                        "selection phase, or it was killed by the Assassin), players are \n" +
                        "always charged a tax, and any gold left on the Tax Collector’s \n" +
                        "token carries over to the next round. \n" +
                        "In 2- and 3-player games, a player who chooses the Tax\n" +
                        "Collector as one of his characters is still charged a tax for his \n" +
                        "other character.\n" +
                        "If the Magistrate confiscates a district from a player, the \n" +
                        "Magistrate is charged the tax, not his target.",
                1,
                9);
    }

    @Override
    public void ability() {
        Log.d("TaxCollector","Override works");
    }
}