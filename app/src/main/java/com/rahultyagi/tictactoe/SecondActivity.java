package com.rahultyagi.tictactoe;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    MediaPlayer ring;
    String player1,player2;

    // 0 - X
    // 1 - O
    int activePlayer = 0;

    boolean win = false;

    boolean gameActive = true;

    int gameState[] = {2,2,2,2,2,2,2,2,2};
    // 2 - null

    int winPosition[][] = {{0,1,2},{3,4,5},{6,7,8},
                           {0,3,6},{1,4,7},{2,5,8},
                           {0,4,8},{2,4,6}};

    public void playerTap(View view){
        ImageView image = (ImageView)view;
        TextView textView = findViewById(R.id.status);
        int tapImage = Integer.parseInt(image.getTag().toString());
        ring = MediaPlayer.create(getApplicationContext(),R.raw.cheer);

        if(!gameActive){
            ring.stop();
            ring.release();
            gameReset(view);
        }

        else if(gameState[tapImage] == 2) {
            gameState[tapImage] = activePlayer;
            image.setTranslationY(-1000f);
            if (activePlayer == 0) {
                image.setImageResource(R.drawable.x);
                activePlayer = 1;
                textView.setText(player2 + "'s turn - Tap to play");
            }
            else {
                image.setImageResource(R.drawable.o);
                activePlayer = 0;
                textView.setText(player1 + "'s turn - Tap to play");
            }
               //winPosition[][]
            image.animate().translationYBy(1000f).setDuration(300);
        }
        // image.setEnabled(false);
        // winning checking !!!!!
        for(int[] winPos : winPosition){
            if(gameState[winPos[0]] == gameState[winPos[1]] && gameState[winPos[1]] == gameState[winPos[2]] && gameState[winPos[0]] != 2){
                // Somebody won
                String winnerStr;
                if(gameState[winPos[0]] == 0){
                    winnerStr = player1 + " has Won";
                }
                else{
                    winnerStr = player2 + " has Won";
                }
                //textView.setText(winnerStr);
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                intent.putExtra("Winner",winnerStr.toUpperCase());
                startActivity(intent);
                gameActive = false;
                win = true;
                ring.start();
            }
        }
        int flag=0;
        for(int i=0;i<gameState.length;i++){
            if(gameState[i] == 2){
                flag = 1;
                break;
            }
        }
        if(flag != 1 && win != true){
           // textView.setText("Tie");
            Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
            intent.putExtra("Winner","TIE");
            startActivity(intent);
            gameActive = false;
        }
    }
    public void gameReset(View view){
        gameActive = true;
        activePlayer = 0;
        win = false;

        TextView textView = findViewById(R.id.status);
        textView.setText(player1 + "'s turn - Tap to play");

        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }

        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        player1 = intent.getStringExtra("Player1");
        player2 = intent.getStringExtra("Player2");
        TextView textView = findViewById(R.id.status);
        textView.setText(player1 + "'s turn - Tap to play");
    }
}