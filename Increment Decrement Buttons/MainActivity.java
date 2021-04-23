package com.example.incdecres;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button inc,dec,res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inc=(Button) findViewById(R.id.inc);
        dec= (Button) findViewById(R.id.dec);
        res= (Button) findViewById(R.id.reset);

        inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText data= (EditText) findViewById(R.id.data);
                String num= data.getText().toString();
                Double number= Double.parseDouble(num);
                number= number+1;
                num= number.toString();
                data.setText(num);
            }
        });

        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText data= (EditText) findViewById(R.id.data);
                String num= data.getText().toString();
                Double number= Double.parseDouble(num);
                number= number-1;
                num= number.toString();
                data.setText(num);
            }
        });

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText data = (EditText) findViewById(R.id.data);
                data.setText("0");
            }
        });

    }
}