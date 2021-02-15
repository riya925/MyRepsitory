package com.example.project.ui.home;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project.R;
import com.hsalf.smileyrating.SmileyRating;

public class Feedback extends AppCompatActivity {

    SmileyRating smileyRating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


        smileyRating=findViewById(R.id.smile_rating);
        //Set this SmileySelectedListener to get notified when user selects a smiley
        smileyRating.setSmileySelectedListener(new SmileyRating.OnSmileySelectedListener() {
            @Override
            public void onSmileySelected(SmileyRating.Type type) {
                // You can compare it with rating Type
                if (SmileyRating.Type.GREAT == type) {

                    Toast.makeText(getApplicationContext(),"Wow, the user gave high rating",Toast.LENGTH_LONG).show();
                }
                // You can get the user rating too
                // rating will between 1 to 5
                int rating = type.getRating();


                //Get current selection
                SmileyRating.Type smiley = smileyRating.getSelectedSmiley();
                // You can compare it with rating Type
                if (SmileyRating.Type.GREAT == type) {

                    Toast.makeText(getApplicationContext(),"Great rating is given",Toast.LENGTH_LONG).show();
                }
                // You can get the user rating too
                // rating will between 1 to 5, but -1 is none selected
                rating = type.getRating();
            }
        });
    }
}