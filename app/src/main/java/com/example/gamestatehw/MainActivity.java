package com.example.gamestatehw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        GameState gameState = new GameState();
        Player player1 = new Player("player1");

        TextView editText = (TextView)findViewById(R.id.edittext);
        Button buttonRunTest = (Button)findViewById(R.id.buttonRunTest);
        buttonRunTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
                GameState firstInstance = new GameState();
                GameState secondInstance = new GameState(firstInstance);

                if(firstInstance.drawGold(player1)){
                    editText.append("Player one Drew Gold! ");
                }
                else {
                    editText.append("You cannot draw gold at this moment. ");
                }

                if(firstInstance.drawCard(player1)){
                    editText.append("Player one drew a card!");
                }
                else {
                    editText.append("You cannot draw a card At this moment. ");
                }

                /*if(firstInstance.buildDistrict(player1,card1)){
                    editText.append("Player One built district ");
                }

                if(firstInstance.removeDistrict(player1,card1)){
                    editText.append("Player one removed district ");
                }*/


               if(firstInstance.useAbility(player1)){
                    editText.append("Player one used ability ");
               }


                if(firstInstance.endTurn()){
                    editText.append("Player one ended turn ");
                }

                GameState thirdInstance = new GameState();
                GameState forthInstance = new GameState(thirdInstance);


                editText.append(secondInstance.toString());
                editText.append(forthInstance.toString());

            }
        });
    }



}