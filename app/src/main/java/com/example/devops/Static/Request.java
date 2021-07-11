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
import com.example.devops.fragments.Frag2;

public class Request extends AppCompatActivity {

    private EditText name, blood, contact;
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_activity);

        ImageButton place = findViewById(R.id.place);
        place.setOnClickListener(v -> donorscom());


        Button check = findViewById(R.id.check);
        name = (EditText) findViewById(R.id.organ);
        blood = (EditText) findViewById(R.id.grp);
        contact = (EditText) findViewById(R.id.number);
        TextView nameg = findViewById(R.id.organ_name);
        TextView bloodg = findViewById(R.id.blood_type);
        TextView contactg = findViewById(R.id.numberT);

        check.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int ViewID = view.getId();
                if(ViewID == R.id.check){

                    nameg.setText(name.getText().toString());


                    bloodg.setText(blood.getText().toString());


                    contactg.setText(contact.getText().toString());

                }
            }
        });

    }
    public void donorscom(){
        Intent intent = new Intent(this, Frag2.class);
        startActivity(intent);
    }

}
