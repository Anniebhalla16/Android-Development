package com.example.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnStart, btnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart= findViewById(R.id.button);
        btnStop= findViewById(R.id.button2);
    }

    public void start(View v)
    {
        Intent i=new Intent(this,MyService.class);
        startService(i);
    }

    public void stop(View v){
        Intent i= new Intent(this,MyService.class);
        stopService(i);
    }
}