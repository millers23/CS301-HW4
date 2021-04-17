package com.example.gamestatehw.citadels.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gamestatehw.GameFramework.utilities.FlashSurfaceView;
import com.example.gamestatehw.R;
import com.example.gamestatehw.citadels.cards.Card;
import com.example.gamestatehw.citadels.infoMessage.CitadelsState;

import java.util.ArrayList;

public class CitadelsCSSView extends FlashSurfaceView implements Spinner.OnItemSelectedListener {

    private TextView playerName = findViewById(R.id.playerName);
    private CitadelsState state;

    public CitadelsCSSView(Context context) {
        super(context);
    }

    public CitadelsCSSView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ArrayList<String> characters = null;
        for (int i = 0; i < state.getCharacterDeck().size(); i++) {
            characters.add(state.getCharacterDeck().get(i).getName());
        }
        if (view.getId() == R.id.charSpinner) {
            Spinner spinner = findViewById(R.id.charSpinner);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_dropdown_item, characters);
            spinner.setAdapter(arrayAdapter);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        return;
    }
}
