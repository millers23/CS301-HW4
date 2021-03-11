package com.example.gamestatehw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Player player1 = new Player("player1");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GameState gameState = new GameState();
        TextView editText = (TextView)findViewById(R.id.edittext);
        Button buttonRunTest = (Button)findViewById(R.id.buttonRunTest);
        buttonRunTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
                GameState firstInstance = new GameState();
                GameState secondInstance = new GameState(firstInstance);




                //editText.
            }
        });
    }



}