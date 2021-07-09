package com.example.devops;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.devops.Profile.Login;
import com.example.devops.SearchBanks.Search;
import com.example.devops.fragments.Frag1;
import com.example.devops.fragments.Frag2;
import com.example.devops.fragments.Frag3;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button login = findViewById(R.id.login);
        login.setOnClickListener(v -> openLogin());

        Button search = findViewById(R.id.search);
        search.setOnClickListener(v -> openSearch());

        BottomNavigationView navView = findViewById(R.id.bottom_navigation);
        navView.setOnNavigationItemSelectedListener(navListener);
    }
    private final BottomNavigationView.OnNavigationItemSelectedListener navListener =
    new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
            Fragment selectedFragment = null;

            switch(item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new Frag1();
                    break;
                case R.id.navigation_dashboard:
                    selectedFragment = new Frag2();
                    break;
                case R.id.navigation_notifications:
                    selectedFragment = new Frag3();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();

            return true;
        }
    };
//Ronald put code in Login class
    public void openLogin(){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
    //Shashank put code in Search class
    public void openSearch(){
        Intent intent = new Intent(this, Search.class);
        startActivity(intent);
    }

}