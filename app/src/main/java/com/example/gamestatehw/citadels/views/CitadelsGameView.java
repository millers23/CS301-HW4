package com.example.gamestatehw.citadels.views;

import android.content.Context;
import android.util.AttributeSet;

import com.example.gamestatehw.citadels.infoMessage.CitadelsState;

public class CitadelsGameView {
    //Tag for logging
    private static final String TAG = "CitadelsGameView";

    // the game's state
    protected CitadelsState state;

    /**
     * Constructor for the CitadelsGameView class.
     *
     * @param context - a reference to the activity this animation is run under
     */
    public CitadelsGameView(Context context) {
        super(context);
        init();
    }

    /**
     * An alternate constructor for use when a subclass is directly specified
     * in the layout.
     *
     * @param context - a reference to the activity this animation is run under
     * @param attrs   - set of attributes passed from system
     */
    public CitadelsGameView(Context context, AttributeSet attrs) {
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
}
