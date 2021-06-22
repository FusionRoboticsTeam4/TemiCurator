package com.example.team4robotics;

import android.util.Log;
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

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

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
        /*dref = FirebaseDatabase.getInstance().getReference("Crowds/Room1");

        // Read from the database
        dref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot){
                status = dataSnapshot.getValue().toString();
                crowd.setText(status);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError){
                
            }

        });*/
        database.getReference("Crowds/Room1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Object mytext = snapshot.getValue();
                crowd.setText("Crowd:" + mytext.toString());
                Log.d("tag", "crowd is " + mytext);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("tag", "Failed",error.toException());
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


    /*myRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            // This method is called once with the initial value and again
            // whenever data at this location is updated.
            String value = dataSnapshot.getValue(String.class);
            Log.d(TAG, "Value is: " + value);
        }

        @Override
        public void onCancelled(DatabaseError error) {
            // Failed to read value
            Log.w(TAG, "Failed to read value.", error.toException());
        }
    });*/
}