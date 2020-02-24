package com.example.practicework.AndroidCore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practicework.R;

public class ToastAc extends AppCompatActivity {


    Button t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);


        t1=findViewById(R.id.toast1);
        t2=findViewById(R.id.toast2);
        t3=findViewById(R.id.toast3);


        final Toast toast1= Toast.makeText(getApplicationContext(),"Here is a sample Toast",Toast.LENGTH_SHORT);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast1.show();
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast1.setGravity(Gravity.TOP|Gravity.LEFT,0,0);
                toast1.show();
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View view= LayoutInflater.from(getApplicationContext()).inflate(R.layout.customtoast,(ViewGroup) findViewById(R.id.toastroot));

                TextView t=(TextView) view.findViewById(R.id.toasttext);
                t.setText("This is a sample Custom Toast");
                Toast toast2=new Toast(getApplicationContext());
                toast2.setDuration(Toast.LENGTH_SHORT);
                toast2.setView(view);
                toast2.show();

            }
        });
    }
}
