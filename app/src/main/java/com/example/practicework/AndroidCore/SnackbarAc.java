package com.example.practicework.AndroidCore;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.practicework.R;
import com.google.android.material.snackbar.Snackbar;

public class SnackbarAc extends AppCompatActivity {

    Button snackbar1,snackbar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);

        snackbar1=findViewById(R.id.snackbar1);
        snackbar2=findViewById(R.id.snackbar2);

        snackbar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar=Snackbar.make(findViewById(R.id.snackbarparent),"Here is a sample snackbar",Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        });

        snackbar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar=Snackbar.make(findViewById(R.id.snackbarparent),"Sample View Snackbar",Snackbar.LENGTH_SHORT)
                        .setAction("Retry", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Snackbar snac=Snackbar.make(findViewById(R.id.snackbarparent),"Here is a sample snackbar",Snackbar.LENGTH_SHORT);
                                snac.show();

                            }
                        });

                View view=snackbar.getView();
                snackbar.setActionTextColor(Color.YELLOW);
                TextView t=view.findViewById(R.id.snackbar_text);

                t.setText("Changed text");
                t.setTextColor(Color.RED);
                snackbar.show();
            }
        });
    }
}
