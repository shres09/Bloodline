package com.example.devops.Static;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.devops.R;

public class Request extends AppCompatActivity {

    private EditText name, blood, contact;
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_activity);

        Button check = findViewById(R.id.check);

        check.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
        name = (EditText) findViewById(R.id.organ);
        blood = (EditText) findViewById(R.id.bloodgrp);
        contact = (EditText) findViewById(R.id.number);

        TextView nameg = findViewById(R.id.nameT);
        name.setText(name.getText().toString());

        TextView bloodg = findViewById(R.id.bloodT);
        blood.setText(blood.getText().toString());

        TextView contactg = findViewById(R.id.number);
        contactg.setText(contact.getText().toString());
            }
        });

    }

}
