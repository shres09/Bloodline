package com.example.devops;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.devops.fragments.Frag2;
import com.example.devops.fragments.Frag3;
import com.example.devops.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(navListener);
    }
    private final BottomNavigationView.OnNavigationItemSelectedListener navListener =
    new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
            Fragment selectedFragment = null;

            switch(item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.navigation_dashboard:
                    selectedFragment = new Frag2();
                    break;
                case R.id.navigation_notifications:
                    selectedFragment = new Frag3();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_tag,
                    selectedFragment).commit();

            return true;
        }
    };

}