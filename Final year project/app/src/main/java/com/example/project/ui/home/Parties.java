package com.example.project.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;

public class Parties extends Activity {

//    Button partiesDetailBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parties);

//        getActionBar();

        Intent parties=getIntent();
        RecyclerView recyclerView=findViewById(R.id.records_recycler);
//        partiesDetailBtn=findViewById(R.id.parties_detail_btn);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        PartiesBeanClass[] parties_bean=new PartiesBeanClass[]{
                new PartiesBeanClass("ABC","Aaaa"),
                new PartiesBeanClass("BCD","Bbbb"),
                new PartiesBeanClass("PQR","Pppp"),
                new PartiesBeanClass("DEF","Dddd"),
                new PartiesBeanClass("EFG","Eeee"),
                new PartiesBeanClass("XYZ","Yyyy"),
        };

        PartiesAdapter PartiesAdapter =new PartiesAdapter(parties_bean,this);
        recyclerView.setAdapter(PartiesAdapter);

//        partiesDetailBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent detailParties=new Intent(getApplicationContext(),DetailParties.class);
//                startActivity(detailParties);
//
//            }
//        });
    }
}