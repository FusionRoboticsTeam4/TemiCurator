package com.example.team4robotics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstRoomActivity extends AppCompatActivity {

    private Button buttonArt4;
    private Button buttonArt3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_room);

        buttonArt4 = (Button) findViewById(R.id.button4);

        buttonArt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openArtWorkInformation();
            }
        });
        buttonArt3 = (Button) findViewById(R.id.button3);

        buttonArt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openArtWorkInformation();
            }
        });
    }

    private void openArtWorkInformation() {

        Intent intent = new Intent(this, ArtWorkInformation.class);
        startActivity(intent);
    }
}