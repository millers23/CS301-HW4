package com.example.gamestatehw.citadels.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;

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

/**
 * A SurfaceView which allows which an animation to be drawn on it by a
 * Animator.
 *
 * @author Steve Vegdahl
 * @version 23 September 2016
 *
 *
 */
public class CitadelsDistrictView extends FlashSurfaceView {
    //Tag for logging
    private static final String TAG = "CitadelsSurfaceView";

    // some constants, which are percentages with respect to the minimum
    // of the height and the width. All drawing will be done in the "middle
    // square".
    //
    // The divisions both horizontally and vertically within the
    // playing square are:
    // - first square starts at 5% and goes to 33%
    // - second square starts at 36% and goes to 64%
    // - third square starts at 67& and goes to 95%
    // There is therefore a 5% border around the edges; each square
    // is 28% high/wide, and the lines between squares are 3%
    private final static float BORDER_PERCENT = 4; // size of the border
    private final static float SQUARE_SIZE_PERCENT = 20; // size of each of the cards
    private final static float LINE_WIDTH_PERCENT = 3; // width between cards
    private final static float SQUARE_DELTA_PERCENT = SQUARE_SIZE_PERCENT
            + LINE_WIDTH_PERCENT; // distance from left (or top) edge of square to the next one

    /*
     * Instance variables
     */

    // the game's state
    protected CitadelsState state;

    // the offset from the left and top to the beginning of our "middle square"; one
    // of these will always be zero
    protected float hBase;
    protected float vBase;

    // the size of one edge of our "middle square", or -1 if we have not determined
    // size
    protected float fullSquare;

    /**
     * Constructor for the CitadelsDistrictView class.
     *
     * @param context - a reference to the activity this animation is run under
     */
    public CitadelsDistrictView(Context context) {
        super(context);
        init();
    }// ctor

