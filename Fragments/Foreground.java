package com.example.question9;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Foreground extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_foreground,container,false);
                Button btn=  view.findViewById(R.id.button2);
        TextView tview;
        tview = view.findViewById(R.id.textView2);

      btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              tview.setTextColor(Color.parseColor("#FF6200EE"));

          }
      });

        return view;
    }

}