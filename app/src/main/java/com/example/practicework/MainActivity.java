 package com.example.practicework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.practicework.AndroidCore.Components;
import com.example.practicework.AndroidCore.Localisation;
import com.example.practicework.AndroidCore.Notification;
import com.example.practicework.AndroidCore.SnackbarAc;
import com.example.practicework.AndroidCore.ToastAc;
import com.google.android.material.snackbar.Snackbar;

 public class MainActivity extends AppCompatActivity {

    Button toast,snackbar,localise,components,notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toast=findViewById(R.id.toast);
        snackbar=findViewById(R.id.snackbar);
        localise=findViewById(R.id.localise);
        components=findViewById(R.id.components);
        notification=findViewById(R.id.noti);

        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ToastAc.class));
            }
        });

        snackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SnackbarAc.class));
            }
        });

        localise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Localisation.class));
            }
        });

        components.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Components.class));
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Notification.class));
            }
        });
    }
}
