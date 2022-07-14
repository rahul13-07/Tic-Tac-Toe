package com.rahultyagi.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button start;
    EditText editText1,editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.start);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                String player1 = editText1.getText().toString();
                String player2 = editText2.getText().toString();
                intent.putExtra("Player1",player1);
                intent.putExtra("Player2",player2);
                if(player1.equals("") || player2.equals("")){
                    Toast.makeText(MainActivity.this, "Please Enter Name", Toast.LENGTH_SHORT).show();
                }
                else
                    startActivity(intent);
            }
        });
    }
}