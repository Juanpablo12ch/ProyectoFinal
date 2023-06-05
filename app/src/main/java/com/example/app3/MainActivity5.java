package com.example.app3;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity5 extends AppCompatActivity {
    Button btn;
    TextView val;
    private FusedLocationProviderClient fusedLocationClient;
    private final static int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        btn = findViewById(R.id.buttongps);
        val = findViewById(R.id.textView6);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLastUb();
            }
        });

        //int permissioncheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);


    }

    private void getLastUb(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                                if(location != null){
                                    Geocoder geocoder = new Geocoder(MainActivity5.this, Locale.getDefault());
                                    List<Address> adresses = null;

                                    try {
                                        adresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(),1);
                                        val.setText("Latitud: " + adresses.get(0).getLatitude() + "Longitud: " + adresses.get(0).getLongitude());
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }

                                }
                        }
                    });
        }else{
            askPermission();
        }
    }

    private void askPermission(){
        ActivityCompat.requestPermissions(MainActivity5.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @org.jetbrains.annotations.NotNull String[] permissions, @NonNull @org.jetbrains.annotations.NotNull int[] grantResults) {

        if (requestCode == REQUEST_CODE){

            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){


                getLastUb();

            }else {


                Toast.makeText(MainActivity5.this,"Debes indicar los permisos requeridos.",Toast.LENGTH_SHORT).show();

            }



        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}