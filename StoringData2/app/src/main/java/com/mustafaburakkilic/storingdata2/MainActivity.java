package com.mustafaburakkilic.storingdata2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int storedAge;
        editText =findViewById(R.id.editText);
        textView= findViewById(R.id.textView);
        sharedPreferences = this.getSharedPreferences("com.mustafaburakkilic.storingdata2", Context.MODE_PRIVATE);
       // sharedPreferences.getInt("storedAge",0);
        textView.setText("Your age: "+sharedPreferences.getInt("storedAge",0));
    }

    public void save(View view){
        int age = Integer.parseInt(editText.getText().toString());
        textView.setText("Your age: "+age);

        if(!textView.getText().toString().matches(" ")){
            sharedPreferences.edit().putInt("storedAge",age).apply();

        }

    }


}