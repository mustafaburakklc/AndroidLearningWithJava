package com.mustafaburakkilic.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

import com.mustafaburakkilic.landmarkbook.databinding.ActivityDetailsBinding;
import com.mustafaburakkilic.landmarkbook.databinding.ActivityMainBinding;



public class DetailsActivity extends AppCompatActivity {
    private ActivityDetailsBinding binding;

    TextView nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(R.layout.activity_details);
        //Intent intent = getIntent();
        //Landmark selectedLandmark = (Landmark)intent.getSerializableExtra("landmark");
        //Landmark selectedLandmark =chosenLandmark;
        Singleton singleton=Singleton.getInstance();  //
        Landmark selectedLandmark = singleton.getSelectedLandmark();  //

        binding.nameText.setText(selectedLandmark.name);
        binding.countryNameText.setText(selectedLandmark.country);
        binding.imageView.setImageResource(selectedLandmark.image);




    }
}