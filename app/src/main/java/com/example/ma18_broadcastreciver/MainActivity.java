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

    // skapa instanser av våra Broadcastreceivers
    BroadcastReceiver br1 = new MyFirstReceiver();
    BroadcastReceiver br2 = new MySecondReceiver();
    BroadcastReceiver br3 = new MyThirdReceiver();

    LocalBroadcastManager localBrManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // om vi vill skicka vår broadcasts bara internt i appen så kan vi använda en localBroadcastmanager
        localBrManager = LocalBroadcastManager.getInstance(this);



        // registrera en broadcastreceiver som reagerar varje gång vi ändrar till/från flygplansläge
//        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
//        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
//        registerReceiver(br1, filter);

    }

    @Override
    protected void onResume() {
        super.onResume();

       // registrera våra 3 st broadcastrecivers

        // IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        // filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        IntentFilter filter1 = new IntentFilter();
        // vilket meddelande ska broadcastrecivern reagera på: välj själv my.custom.action.name
        filter1.addAction("my.custom.action.name");
        filter1.setPriority(50);

        // registrera globalt
        //registerReceiver(br1, filter1);
        //registrera lokalt (bara inuti denna app)
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

        // avregistrera våra broadcastrecivers

        //globalt
//        unregisterReceiver(br1);
//        unregisterReceiver(br2);
//        unregisterReceiver(br3);

        //lokalt
        localBrManager.unregisterReceiver(br1);
        localBrManager.unregisterReceiver(br2);
        localBrManager.unregisterReceiver(br3);
    }



    public void sendBroadcast(View view) {

        Intent intent = new Intent("my.custom.action.name");
        intent.putExtra("name", "David");

        // skicka ut broadcast meddelanden

        // andtingen globalt
        //sendBroadcast(intent);

        // globalt i bestämd ordning
       // sendOrderedBroadcast(intent, null);

        // eller lokalt
        localBrManager.sendBroadcast(intent);

    }
}
