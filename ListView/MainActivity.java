package com.example.question6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lview;
    List<String> courselist;
    ArrayAdapter<String> arrayadap;
    ImageView viewas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lview= findViewById(R.id.listv);
        viewas= findViewById(R.id.imageView);

        String[] courses= new String[]{
             "Computer Science ",
                "Chemistry Hons ",
                "Physics Hons ",
                "Maths Hons"
        };

        courselist= new ArrayList<>(Arrays.asList(courses));
        arrayadap= new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,courselist);
        lview.setAdapter(arrayadap);

        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int x= lview.getAdapter().getCount();
                switch (position)
                {
                    case 0:
                        viewas.setImageResource(R.drawable.cs);
                        break;
                    case 1:
                       viewas.setImageResource(R.drawable.chem);
                       break;
                    case 2: viewas.setImageResource(R.drawable.phy);
                     break;
                    case 3: viewas.setImageResource(R.drawable.math);
                       break;
                }
            }
        });

    }


}