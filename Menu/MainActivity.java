package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= findViewById(R.id.textview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.mon:
                tv.setText("Monday");
                break;
            case R.id.tue:
                tv.setText("Tuesday");
                break;
            case R.id.wed:
                tv.setText("Wednesday");
                break;
            case R.id.thu:
                tv.setText("Thursday");
                break;
            case R.id.fri:
                tv.setText("Friday");
                break;
            default:
                tv.setText("Select an Option");
        }
        return super.onOptionsItemSelected(item);
    }
}