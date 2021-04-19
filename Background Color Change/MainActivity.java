package com.example.colorchange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button1,button2,button3;
   View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1= findViewById(R.id.btn1);
        button2= findViewById(R.id.btn2);
        button3= findViewById(R.id.btn3);

        view = findViewById(R.id.vieww);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    view.setBackgroundResource(R.color.cerulean);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundResource(R.color.teal_200);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundResource(R.color.rosebud);
            }
        });
    }
}