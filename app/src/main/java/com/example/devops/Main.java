package com.example.devops;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import com.example.devops.Profile.Login;
import com.example.devops.SearchBanks.Search;
import com.example.devops.databinding.ActivityMainBinding;
import com.example.devops.fragments.Frag1;
import com.example.devops.fragments.Frag2;
import com.example.devops.fragments.Frag3;
import com.example.devops.fragments.Frag4;
import com.example.devops.fragments.Frag5;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.iammert.library.readablebottombar.ReadableBottomBar;

import org.jetbrains.annotations.NotNull;

public class Main extends AppCompatActivity {

    ActivityMainBinding binding;
    BottomNavigationView readableBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                new Frag1()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                    Fragment SelectedFragment = null;
                    switch(item.getItemId()){
                        case R.id.home:
                            SelectedFragment = new Frag1();
                            break;
                        case R.id.donors:
                            SelectedFragment = new Frag2();
                            break;
                        case R.id.profile:
                            SelectedFragment = new Frag3();
                            break;
                        case R.id.search:
                            SelectedFragment = new Frag4();
                            break;
                        case R.id.contact:
                            SelectedFragment = new Frag5();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,
                            SelectedFragment).commit();
                    return true;
                }
            };
}