package com.example.galleryimagechooser;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btprev,btn2,btnext;
    private ImageSwitcher imgv;
    int pickimg=1;
    int position=0;
    private  ArrayList<Uri> imguris;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btprev = findViewById(R.id.button1);
        btnext = findViewById(R.id.button3);
        btn2 = findViewById(R.id.button2);
        imgv = findViewById(R.id.images);

        imguris= new ArrayList<>();
        // to setup image switcher
        imgv.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView iv= new ImageView(getApplicationContext());
                return  iv;
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
                    return;
                }
                pickimages();
            }
        });

        btprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(position>0)
            {
                position--;
                imgv.setImageURI(imguris.get(position));
            }else{
                position= imguris.size()-1;
                imgv.setImageURI(imguris.get(position));
            }
            }
        });

        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position<imguris.size()-1){
                    position++;
                    imgv.setImageURI(imguris.get(position));
                }else
                {
                    position=0;
                    imgv.setImageURI(imguris.get(position));
                }
            }
        });
    }

    public void pickimages(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent," Select Image(s)"), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== pickimg && resultCode==RESULT_OK ){
            if(data.getClipData()!=null){
                // multiple images
                int count= data.getClipData().getItemCount();
                for(int i=0;i<count;i++)
                {
                    Uri imageuri= data.getClipData().getItemAt(i).getUri();
                    imguris.add(imageuri);
                }
                imgv.setImageURI(imguris.get(0));
                position=0;

            }else
            {
                //single image
                Uri imageUri= data.getData();
                imguris.add(imageUri);
                imgv.setImageURI(imguris.get(0));
                position=0;
            }
        }
    }
}