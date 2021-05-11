package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
         Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name= "myChannel";
            String description="Channel for Notification";
            NotificationChannel channel= new NotificationChannel("my-channel-1",name,NotificationManager.IMPORTANCE_DEFAULT );
            channel.setDescription(description);
            NotificationManager manager= getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        btn= findViewById(R.id.button);
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String msg="You have a new Message from Annie";
               NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this,"my-channel-1")
                       .setContentTitle("New Notification")
                       .setContentText(msg)
                       .setSmallIcon(R.drawable.txt)
                       .setContentText(msg)
                       .setAutoCancel(true);

               Intent intent= new Intent(MainActivity.this,
                       NotificationActivity.class);
               intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
               intent.putExtra("Message : ",msg);

               PendingIntent pendintent= PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
               builder.setContentIntent(pendintent);

               NotificationManager manager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
               manager.notify(0,builder.build());

           }
       });
    }



}