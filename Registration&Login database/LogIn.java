package com.example.registrationdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import javax.security.auth.login.LoginException;

public class LogIn extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText etusername, etpass;
    Button btnlog;
    int ctr = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        myDB = new DatabaseHelper(this);

        etusername = findViewById(R.id.editTextTextPersonName);
        etpass = findViewById(R.id.editTextTextPassword);
        btnlog = findViewById(R.id.button);

    }

    public void Buttonloginclicked(View view) {

        if (etusername.getText().toString().equals("") || etpass.getText().toString().equals("")) {
            Toast.makeText(LogIn.this, "Enter all details ", Toast.LENGTH_SHORT).show();
        } else {

//            Boolean checkuser = myDB.checkusername(etusername.getText().toString());
            Boolean checkuserpass = myDB.checkusernamepassword(etusername.getText().toString(), etpass.getText().toString());
            if (checkuserpass == true) {
                Intent intent = new Intent(getApplicationContext(), WelcomePage.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Invalid credentials ", Toast.LENGTH_SHORT).show();
            }


        }
    }
}