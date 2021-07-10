package com.example.devops.Static;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.devops.R;
import com.example.devops.fragments.Frag1;

public class Drive extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drive_activity);

        ImageButton drive = findViewById(R.id.prev5);
        drive.setOnClickListener(v -> goback1());
    }
    public void goback1(){
        Intent intent = new Intent(this, Frag1.class);
        startActivity(intent);
    }
}
