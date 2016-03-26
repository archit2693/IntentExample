package com.example.aj.intentexample;

import android.app.Activity;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ExternalData extends Activity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private TextView canWrite,canRead;
    boolean canW,canR;
    private String state;
    Spinner spinner;
    String[] paths={"Music","Pictures","Downloads"};
    File path=null;
    File file=null;
    EditText saveFile;
    Button confirm,save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.externaldata);
        canWrite=(TextView)findViewById(R.id.tvCanWrite);
        canRead=(TextView)findViewById(R.id.tvCanRead);
        confirm=(Button)findViewById(R.id.bConfirmSaveAs);
        save=(Button)findViewById(R.id.bSaveFile);
        saveFile=(EditText)findViewById(R.id.etSaveAs);
        confirm.setOnClickListener(this);
        save.setOnClickListener(this);

        canWrite.setText("false");
        canRead.setText("false");
        checkState();

        ArrayAdapter<String> adapter=new ArrayAdapter<>(ExternalData.this,android.R.layout.simple_spinner_item,paths);
        spinner=(Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    private void checkState() {
        state= Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED))
        {
            canWrite.setText("true");
            canRead.setText("true");
            canW=canR=true;
        }
        else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY))
        {
            canWrite.setText("false");
            canRead.setText("true");
            canW=false;
            canR=true;
        }
        else
        {
            canWrite.setText("false");
            canRead.setText("false");
            canW=canR=false;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int pos=spinner.getSelectedItemPosition();
        switch (pos)
        {
            case 0:
                path=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
                break;
            case 1:
                path=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                break;
            case 2:
                path=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bSaveFile:
                String a=saveFile.getText().toString();
                file=new File(path,a);
                checkState();
                if(canW==canR==true)
                {
                    path.mkdirs();

                    try {
                        InputStream is=getResources().openRawResource(R.raw.icon);
                        OutputStream os=new FileOutputStream(file);
                        byte[] data=new byte[is.available()];
                        is.read(data);
                        os.write(data);
                        is.close();
                        os.close();
                        Toast t=Toast.makeText(ExternalData.this,"File has been saved",Toast.LENGTH_LONG);
                        t.show();

                        //Update Files for user to use
                        MediaScannerConnection.scanFile(ExternalData.this,new String[]{file.toString()},null, new MediaScannerConnection.OnScanCompletedListener() {
                            @Override
                            public void onScanCompleted(String path, Uri uri) {
                                Toast t=Toast.makeText(ExternalData.this,"scan complete",Toast.LENGTH_LONG);
                                t.show();
                            }
                        });
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                break;
            case R.id.bConfirmSaveAs:
                save.setVisibility(View.VISIBLE);
                break;

        }
    }
}
