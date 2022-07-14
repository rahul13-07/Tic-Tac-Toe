package com.rahultyagi.tictactoe;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import javax.net.ssl.SSLEngineResult;

public class ThirdActivity extends AppCompatActivity {
    TextView winner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        winner = findViewById(R.id.winner);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String status = intent.getStringExtra("Winner");
        winner.setText(status);
    }
}