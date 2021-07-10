package com.example.devops.Static;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.devops.R;
import com.example.devops.fragments.Frag1;

public class Camp extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camp_activity);

        ImageButton camp = findViewById(R.id.prev6);
        camp.setOnClickListener(v -> goback2());
    }

    public void goback2(){
        Intent intent = new Intent(this, Frag1.class);
        startActivity(intent);
    }
}
