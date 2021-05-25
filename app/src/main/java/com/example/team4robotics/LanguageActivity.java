package com.example.team4robotics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LanguageActivity extends AppCompatActivity {

    private Button buttonE;
    private Button buttonK;
    private Button buttonF;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        buttonE = (Button) findViewById(R.id.buttonEnglish);
        buttonK = (Button) findViewById(R.id.buttonKorean);
        buttonF = (Button) findViewById(R.id.buttonFrench);

        buttonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAllFloorsActivity();
            }
        });
        buttonK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAllFloorsActivity();
            }
        });
        buttonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAllFloorsActivity();
            }
        });
    }
    public void openAllFloorsActivity() {

        Intent intent = new Intent(this, AllFloorsActivity.class);
        startActivity(intent);
    }
}