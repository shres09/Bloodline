package com.example.devops;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import com.example.devops.Profile.Login;
import com.example.devops.SearchBanks.Search;
import com.example.devops.Static.Camp;
import com.example.devops.Static.Drive;
import com.example.devops.Static.Funds;
import com.example.devops.Static.InfoDesk;
import com.example.devops.Static.Procedure;
import com.example.devops.Vets.Vets;
import com.example.devops.databinding.ActivityMainBinding;
import com.example.devops.fragments.Frag1;
import com.example.devops.fragments.Frag2;
import com.example.devops.fragments.Frag3;
import com.example.devops.fragments.Frag4;
import com.example.devops.fragments.Frag5;
import com.google.android.material.bottomnavigation.BottomNavigationView;

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

        ImageButton blood = findViewById(R.id.bloodbank);
        blood.setOnClickListener(v -> gosearch());

        ImageButton request = findViewById(R.id.request);
        request.setOnClickListener(v -> gologin());

        ImageButton vets = findViewById(R.id.vets);
        vets.setOnClickListener(v -> govets());

        ImageButton funds = findViewById(R.id.funds);
        funds.setOnClickListener(v -> gofunds());

        ImageButton info = findViewById(R.id.info);
        info.setOnClickListener(v -> goinfo());

        ImageButton procedure = findViewById(R.id.procedure);
        procedure.setOnClickListener(v -> goprocedure());

        ImageButton camp = findViewById(R.id.camp);
        camp.setOnClickListener(v -> gocamp());

        ImageButton drive = findViewById(R.id.drive);
        drive.setOnClickListener(v -> godrive());
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

    public void gosearch(){
        Intent intent = new Intent(this, Search.class);
        startActivity(intent);
    }
    public void gologin(){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
    public void govets(){
        Intent intent = new Intent(this, Vets.class);
        startActivity(intent);
    }
    public void gofunds(){
        Intent intent = new Intent(this, Funds.class);
        startActivity(intent);
    }
    public void goinfo(){
        Intent intent = new Intent(this, InfoDesk.class);
        startActivity(intent);
    }
    public void goprocedure(){
        Intent intent = new Intent(this, Procedure.class);
        startActivity(intent);
    }
    public void gocamp(){
        Intent intent = new Intent(this, Camp.class);
        startActivity(intent);
    }
    public void godrive(){
        Intent intent = new Intent(this, Drive.class);
        startActivity(intent);
    }


}