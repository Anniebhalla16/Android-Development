package com.example.intro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private EditText etusername,etpass;
    private Button btlogin;
    private int ctr=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etusername = findViewById(R.id.username);
        etpass = findViewById(R.id.password);
        btlogin= findViewById(R.id.login);

        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etusername.getText().toString().isEmpty() || etpass.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Enter all details ",Toast.LENGTH_SHORT).show();
                }
                if(etusername.getText().toString().equals("anniebhalla10") &&
                        etpass.getText().toString().equals("asdfgh")){
                    AlertDialog.Builder builder= new AlertDialog.Builder(
                            MainActivity.this
                    );
                    builder.setIcon(R.drawable.ic_baseline_check_circle_24);
                    builder.setTitle("Login Successfull !! ");
                    builder.setMessage(" Welcome to Instagram ");

                    builder.setNegativeButton("Okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog= builder.create();
                    alertDialog.show();


                    Intent intent= new Intent(MainActivity.this , homepage.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    ctr++;
                    Toast.makeText(getApplicationContext(),"Invalid Username or password ",Toast.LENGTH_SHORT).show();
                    if(ctr==2)
                    {
                        Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                        btlogin.setEnabled(false);
                        // Toast.makeText(getApplicationContext(), "Please try again after some time",Toast.LENGTH_SHORT).show();
                        Timer btntimer = new Timer();
                        btntimer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        btlogin.setEnabled(true);
                                    }
                                });
                            }
                        },10000);

                    }
                }






            }
        });
    }
}