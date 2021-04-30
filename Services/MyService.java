package com.example.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    MediaPlayer mediaPlayer;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"on Create in service was called",Toast.LENGTH_SHORT).show();
        mediaPlayer= MediaPlayer.create(this,R.raw.jistarah);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        Toast.makeText(this,"On Destroy in Service was called",Toast.LENGTH_SHORT).show();

    }


}