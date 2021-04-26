package com.example.question9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button bgbtn , fgbtn;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bgbtn = findViewById(R.id.bg);
        fgbtn = findViewById(R.id.fg);

        bgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addbgfragment();
            }
        });

        fgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addfgfragment();
            }
        });


    }

    public void addbgfragment(){
        Fragment bgfrag= new Background();
        FragmentTransaction tran= getSupportFragmentManager().beginTransaction().add(R.id.fragcontainer, bgfrag).addToBackStack("fragmentstack1");
        tran.replace(R.id.fragcontainer, bgfrag,null);
        tran.commit();
    }

    public void addfgfragment(){
            Fragment fgfrag = new Foreground();
            FragmentTransaction tran2= getSupportFragmentManager().beginTransaction().add(R.id.fragcontainer, fgfrag).addToBackStack("fragmentstack1");
        tran2.replace(R.id.fragcontainer, fgfrag,null);
        tran2.commit();
    }
}