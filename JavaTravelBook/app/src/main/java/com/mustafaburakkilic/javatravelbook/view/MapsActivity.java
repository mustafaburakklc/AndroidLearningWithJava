package com.mustafaburakkilic.javatravelbook.view;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.room.Insert;
import androidx.room.Room;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.snackbar.Snackbar;
import com.mustafaburakkilic.javatravelbook.R;
import com.mustafaburakkilic.javatravelbook.model.Place;
import com.mustafaburakkilic.javatravelbook.roomdb.PlaceDao;
import com.mustafaburakkilic.javatravelbook.roomdb.PlaceDatabase;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMapLongClickListener {

    private GoogleMap mMap;

    ActivityResultLauncher<String>permissionLauncher;
    LocationManager locationManager;
    LocationListener locationListener;
    SharedPreferences sharedPreferences;
    boolean info;
    PlaceDatabase db;
    PlaceDao placeDao;
    Double selectedLatitude;
    Double selectedLongitude;
    private CompositeDisposable compositeDisposable=new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        registerLauncher();
        sharedPreferences=MapsActivity.this.getSharedPreferences("com.mustafaburakkilic.javatravelbook",
                MODE_PRIVATE);
        info=false;
        db= Room.databaseBuilder(getApplicationContext(),PlaceDatabase.class,"Places")
    //.allowMainThreadQueries()

                .build();
        placeDao=db.placeDao();
        selectedLatitude=0.0;
        selectedLongitude=0.0;

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapLongClickListener(this);

        findViewById(R.id.saveButton).setEnabled(false);

        //casting
         locationManager=
                (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
         locationListener=new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                 info = sharedPreferences.getBoolean("info",false);
                if (info==false){
                LatLng userLocation = new LatLng(location.getLatitude(),location.getLongitude());
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation,15));
                sharedPreferences.edit().putBoolean("info",true).apply();
                }
            }

        };
        //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)){
                Snackbar.make(findViewById(R.id.map),
                        "Permission needed for maps",
                        Snackbar.LENGTH_INDEFINITE).setAction("Give Permission", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION);
                    }
                }).show();
            }else{
                permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION);
            }
        }else{
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    0,0,locationListener);
            Location lastlocation =locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (lastlocation!=null){
                LatLng lastUserLocation = new LatLng(lastlocation.getLatitude(),lastlocation.getLongitude());
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lastUserLocation,15));
            }
            mMap.setMyLocationEnabled(true);
        }
       /*// eiffel enlem boylam 48.858896890625786, 2.2943799003125074
        LatLng eiffel = new LatLng(48.858896890625786,2.2943799003125074);
        mMap.addMarker(new MarkerOptions().position(eiffel).title("Eiffel Tower"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(eiffel,15));*/
    }
    private  void registerLauncher(){
        permissionLauncher =
                registerForActivityResult(new ActivityResultContracts.RequestPermission(),
                        new ActivityResultCallback<Boolean>() {
            @Override
            public void onActivityResult(Boolean result) {
                if (result){
                    if (ContextCompat.checkSelfPermission(MapsActivity.this,Manifest.permission.
                            ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                                0,0,locationListener);
                    }
                }else{
                    Toast.makeText(MapsActivity.this,"Permission neeeded",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        mMap.clear();
        mMap.addMarker(new MarkerOptions().position(latLng));
        selectedLatitude=latLng.latitude;
        selectedLongitude=latLng.longitude;
        findViewById(R.id.saveButton).setEnabled(true);

    }
    public void save(View view){


        Place place=new Place("PlaceNameText",selectedLatitude,selectedLongitude);
        //threading->Main (UI),Default(CPU Intensive),IO(network,database)
        //placeDao.insert(place).subscribeOn(Schedulers.io()).subscribe();
        //disposable
        compositeDisposable.add(placeDao.insert(place)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(MapsActivity.this::handleResponse));

    }
    private void handleResponse(){
        Intent intent = new Intent(MapsActivity.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
    public void delete(View view){
       /* compositeDisposable.add(placeDao.delete()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(MapsActivity.this::handleResponse));*/

    }
    protected void onDestroy(){
        super.onDestroy();
        compositeDisposable.clear();
    }

}