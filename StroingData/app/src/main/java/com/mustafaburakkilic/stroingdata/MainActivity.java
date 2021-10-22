package com.mustafaburakkilic.stroingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText editText;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextNumber);
        textView = findViewById(R.id.textView);
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.mustafaburakkilic.stroingdata", Context.MODE_PRIVATE);
        int age =40;

    }

    public void save (View view){
        if(!editText.getText().toString().matches("")){
           int userAge =Integer.parseInt(editText.getText().toString());
           textView.setText("Your age: "+ userAge);
        }

    }
}