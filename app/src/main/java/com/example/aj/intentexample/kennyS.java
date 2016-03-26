package com.example.aj.intentexample;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class kennyS extends AppCompatActivity implements View.OnClickListener {

    Button anima;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kenny_s);
        anima=(Button)findViewById(R.id.bAnim);
        anima.setOnClickListener(this);
    }
    public void onClick(View view)
    {
        Intent i=new Intent(this, MainActivity.class);
        Bundle s= ActivityOptions.makeScaleUpAnimation(view,0,0,view.getWidth(), view.getHeight()).toBundle();
        startActivity(i,s);
    }

}
