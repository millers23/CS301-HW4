package com.example.gamestatehw.citadels.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.gamestatehw.GameFramework.utilities.FlashSurfaceView;
import com.example.gamestatehw.R;

public class CitadelsCSSView extends FlashSurfaceView implements Spinner.OnItemSelectedListener {

    public CitadelsCSSView(Context context) {
        super(context);
    }

    public CitadelsCSSView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (view.getId() == R.id.charSpinner) {

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        return;
    }
}
