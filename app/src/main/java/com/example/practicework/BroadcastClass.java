package com.example.practicework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadcastClass extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "Broadcast Reciever Started", Toast.LENGTH_SHORT).show();
    }
}
