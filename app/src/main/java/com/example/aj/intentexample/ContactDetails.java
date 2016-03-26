package com.example.aj.intentexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactDetails extends AppCompatActivity{
    ImageView imageView;
    TextView tx_name,tx_email,tx_mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_details_layout);
        imageView=(ImageView)findViewById(R.id.d_contact_image);
        tx_name=(TextView)findViewById(R.id.d_contact_name);
        tx_email=(TextView)findViewById(R.id.d_contact_email);
        tx_mobile=(TextView)findViewById(R.id.d_contact_mobile);
        imageView.setImageResource(getIntent().getIntExtra("img_id",00));
        tx_name.setText(getIntent().getStringExtra("pname"));
        tx_email.setText(getIntent().getStringExtra("pemail"));
        tx_mobile.setText(getIntent().getStringExtra("pmobile"));

    }
}
