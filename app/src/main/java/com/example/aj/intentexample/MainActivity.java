package com.example.aj.intentexample;

import android.app.Activity;
import android.app.ActivityOptions;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread timer =new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }finally {
                    Intent i=new Intent(MainActivity.this, kennyS.class);
                    startActivity(i);
                }
            }
        };

        //timer.start();
    }





    public void onClick(View view)
    {
        Intent i=new Intent(this, kennyS.class);
        Bundle t= ActivityOptions.makeCustomAnimation(this,R.anim.slide_in_left,R.anim.slide_out_left).toBundle();
        startActivity(i,t);
    }

}
