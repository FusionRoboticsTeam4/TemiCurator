package com.example.team4robotics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AllFloorsActivity extends AppCompatActivity {

    TextView crowd;
    String status;
    DatabaseReference dref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_floors);

        Button button1R = (Button) findViewById(R.id.buttonFirstRoom);
        button1R.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openFirstRoomActivity();
            }
        });

        Button button2R = (Button) findViewById(R.id.buttonSecondRoom);

        button2R.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openSecondRoomActivity();
            }
        });

        crowd = (TextView) findViewById(R.id.roomCrowd);
        dref = FirebaseDatabase.getInstance().getReference();
        // Read from the database
        dref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot){
                status = dataSnapshot.child("crowd").getValue().toString();
                crowd.setText(status);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError){
                
            }

        });
    }

    private void openFirstRoomActivity() {
        Intent intent = new Intent(this, FirstRoomActivity.class);
        startActivity(intent);
    }
    private void openSecondRoomActivity() {
        Intent intent = new Intent(this, SecondRoomActivity.class);
        startActivity(intent);
    }
}