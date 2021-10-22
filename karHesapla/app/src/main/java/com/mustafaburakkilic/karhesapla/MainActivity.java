package com.mustafaburakkilic.karhesapla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
        EditText para;
        EditText kar;
        EditText gun;
        TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        para = findViewById(R.id.editText1);
        kar = findViewById(R.id.editText2);
        gun = findViewById(R.id.editText3);
        textView= findViewById(R.id.textView);
    }

    public void hesapla(View view){
        long gunSayisi= Integer.parseInt(gun.getText().toString());
        long paraSayisi=Integer.parseInt(para.getText().toString());
        long karSayisi=Integer.parseInt(kar.getText().toString());
        for(int i=0;i<gunSayisi;i++){
            paraSayisi = paraSayisi + (paraSayisi*(karSayisi)/100);

        }
        textView.setText("Para: "+paraSayisi);
    }
}