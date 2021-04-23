package com.example.spinners;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ImageView planet;
    Spinner spin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        planet= findViewById(R.id.imageView);
        spin = findViewById(R.id.spinner);

        spin.setOnItemSelectedListener(this);
           ArrayAdapter<CharSequence> arrayadap = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_dropdown_item);
           arrayadap.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
           spin.setAdapter(arrayadap);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selected= String.valueOf(spin.getSelectedItem());
        switch(selected){
            case "Mercury":
                planet.setImageResource(R.drawable.mercury);
                break;
            case "Venus":
                planet.setImageResource(R.drawable.venus);
                break;
            case "Earth":
                planet.setImageResource(R.drawable.earth);
                break;
            case "Mars":
                planet.setImageResource(R.drawable.mars);
                break;
            case "Jupiter":
                planet.setImageResource(R.drawable.jupiter);
                break;
            case "Saturn":
                planet.setImageResource(R.drawable.saturn);
                break;
            case "Uranus":
                planet.setImageResource(R.drawable.uranus);
                break;
            case "Neptune":
                planet.setImageResource(R.drawable.neptune);
                break;
            case "Select Planet":
                planet.setImageResource(R.drawable.solar);
                break;
            default:
                planet.setImageResource(R.drawable.solar);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        planet.setImageResource(R.drawable.solar);
    }
}