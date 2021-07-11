package com.example.devops.Vets;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.devops.R;
import com.example.devops.SearchBanks.Search;
import com.example.devops.Static.Funds;
import com.example.devops.Static.InfoDesk;
import com.example.devops.Static.Request;

public class Vets extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vet_main);

        ImageButton bank = findViewById(R.id.bank);
        bank.setOnClickListener(v -> opensearch());

        ImageButton reqdog = findViewById(R.id.reqdog);
        reqdog.setOnClickListener(v -> openreq());

        ImageButton infodog = findViewById(R.id.infodog);
        infodog.setOnClickListener(v -> openinfo());

        ImageButton fundsdog = findViewById(R.id.fundsdog);
        fundsdog.setOnClickListener(v -> openfunds());


    }

    public void opensearch(){
        Intent intent = new Intent(this, Search.class);
        startActivity(intent);
    }
    public void openreq(){
        Intent intent = new Intent(this, Request.class);
        startActivity(intent);
    }
    public void openinfo(){
        Intent viewIntent =
                new Intent("android.intent.action.VIEW",
                        Uri.parse("https://www.akcchf.org/educational-resources/library/articles/articles/canine-blood-donation.html"));
        startActivity(viewIntent);
    }
    public void openfunds(){
        Intent intent = new Intent(this, Funds.class);
        startActivity(intent);
    }
}
