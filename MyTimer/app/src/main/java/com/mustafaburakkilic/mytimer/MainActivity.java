package com.mustafaburakkilic.mytimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.net.IpSecManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    int time;
    Handler handler;
    Runnable runnable;
    Button button;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        time = 0;

    }
    public void start(View view){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("Time: "+time);
                time++;
                handler.postDelayed(runnable,1000);

            }
        };
        button.setEnabled(false);
        handler.post(runnable);

    }
    public void stop(View view){
        handler.removeCallbacks(runnable);
       // textView.setText("Time: "+0);
        time =0;
        button.setEnabled(true);

    }
}