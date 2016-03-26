package com.example.aj.intentexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Data extends Activity implements View.OnClickListener
{
    Button bS,bSfr;
    EditText input;
    TextView testg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get);
        bS= (Button)findViewById(R.id.bS);
        bSfr= (Button)findViewById(R.id.bSfr);
        testg=(TextView)findViewById(R.id.testg);
        input=(EditText)findViewById(R.id.input);
        bS.setOnClickListener(this);
        bSfr.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK)
        {
            Bundle basket=data.getExtras();
            String s=basket.getString("back");
            testg.setText(s);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bS:
                String bread=input.getText().toString();
                Bundle basket=new Bundle();
                basket.putString("key", bread);
                Intent i=new Intent(Data.this,OpenedClass.class);
                i.putExtras(basket);
                startActivity(i);
                break;
            case R.id.bSfr:
                Intent intent=new Intent(Data.this,OpenedClass.class);
                startActivityForResult(intent,0);
                break;

        }
    }
}
