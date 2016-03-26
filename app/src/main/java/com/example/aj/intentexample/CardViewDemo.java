package com.example.aj.intentexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class CardViewDemo extends AppCompatActivity{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    Toolbar toolbar;
    ArrayList<Contact> list=new ArrayList<>();
    int[] image_id={R.drawable.greenball,R.drawable.icon,R.drawable.plus,R.drawable.plushighlight,R.drawable.plusselected};
    String[] name,email,mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardviewdemo);
        name=getResources().getStringArray(R.array.names);
        email=getResources().getStringArray(R.array.email);
        mobile=getResources().getStringArray(R.array.mobile);
        int count=0;
        for(String Name:name)
        {
            Contact contact=new Contact(image_id[count],Name,email[count],mobile[count]);
            count++;
            list.add(contact);
        }
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view1);
        adapter=new ContactAdapter(list,this);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
       //Installing toolbar
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id=item.getItemId();
        if(res_id==R.id.action_settings)
        {
            Toast.makeText(getApplicationContext(), "You selected Play", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
