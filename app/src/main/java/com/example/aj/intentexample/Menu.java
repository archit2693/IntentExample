package com.example.aj.intentexample;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity
{

    String[] classes={"TextPlay","MainActivity","kennyS","Email","Camera","Data","GFX","GFXSurface","SoundStuff","Slider","Tabs","SimpleBrowser","Flipper","SharedPrefs","InternalData","ExternalData"
            ,"SQLiteExample",
    "Accelerate","HttpExample","Voice","ToolbarExample","RecyclerDemo","CardViewDemo"
    };

    protected void onCreate(Bundle a)
    {
        super.onCreate(a);
        //Fullscreen Code
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //SETTING LIST ADAPTER
        setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String c=classes[position];
        try {
            Class cla=Class.forName("com.example.aj.intentexample."+c);
            Intent i=new Intent(Menu.this,cla);
            startActivity(i);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater blowUp=getMenuInflater();
        blowUp.inflate(R.menu.cool_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId())
        {
            case R.id.aboutUs:
                Intent i=new Intent(Menu.this,AboutUs.class);
                startActivity(i);
                break;
            case R.id.prefernces:
                Intent k=new Intent(Menu.this,Prefs.class);
                startActivity(k);
                break;
            case R.id.exit:
                finish();
                break;
        }
        return false;

    }
}

