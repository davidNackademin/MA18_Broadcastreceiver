package com.example.ma18_broadcastreciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyThirdReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("!!!", "Hello from third receiver");
        Toast.makeText(context, "Hello from 3:d", Toast.LENGTH_SHORT).show();

        //abortBroadcast();

    }
}