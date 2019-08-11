package com.nelson.aimitproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class SendNotifications extends AppCompatActivity {
    EditText notifSend;
    Button btnSendnotif;
    Calendar c;
    String days,hours,mins,times,notimsg;
    FirebaseDatabase database;
    DatabaseReference ref;
    Notisend notisend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_notifications);
        notifSend = findViewById(R.id.etNotype);
        btnSendnotif = findViewById(R.id.btnSend);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("notifs");
        notisend = new Notisend();

    }
    private void getValues(){
        notisend.setTextsend(notifSend.getText().toString());
        c = Calendar.getInstance();
        notisend.setDays(c.getTime().toString());

        hours = String.valueOf(c.get(Calendar.HOUR));
        mins = String.valueOf(c.get(Calendar.MINUTE));
        times = hours+":"+mins;
        notisend.setTimes(times);

    }

    public void btnInsert(View v){
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getValues();
                ref.child("user4").setValue(notifSend);
                Toast.makeText(SendNotifications.this, "fggvhvhj", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
