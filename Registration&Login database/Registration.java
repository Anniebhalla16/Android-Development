package com.example.registrationdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
EditText etuser,etpass;
Button btnregister;
DatabaseHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        myDB= new DatabaseHelper(this);

        btnregister= findViewById(R.id.btnreg);
        etuser= findViewById(R.id.edituser);
        etpass= findViewById(R.id.editpass);
    }

    public void registeronClick(View view){
        boolean isInserted= myDB.insertData(etuser.getText().toString(),etpass.getText().toString());
        if(isInserted)
            Toast.makeText(Registration.this, "Successful Insertion in Database ", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(Registration.this,"INSERTION FAILED IN DATABASE  ",Toast.LENGTH_LONG).show();

        Intent intent= new Intent(Registration.this, LogIn.class);
        startActivity(intent);

    }



}