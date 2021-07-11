package com.example.devops;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.devops.organisation.Dashboard;

public class Selection extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        ImageButton user = findViewById(R.id.user);
        user.setOnClickListener(v -> openmain());

        ImageButton org = findViewById(R.id.organisation);
        org.setOnClickListener(v -> opendash());
    }
    public void openmain(){
        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
    }

    public void opendash(){
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }
}
