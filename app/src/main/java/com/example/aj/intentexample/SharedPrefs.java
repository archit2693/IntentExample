package com.example.aj.intentexample;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPrefs extends Activity implements View.OnClickListener {

    EditText sharedData;
    TextView dataResults;
    SharedPreferences someData;
    public static String filename="MySharedString";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedpreferences);
        setUpVariables();
        someData=getSharedPreferences(filename,0);
    }

    private void setUpVariables() {
        Button save=(Button)findViewById(R.id.bSave);
        Button load=(Button)findViewById(R.id.bLoad);
        sharedData=(EditText)findViewById(R.id.etSharedPrefs);
        dataResults=(TextView)findViewById(R.id.tvLoadSharedPrefs);
        save.setOnClickListener(this);
        load.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bSave:
                String stringData=sharedData.getText().toString();
                SharedPreferences.Editor editor=someData.edit();
                editor.putString("sharedString",stringData);
                editor.commit();
                break;
            case R.id.bLoad:
                someData=getSharedPreferences(filename,0);
                String dataReturn=someData.getString("sharedString","Couldn't Load Data");
                dataResults.setText(dataReturn);
                break;

        }

    }
}
