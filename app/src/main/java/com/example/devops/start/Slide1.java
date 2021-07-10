package com.example.devops.start;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.devops.Main;
import com.example.devops.R;
import com.example.devops.Selection;

public class Slide1 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_1);

        ImageButton skip1 = findViewById(R.id.skip1);
        skip1.setOnClickListener(v -> openmain());

        ImageButton next1 = findViewById(R.id.next1);
        next1.setOnClickListener(v -> gonext1());
    }
    public void openmain(){
        Intent intent = new Intent(this, Selection.class);
        startActivity(intent);
    }
    public void gonext1(){
        Intent intent = new Intent(this, Slide2.class);
        startActivity(intent);
    }
}

