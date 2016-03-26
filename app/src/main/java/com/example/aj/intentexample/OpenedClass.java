package com.example.aj.intentexample;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenedClass extends Activity implements OnCheckedChangeListener
{
    TextView question,test;
    Button returnData;
    RadioGroup selectionList;
    String gB;
    String setData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
        question=(TextView)findViewById(R.id.ques);
        test=(TextView)findViewById(R.id.test);
        returnData=(Button)findViewById(R.id.returnButton);

        selectionList=(RadioGroup)findViewById(R.id.rgAnswers);
        selectionList.setOnCheckedChangeListener(this);

        SharedPreferences getData= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String et=getData.getString("name","Archit is..");
        String values=getData.getString("list","4");
        if(values.contentEquals("1"))
        {
            question.setText(et);
        }
        /*Bundle gotb=getIntent().getExtras();
        gB =gotb.getString("key");
        question.setText(gB);
        */
    }

    public void returnButtonClicked(View view)
    {
        Intent person=new Intent();
        Bundle backPack=new Bundle();
        backPack.putString("back",setData);
        person.putExtras(backPack);
        setResult(RESULT_OK,person);
        finish();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId)
        {
            case R.id.rStupid:
                setData="Right";
                break;
            case R.id.rFaltu:
                setData="Yuppppppp";
                break;
            case R.id.rHot:
                setData="Ohh yeahhh";
                break;

        }
        test.setText(setData);
    }
}
