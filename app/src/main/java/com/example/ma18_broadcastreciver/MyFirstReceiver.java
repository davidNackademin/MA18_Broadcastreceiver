package com.example.ma18_broadcastreciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyFirstReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String name = intent.getStringExtra("name");

        Log.d("!!!", "Hello from 1st reciver");
        Toast.makeText(context, "Hello" + name + "from 1st receiver", Toast.LENGTH_SHORT).show();
    }



}
