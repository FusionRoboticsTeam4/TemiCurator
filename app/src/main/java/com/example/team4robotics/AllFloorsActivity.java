package com.example.team4robotics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AllFloorsActivity extends AppCompatActivity {

    private Button button1F;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_floors);

        button1F = (Button) findViewById(R.id.buttonFirstFloor);

        button1F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFirstFloorActivity();
            }
        });
    }

    private void openFirstFloorActivity() {
        Intent intent = new Intent(this, FirstFloorActivity.class);
        startActivity(intent);
    }
}