package com.example.devops;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Selection extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        ImageButton user = findViewById(R.id.user);
        user.setOnClickListener(v -> openmain());
    }
    public void openmain(){
        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
    }
}
