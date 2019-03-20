package com.example.ma18_broadcastreciver;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver br1 = new MyFirstReceiver();
    BroadcastReceiver br2 = new MySecondReceiver();
    BroadcastReceiver br3 = new MyThirdReceiver();

    LocalBroadcastManager localBrManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        localBrManager = LocalBroadcastManager.getInstance(this);

//        BroadcastReceiver br = new MyFirstReceiver();
//       // IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
//       // filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
//        IntentFilter filter = new IntentFilter();
//        filter.addAction("my.custom.action.name");
//        registerReceiver(br, filter);

    }

    @Override
    protected void onResume() {
        super.onResume();

        //receiver 1

        // IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        // filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        IntentFilter filter1 = new IntentFilter();
        filter1.addAction("my.custom.action.name");
        filter1.setPriority(50);
        //registerReceiver(br1, filter1);
        localBrManager.registerReceiver(br1, filter1);


        IntentFilter filter3 = new IntentFilter();
        filter3.addAction("my.custom.action.name");
        filter3.setPriority(30);
       // registerReceiver(br3, filter3);
        localBrManager.registerReceiver(br3, filter3);



        IntentFilter filter2 = new IntentFilter();
        filter2.addAction("my.custom.action.name");
        filter2.setPriority(1);
       // registerReceiver(br2, filter2);
        localBrManager.registerReceiver(br2, filter2);
    }


    @Override
    protected void onPause() {
        super.onPause();
//        unregisterReceiver(br1);
//        unregisterReceiver(br2);
//        unregisterReceiver(br3);
    }



    public void sendBroadcast(View view) {

        Intent intent = new Intent("my.custom.action.name");
        intent.putExtra("name", "David");

        //sendBroadcast(intent);
       // sendOrderedBroadcast(intent, null);

        localBrManager.sendBroadcast(intent);

    }
}
