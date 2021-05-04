package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {

    private static final String TAG="MyReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String actionstring = intent.getAction();
        Toast.makeText(context,actionstring, Toast.LENGTH_LONG).show();
        boolean isOn= intent.getBooleanExtra("state",false);
        Log.d(TAG, "onReceive: "+isOn);

    }
}