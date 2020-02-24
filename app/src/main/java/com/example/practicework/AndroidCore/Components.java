package com.example.practicework.AndroidCore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telecom.Connection;
import android.telecom.ConnectionRequest;
import android.view.View;
import android.widget.Button;

import com.example.practicework.BroadcastClass;
import com.example.practicework.R;
import com.example.practicework.ServiceClass;

public class Components extends AppCompatActivity {

    Button servicestart,servicestop,broadcast;
    BroadcastClass broadcastClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_components);

        servicestart=findViewById(R.id.servicestart);
        broadcast=findViewById(R.id.broadcast);
        servicestop=findViewById(R.id.stopservice);

        servicestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getApplicationContext(), ServiceClass.class));
            }
        });

        servicestop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getApplicationContext(), ServiceClass.class));
            }
        });


        broadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                broadcastClass=new BroadcastClass();

                registerReceiver(broadcastClass,new IntentFilter("com.example.practicework.CustomIntent"));
                Intent intent=new Intent();
                intent.setAction("com.example.practicework.CustomIntent");
                sendBroadcast(intent);
            }
        });
    }
}
