package com.mustafaburakkilic.runnablehandler2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Handler handler;
    Runnable runnable;
    int number;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView=findViewById(R.id.textView);
        number =0;
    }

    public void start(View view){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("Time: "+number);
                number++;
                handler.postDelayed(runnable,1000);
                button.setEnabled(false);


            }
        };
        handler.post(runnable);


    }
    public void stop(View view){
        textView.setText("Time: ");
        handler.removeCallbacks(runnable);
        button.setEnabled(true);
        number=0;

    }
}