package com.example.gamestatehw.citadels.views;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.gamestatehw.GameFramework.utilities.FlashSurfaceView;
import com.example.gamestatehw.R;
import com.example.gamestatehw.citadels.cards.Card;
import com.example.gamestatehw.citadels.cards.UniqueDistrictCard;
import com.example.gamestatehw.citadels.cards.districtCards.BlueDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.GreenDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.RedDistrict;
import com.example.gamestatehw.citadels.cards.districtCards.YellowDistrict;
import com.example.gamestatehw.citadels.infoMessage.CitadelsState;
import com.example.gamestatehw.citadels.players.CitadelsPlayer;

import java.util.ArrayList;

public class CitadelsDeckView extends FlashSurfaceView implements View.OnClickListener {

    protected CitadelsState state;

    /**
     * Constructor for CitadelsDeckView, inherits from FlashSurfaceView
     * @param context
     */
    public CitadelsDeckView(Context context) {
        super(context);
        //this.setContentView(R.layout.cit_player_view);
    }

    /**
     * Constructor for CitadelsDeckView, inherits from FlashSurfaceView
     * @param context
     * @param attrs
     */
    public CitadelsDeckView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //this.setContentView(R.layout.cit_player_view);
    }

    /**
     * Displays how many of each district the player has made
     * @param p - CitadelsPlayer whose current turn it is
     */
    private void drawBuilt(CitadelsPlayer p) {
        TextView rDist = findViewById(R.id.redDistrict);
        TextView bDist = findViewById(R.id.blueDistrict);
        TextView gDist = findViewById(R.id.greenDistrict);
        TextView yDist = findViewById(R.id.yellowDistrict);
        TextView pDist = findViewById(R.id.purpleDistrict);

        int red = 0;
        int blue = 0;
        int green = 0;
        int yellow = 0;
        int unique = 0;
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

        rDist.setText("Military Districts: "+red);
        bDist.setText("Religious Districts: "+blue);
        gDist.setText("Merchant Districts: "+green);
        yDist.setText("Noble Districts: "+yellow);
        pDist.setText("Unique Districts: "+unique);
    }

    /**
     * Draws the cards in the players' deck
     * @param p - CitadelsPlayer whose current turn it is
     */
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
                    cards[i].setVisibility(View.VISIBLE);
                    cards[i].setImageResource(R.drawable.card_3);
                } else if (c instanceof BlueDistrict) {
                    cards[i].setVisibility(View.VISIBLE);
                    cards[i].setImageResource(R.drawable.card_1);
                } else if (c instanceof GreenDistrict) {
                    cards[i].setVisibility(View.VISIBLE);
                    cards[i].setImageResource(R.drawable.card_2);
                } else if (c instanceof YellowDistrict) {
                    cards[i].setVisibility(View.VISIBLE);
                    cards[i].setImageResource(R.drawable.card_0);
                }
            }
            else {
                cards[i].setVisibility(View.INVISIBLE);
            }
        }
    }

    /**
     * Basic setter for the GameState
     * @param state - a copy of the current gamestate
     */
    public void setState(CitadelsState state) {
        this.state = state;
    }

    /**
     * Updates the drawn deck, built cards, and invalidates the view when a button is clicked
     * @param v - the view that has been clicked
     */
    @Override
    public void onClick(View v) {
        CitadelsPlayer p = state.getPlayers().get(state.getWhoseMove());
        drawBuilt(p);
        drawDeck(p);
        v.invalidate();
    }
}
