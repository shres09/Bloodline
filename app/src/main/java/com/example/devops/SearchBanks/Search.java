package com.example.devops.SearchBanks;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

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


import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class MapsActivity extends FragmentActivity
{

    Location cloc;
    FusedLocationProviderClient client;
    SupportMapFragment frag;
    ArrayList<LatLng> locations=new ArrayList<LatLng>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        frag=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        client= LocationServices.getFusedLocationProviderClient(this);

        locations.add(new LatLng(21,33));
        locations.add(new LatLng(44,33));
        locations.add(new LatLng(23,19));
        locations.add(new LatLng(41,-82));
        locations.add(new LatLng(40,-81));
        locations.add(new LatLng(40,-79.31));
        locations.add(new LatLng(35,-12));

        if(ActivityCompat.checkSelfPermission(MapsActivity.this,Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED)
        {
            obtainLocation();
        }
        else
        {
            Toast.makeText(this, "Allow location premission", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(MapsActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},44);
        }
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
                    cloc=location;

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
            //  map.animateCamera(CameraUpdateFactory.zoomTo(18.0f));
            // map.moveCamera(CameraUpdateFactory.newLatLng(locations.get(i)));
        }


    }
}

