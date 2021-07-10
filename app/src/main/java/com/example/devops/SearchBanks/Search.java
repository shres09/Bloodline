package com.example.devops.SearchBanks;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static android.content.ContentValues.TAG;
import static com.google.android.libraries.places.widget.Autocomplete.*;

public class MapsActivity extends FragmentActivity
{

    Location cloc;
    FusedLocationProviderClient client;
    SupportMapFragment frag;
    ArrayList<LatLng> locations=new ArrayList<LatLng>();

    Button setCurrentLoc;
    EditText editLoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        frag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        client = LocationServices.getFusedLocationProviderClient(this);

        locations.add(new LatLng(21, 33));
        locations.add(new LatLng(44, 33));
        locations.add(new LatLng(23, 19));
        locations.add(new LatLng(41, -82));
        locations.add(new LatLng(40, -81));
        locations.add(new LatLng(40, -79.31));
        locations.add(new LatLng(35, -12));

        if (ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            obtainLocation();
        } else {
            Toast.makeText(this, "Allow location premission", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }

        setCurrentLoc = findViewById(R.id.currentLocButton);
        setCurrentLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cloc != null)
                    Toast.makeText(MapsActivity.this, "Location is set", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MapsActivity.this, "Please turn on the location and set the location", Toast.LENGTH_SHORT).show();
                //close activity
            }
        });
        Places.initialize(getApplicationContext(), KEY);
        editLoc = findViewById(R.id.locationEditText);

        editLoc.setFocusable(false);
        editLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Place.Field> fields = Arrays.asList(Place.Field.ADDRESS, Place.Field.LAT_LNG, Place.Field.NAME);

                // Start the autocomplete intent.
                Intent intent = new IntentBuilder(AutocompleteActivityMode.FULLSCREEN, fields)
                        .build(MapsActivity.this);
                startActivityForResult(intent, 100);

            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                Place place = Autocomplete.getPlaceFromIntent(data);
                editLoc.setText(place.getAddress());
            } else if (resultCode == AutocompleteActivity.RESULT_ERROR) {
                //  Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
                Status status = Autocomplete.getStatusFromIntent(data);
                Log.i(TAG, status.getStatusMessage());
                Toast.makeText(this, status.getStatusMessage(), Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Operation Cancelled", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @SuppressLint("MissingPermission")
    void obtainLocation()
    {
        Task<Location> task=client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location!=null)
                {
                    cloc=location;
                    frag.getMapAsync(new OnMapReadyCallback() {

                        public void onMapReady(GoogleMap map) {

                            map.setMyLocationEnabled(true);
                            map.getUiSettings().setZoomControlsEnabled(true);

                            LatLng ll=new LatLng(cloc.getLatitude(),cloc.getLongitude());
                            MarkerOptions mo=new MarkerOptions().position(ll).title("Your Location").draggable(true);
                            map.animateCamera(CameraUpdateFactory.newLatLng(ll));
                            map.animateCamera(CameraUpdateFactory.newLatLngZoom(ll,5));
                            float zoomLevel = 18f;
                            map.moveCamera(CameraUpdateFactory.newLatLngZoom(ll, zoomLevel));
                            map.addMarker(mo);
                            locations.add(new LatLng(cloc.getLatitude()+0.001f, cloc.getLongitude()+0.001f));
                            if(locations.size()>0) {
                                AddMarkers(map);
                            }
                        }
                    });

                    // Toast.makeText(MapsActivity.this, location.getLatitude() + "\n" + location.getLongitude(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        Toast.makeText(this, "Zoom out to find out more donor's", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==44)
        {
            if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED)
                obtainLocation();
        }
    }

    void AddMarkers(GoogleMap map)
    {
        for(int i=0;i<locations.size();i++)
        {
            map.addMarker(new MarkerOptions().position(locations.get(i)).title("Donor"));

        }


    }
}

