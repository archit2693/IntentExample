package com.example.aj.intentexample;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SQLiteExample extends Activity implements View.OnClickListener{

    Button sqlUpdate,sqlView;
    EditText sqlName,sqlHotness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqliteexample);
        sqlHotness=(EditText)findViewById(R.id.etSQLHotnes);
        sqlUpdate=(Button)findViewById(R.id.bSQLUpdate);
        sqlName=(EditText)findViewById(R.id.etSQLName);
        sqlView=(Button)findViewById(R.id.bSQLopenView);
        sqlView.setOnClickListener(this);
        sqlUpdate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {

            case R.id.bSQLUpdate:
                boolean d=true;
                try {
                    String name = sqlName.getText().toString();
                    String hotness = sqlHotness.getText().toString();

                    HotOrNot entry = new HotOrNot(this);
                    entry.open();
                    entry.createEntry(name, hotness);
                    entry.close();
                }catch (Exception e)
                {
                    d=false;
                }finally {
                    if(d)
                    {
                        Dialog dia=new Dialog(this);
                        dia.setTitle("Yeah it worked");
                        TextView tv=new TextView(this);
                        tv.setText("Success !");
                        dia.setContentView(tv);
                        dia.show();
                    }
                }
                break;
            case R.id.bSQLopenView:

                Intent i=new Intent(this,SQLView.class);
                startActivity(i);

                break;
        }
    }
}
