package com.example.appchooser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private String msg="";
    private EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn= findViewById(R.id.button);
        txt= findViewById(R.id.editTex);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg= txt.getText().toString();

                Intent intent= new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,msg);
                intent.setType("text/plain");

                try{
                    startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }

}