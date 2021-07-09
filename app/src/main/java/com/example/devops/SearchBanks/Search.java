package com.example.devops.SearchBanks;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.devops.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class Search extends FragmentActivity
{

    Location cloc;
    FusedLocationProviderClient client;
    SupportMapFragment frag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        frag=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        client= LocationServices.getFusedLocationProviderClient(this);

        if(ActivityCompat.checkSelfPermission(Search.this,Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED)
        {
            obtainLocation();
        }
        else
        {
            ActivityCompat.requestPermissions(Search.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},44);
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

                            LatLng ll=new LatLng(cloc.getLatitude(),cloc.getLongitude());
                            MarkerOptions mo=new MarkerOptions().position(ll).title("Location");
                            map.animateCamera(CameraUpdateFactory.newLatLng(ll));
                            map.animateCamera(CameraUpdateFactory.newLatLngZoom(ll,5));
                            map.addMarker(mo);
                        }
                    });
                    cloc=location;
                    Toast.makeText(Search.this, location.getLatitude() + "\n" + location.getLongitude(), Toast.LENGTH_SHORT).show();
                }
            }
        });

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
}
