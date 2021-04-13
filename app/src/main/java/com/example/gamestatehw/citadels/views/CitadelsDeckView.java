package com.example.gamestatehw.citadels.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.example.gamestatehw.GameFramework.actionMessage.BuildDistrictAction;
import com.example.gamestatehw.GameFramework.actionMessage.DrawCardAction;
import com.example.gamestatehw.GameFramework.actionMessage.DrawGoldAction;
import com.example.gamestatehw.GameFramework.actionMessage.EndTurnAction;
import com.example.gamestatehw.GameFramework.actionMessage.GameAction;
import com.example.gamestatehw.GameFramework.actionMessage.RemoveDistrictAction;
import com.example.gamestatehw.GameFramework.actionMessage.UseAbilityAction;
import com.example.gamestatehw.GameFramework.infoMessage.GameState;
import com.example.gamestatehw.GameFramework.utilities.FlashSurfaceView;
import com.example.gamestatehw.R;
import com.example.gamestatehw.citadels.cards.Card;
import com.example.gamestatehw.citadels.cards.DistrictCard;
import com.example.gamestatehw.citadels.cards.districtCards.BlueDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.GreenDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.RedDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.YellowDistrict;
import com.example.gamestatehw.citadels.infoMessage.CitadelsState;
import com.example.gamestatehw.citadels.players.CitadelsPlayer;

import java.util.ArrayList;

public class CitadelsDeckView extends FlashSurfaceView {

    protected CitadelsState state;

    public CitadelsDeckView(Context context) {
        super(context);
    }

    public CitadelsDeckView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void drawDeck(CitadelsPlayer p) {
        ImageView card1 = findViewById(R.id.hand1);
        ImageView card2 = findViewById(R.id.hand2);
        ImageView card3 = findViewById(R.id.hand3);
        ImageView card4 = findViewById(R.id.hand4);
        ImageView card5 = findViewById(R.id.hand5);
        ImageView card6 = findViewById(R.id.hand6);
        ImageView card7 = findViewById(R.id.hand7);
        ImageView card8 = findViewById(R.id.hand8);

        ImageView[] cards = new ImageView[]{card1,card2,card3,card4,card5,card6,card7,card8};

        ArrayList<Card> deck = p.getHand();
        for (int i = 0; i < 8; i++) {
            if (i < deck.size()) {
                Card c = deck.get(i);
                if (c instanceof RedDistrict) {
                    cards[i].setImageResource(R.drawable.card_3);
                } else if (c instanceof BlueDistrict) {
                    cards[i].setImageResource(R.drawable.card_1);
                } else if (c instanceof GreenDistrict) {
                    cards[i].setImageResource(R.drawable.card_2);
                } else if (c instanceof YellowDistrict) {
                    cards[i].setImageResource(R.drawable.card_0);
                }
            }
            else {
                cards[i].setImageResource(android.R.color.transparent);
            }
        }
        invalidate();
    }

    public void setState(CitadelsState state) {
        this.state = state;
    }
}
