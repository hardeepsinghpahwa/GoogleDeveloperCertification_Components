package com.example.practicework.AndroidCore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.practicework.BroadcastClass;
import com.example.practicework.MainActivity;
import com.example.practicework.R;

import static android.provider.ContactsContract.Intents.Insert.ACTION;

public class Notification extends AppCompatActivity {

    Button noti,notiwithbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        noti=findViewById(R.id.basicnoti);
        notiwithbutton=findViewById(R.id.notibutton);

        noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager manager= (NotificationManager) getSystemService(getApplicationContext().NOTIFICATION_SERVICE);

                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(),0,intent,0);
                NotificationCompat.Builder builder=new NotificationCompat.Builder(Notification.this,"Noti_id");
                builder.setContentTitle("Here is A Sample Notification")
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentText("Sample Notification Created")
                        .setContentIntent(pendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                if(Build.VERSION.SDK_INT >Build.VERSION_CODES.O)
                {
                    NotificationChannel channel=new NotificationChannel("Noti_id","Notifications",NotificationManager.IMPORTANCE_HIGH);
                    channel.setDescription("Notification Channel");

                    manager.createNotificationChannel(channel);
                }

                manager.notify(0,builder.build());


            }
        });


        notiwithbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager manager= (NotificationManager) getSystemService(getApplicationContext().NOTIFICATION_SERVICE);

                Intent intent=new Intent(getApplicationContext(), BroadcastClass.class);
                intent.setAction(Intent.ACTION_ANSWER);
                intent.putExtra("noti_id",0);
                PendingIntent pendingIntent=PendingIntent.getBroadcast(getApplicationContext(),0,intent,0);
                NotificationCompat.Builder builder=new NotificationCompat.Builder(Notification.this,"Noti_id");
                builder.setContentTitle("Here is A Sample Notification")
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentText("Sample Notification Created")
                        .setContentIntent(pendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .addAction(R.drawable.ic_launcher_background,"Action",pendingIntent);

                if(Build.VERSION.SDK_INT >Build.VERSION_CODES.O)
                {
                    NotificationChannel channel=new NotificationChannel("Noti_id","Notifications",NotificationManager.IMPORTANCE_HIGH);
                    channel.setDescription("Notification Channel");

                    manager.createNotificationChannel(channel);
                }

                manager.notify(0,builder.build());
            }
        });
    }
}
