package com.example.devops.start;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.devops.Main;
import com.example.devops.R;
import com.example.devops.Selection;

public class Slide3 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_3);

        ImageButton next3 = findViewById(R.id.next3);
        next3.setOnClickListener(v -> gonext3());

        ImageButton prev3 = findViewById(R.id.prev3);
        prev3.setOnClickListener(v -> goprev3());
    }
    public void gonext3(){
        Intent intent = new Intent(this, Selection.class);
        startActivity(intent);
    }

    public void goprev3(){
        Intent intent = new Intent(this, Slide2.class);
        startActivity(intent);
    }
}
