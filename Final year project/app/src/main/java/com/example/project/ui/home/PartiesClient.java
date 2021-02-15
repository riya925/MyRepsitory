package com.example.project.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project.R;

public class PartiesClient extends AppCompatActivity {

    TextView tvEmailClient,tvContactClient,tvCityClient,tvAddressClient,tvNameClient;
    EditText edEmailClient,edContactClient,edCityClient,edAddressClient,edNameClient;
    Button btnSubmitClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parties_client);

        tvNameClient=findViewById(R.id.tvNameClient);
        tvAddressClient=findViewById(R.id.tvAddressClient);
        tvCityClient=findViewById(R.id.tvCityClient);
        tvContactClient=findViewById(R.id.tvContactClient);
        tvEmailClient=findViewById(R.id.tvEmailClient);

        edNameClient=findViewById(R.id.edNameClient);
        edAddressClient=findViewById(R.id.edAddressClient);
        edCityClient=findViewById(R.id.edCityClient);
        edContactClient=findViewById(R.id.edContactClient);
        edEmailClient=findViewById(R.id.edEmailClient);

        btnSubmitClient=findViewById(R.id.btnSubmitClient);

        btnSubmitClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}