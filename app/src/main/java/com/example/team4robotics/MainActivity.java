package com.example.team4robotics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {

    private Button buttonW;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonW = (Button) findViewById(R.id.buttonWelcome);

        buttonW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAllFloorsActivity();
            }
        });

    }
    public void openAllFloorsActivity() {

        Intent intent = new Intent(this, LanguageActivity.class);
        startActivity(intent);
    }
}