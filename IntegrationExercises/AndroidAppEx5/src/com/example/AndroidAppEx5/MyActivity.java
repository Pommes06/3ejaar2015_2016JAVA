package com.example.AndroidAppEx5;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        BroadcastReceiver bcreceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(final Context context, final Intent intent) {
                Log.d("Ex6", "received the broadcast for time");
                TextView txtview = (TextView)findViewById(R.id.txtview);
                //txtview.setText(new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss").format(intent.getExtras().getString("date")));
                txtview.setText(intent.getExtras().getString("date"));
            }
        };
        registerReceiver(bcreceiver, new IntentFilter("currenttime"));
    }
}
