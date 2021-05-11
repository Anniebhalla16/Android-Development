package com.example.menuwithsubitems;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.nine :
                tv.setText("Class 9");
                break;
            case R.id.sc9 :
                tv.setText("Science");
                break;
            case R.id.math9 :
                tv.setText("Maths");
                break;
            case R.id.ten :
                tv.setText("Class 10");
                break;
            case R.id.cs10 :
                tv.setText("Computer Science");
                break;
            case R.id.twel :
                tv.setText("Class 12");
                break;
            case R.id.nonmed :
                tv.setText("PCM");
                break;
            case R.id.med :
                tv.setText("Medical");
                break;
            case R.id.human :
                tv.setText("Humanities");
                break;
            case R.id.com :
                tv.setText("Commerce");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}