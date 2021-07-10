package com.example.devops.start;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.devops.Main;
import com.example.devops.R;
import com.example.devops.Selection;

public class Slide2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_2);

        ImageButton next2 = findViewById(R.id.next2);
        next2.setOnClickListener(v -> gonext2());

        ImageButton prev2 = findViewById(R.id.prev2);
        prev2.setOnClickListener(v -> goprev2());

        ImageButton skip2 = findViewById(R.id.skip2);
        skip2.setOnClickListener(v -> openmain());

    }

    public void openmain(){
        Intent intent = new Intent(this, Selection.class);
        startActivity(intent);
    }
    public void gonext2(){
        Intent intent = new Intent(this, Slide3.class);
        startActivity(intent);
    }

    public void goprev2(){
        Intent intent = new Intent(this, Slide1.class);
        startActivity(intent);
    }
}
