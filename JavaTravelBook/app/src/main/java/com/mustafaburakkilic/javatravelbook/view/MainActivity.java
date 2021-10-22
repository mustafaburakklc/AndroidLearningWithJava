package com.mustafaburakkilic.javatravelbook.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.mustafaburakkilic.javatravelbook.R;
import com.mustafaburakkilic.javatravelbook.model.Place;
import com.mustafaburakkilic.javatravelbook.roomdb.PlaceDao;
import com.mustafaburakkilic.javatravelbook.roomdb.PlaceDatabase;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

private CompositeDisposable compositeDisposable=new CompositeDisposable();
PlaceDatabase db;
PlaceDao placeDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db= Room.databaseBuilder(getApplicationContext(),PlaceDatabase.class,"Places")
                .build();
        placeDao=db.placeDao();
        compositeDisposable.add(placeDao.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(MainActivity.this::handleResponse)

        );

    }
    private void handleResponse(List<Place> placeList){
        findViewById(R.id.recyclerView).

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.travel_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.add_place){
            Intent intent=new Intent(MainActivity.this,
                    MapsActivity.class);
        }
        return super.onOptionsItemSelected(item);
    }
    protected void onDestroy(){
        super.onDestroy();
        compositeDisposable.clear();
    }
}