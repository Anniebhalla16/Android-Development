package com.example.question9;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.question9.R.color;

import java.util.ArrayList;
import java.util.List;


public class Background extends Fragment {
 ListView lv;
 ArrayAdapter<String> str;
 ArrayList<String> str2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview =inflater.inflate(R.layout.fragment_background, container, false);
        lv= rootview.findViewById(R.id.listeviewbg);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        rootview.setBackgroundResource(color.teal_200);
                        break;
                    case 1:
                        rootview.setBackgroundResource(color.rosebud);
                        break;
                    case 2: rootview.setBackgroundResource(color.green);
                    break;
                    case 3:
                        rootview.setBackgroundResource(color.celurean);
                        break;
                    default: rootview.setBackgroundResource(color.black);

                }
            }
        });
        return rootview;
    }


}