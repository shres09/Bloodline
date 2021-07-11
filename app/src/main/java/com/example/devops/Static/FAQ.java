package com.example.devops.Static;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.devops.R;
import com.example.devops.fragments.Frag1;

public class FAQ extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faq_activity);

        EditText question = findViewById(R.id.question);
        String questionS = question.getText().toString();

        Button post = findViewById(R.id.post);
        post.setOnClickListener(v -> gotomain());
    }
    public void gotomain(){
        Intent intent = new Intent(this, Frag1.class);
        startActivity(intent);
    }
}
