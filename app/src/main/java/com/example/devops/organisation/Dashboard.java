package com.example.devops.organisation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.devops.R;
import com.example.devops.SearchBanks.Search;
import com.example.devops.Static.Funds;
import com.example.devops.Static.Request;

public class Dashboard extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.organisation_activity);

        ImageButton regblood = findViewById(R.id.regblood);
        regblood.setOnClickListener(v -> openmap());

        ImageButton viewreq = findViewById(R.id.viewreqb);
        viewreq.setOnClickListener(v -> openreqview());

        ImageButton postreq = findViewById(R.id.postreq);
        postreq.setOnClickListener(v -> openreq());

        ImageButton fundsorg = findViewById(R.id.fundsorg);
        fundsorg.setOnClickListener(v -> openfunds());
    }
    public void openmap(){
        Intent intent = new Intent(this, Search.class);
        startActivity(intent);
    }
    public void openreqview(){
        Intent intent = new Intent(this, RequestView.class);
        startActivity(intent);
    }
    public void openreq(){
        Intent intent = new Intent(this, Request.class);
        startActivity(intent);
    }
    public void openfunds(){
        Intent intent = new Intent(this, Funds.class);
        startActivity(intent);
    }

}