    /**
     * An alternate constructor for use when a subclass is directly specified
     * in the layout.
     *
     * @param context - a reference to the activity this animation is run under
     * @param attrs   - set of attributes passed from system
     */
    public CitadelsDistrictView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }// ctor

    /**
     * Helper-method for the constructors
     */
    private void init() {
        setBackgroundColor(backgroundColor());
    }// init


    public void setState(CitadelsState state) {
        this.state = state;
    }

    /**
     * @return the color to paint the lines separating cards
     */
    public int foregroundColor() {
        return Color.BLACK;
    }

    /**
     * @return the color to paint the lines separating cards
     */
    public int backgroundColor() {
        return Color.WHITE;
    }

    /**
     * callback method, called whenever it's time to redraw
     * frame
     *
     * @param g the canvas to draw on
     */
    public void onDraw(Canvas g) {

        // update the variables that relate
        // to the dimensions of the animation surface
        updateDimensions(g);

        // paint the TTT-board's horizontal and vertical lines
        Paint p = new Paint();
        p.setColor(foregroundColor());
        for (int i = 0; i <= 1; i++) {
            float variable1 = BORDER_PERCENT + SQUARE_SIZE_PERCENT
                    + (i * SQUARE_DELTA_PERCENT);
            float variable2 = variable1 + LINE_WIDTH_PERCENT;
            float fixed1 = BORDER_PERCENT;
            float fixed2 = 100 - BORDER_PERCENT;
            g.drawRect(h(variable1), v(fixed1), h(variable2), v(fixed2), p);
            g.drawRect(h(fixed1), v(variable1), h(fixed2), v(variable2), p);
        }

        // if we don't have any state, there's nothing more to draw, so return
        if (state == null) {
            return;
        }

        // for each square that has an X or O, draw it on the appropriate
        // place on the canvas
        CitadelsPlayer player = state.getPlayers().get(state.getWhoseMove());
        int red = 0;
        int blue = 0;
        int green = 0;
        int yellow = 0;
        int unique = 0;
        for (int j = 0; j < player.getDistricts().size(); j++) {
            ArrayList<Card> district = player.getDistricts();
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
        drawCard(g, red, blue, green, yellow, unique);
    }

    /**
     * update the instance variables that relate to the drawing surface
     *
     * @param g an object that references the drawing surface
     */
    private void updateDimensions(Canvas g) {

        // initially, set the height and width to be that of the
        // drawing surface
        int width = g.getWidth();
        int height = g.getHeight();

        // Set the "full square" size to be the minimum of the height and
        // the width. Depending on which is greater, set either the
        // horizontal or vertical base to be partway across the screen,
        // so that the "playing square" is in the middle of the screen on
        // its long dimension
        if (width > height) {
            fullSquare = height;
            vBase = 0;
            hBase = (width - height) / (float) 2.0;
        } else {
            fullSquare = width;
            hBase = 0;
            vBase = (height - width) / (float) 2.0;
        }

    }

    /**
     * Draw a symbol (X or O) on the canvas in a particular location
     *
     * @param g  the graphics object on which to draw
     * @param r  the number of red districts
     * @param b  the number of blue districts
     * @param gr the number of green districts
     * @param y  the number of yellow districts
     * @param u  the number of unique districts
     */
    protected void drawCard(Canvas g, int r, int b, int gr, int y, int u) {
        // set the paint color to be the foreground color
        Paint p = new Paint();
        p.setColor(foregroundColor());

        //paints
        Paint redPaint = new Paint();
        redPaint.setStyle(Paint.Style.FILL);
        redPaint.setColor(Color.RED);
        Paint bluePaint = new Paint();
        bluePaint.setStyle(Paint.Style.FILL);
        bluePaint.setColor(Color.BLUE);
        Paint greenPaint = new Paint();
        greenPaint.setStyle(Paint.Style.FILL);
        greenPaint.setColor(Color.GREEN);
        Paint yellowPaint = new Paint();
        yellowPaint.setStyle(Paint.Style.FILL);
        yellowPaint.setColor(Color.YELLOW);
        Paint uniquePaint = new Paint();
        uniquePaint.setStyle(Paint.Style.FILL);
        uniquePaint.setColor(getResources().getColor(R.color.Purple));

    }

    public Rect buildCard(Canvas g, int percentX, int percentY) {
        int len = (int)h(percentX);
        int wth = (int)v(percentY);
        int sql = (int)v(percentX + SQUARE_SIZE_PERCENT);
        int sqw = (int)v(percentY + SQUARE_SIZE_PERCENT);
        Rect card = new Rect(len, wth, sql, sqw);
        return card;
    }

    /**
     * maps a point from the canvas' pixel coordinates to "square" coordinates
     *
     * @param x the x pixel-coordinate
     * @param y the y pixel-coordinate
     * @return a Point whose components are in the range 0-2, indicating the
     * column and row of the corresponding square on the tic-tac-toe
     * board, or null if the point does not correspond to a square
     */
    public Point mapPixelToSquare(int x, int y) {

        // loop through each square and see if we get a "hit"; if so, return
        // the corresponding Point in "square" coordinates
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                float left = h(BORDER_PERCENT + (i * SQUARE_DELTA_PERCENT));
                float right = h(BORDER_PERCENT + SQUARE_SIZE_PERCENT
                        + (i * SQUARE_DELTA_PERCENT));
                float top = v(BORDER_PERCENT + (j * SQUARE_DELTA_PERCENT));
                float bottom = v(BORDER_PERCENT + SQUARE_SIZE_PERCENT
                        + (j * SQUARE_DELTA_PERCENT));
                System.out.println(left + " " + right + " " + top + " " + bottom);
                if ((x > left) != (x > right) && (y > top) != (y > bottom)) {
                    return new Point(i, j);
                }
            }
        }

        // no match: return null
        return null;
    }

    /**
     * helper-method to convert from a percentage to a horizontal pixel location
     *
     * @param percent the percentage across the drawing square
     * @return the pixel location that corresponds to that percentage
     */
    private float h(float percent) {
        return hBase + percent * fullSquare / 100;
    }

    /**
     * helper-method to convert from a percentage to a vertical pixel location
     *
     * @param percent the percentage down the drawing square
     * @return the pixel location that corresponds to that percentage
     */
    private float v(float percent) {
        return vBase + percent * fullSquare / 100;
    }

}