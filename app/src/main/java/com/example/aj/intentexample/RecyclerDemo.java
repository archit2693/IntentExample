package com.example.aj.intentexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RecyclerDemo extends AppCompatActivity{

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    String[] country={"India","India","India","India","India","India","India","India","India","India","India","India","India","India","India","India","India","India","India","India",
            "India","India","India","India","India","India"};
    String[] capital={"Delhi","Delhi","Delhi","Delhi","Delhi","Delhi","Delhi","Delhi","Delhi","Delhi","Delhi","Delhi","Delhi","Delhi","Delhi","Delhi","Delhi","Delhi","Delhi","Delhi",
            "Delhi","Delhi","Delhi","Delhi","Delhi","Delhi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerdemo);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        adapter=new RecyclerAdapter(country,capital);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}
