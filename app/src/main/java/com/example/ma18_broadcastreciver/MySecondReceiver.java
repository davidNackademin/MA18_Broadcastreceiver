package com.example.ma18_broadcastreciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MySecondReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("!!!", "Hello from secondreceiver");
        Toast.makeText(context, "Hello from 2:nd", Toast.LENGTH_SHORT).show();

    }
}
