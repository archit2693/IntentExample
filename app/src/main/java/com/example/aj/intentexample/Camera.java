package com.example.aj.intentexample;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class Camera extends Activity
{

    ImageButton ib;
    Button b;
    ImageView iv;
    final static int cameraResults=0;
    Intent i;
    Bitmap bmp;
    protected void onCreate(Bundle a)
    {
        super.onCreate(a);
        setContentView(R.layout.photo);
        initialize();
        InputStream is=getResources().openRawResource(R.raw.icon);
        bmp= BitmapFactory.decodeStream(is);
    }
    private void initialize()
    {
     iv=(ImageView)findViewById(R.id.returnPic);
     ib=(ImageButton)findViewById(R.id.takePic);
     b=(Button)findViewById(R.id.setWallpaper);

    }

    public void onButtonC(View view)
    {
        try {
            getApplicationContext().setWallpaper(bmp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onImageButtonClick(View view)
    {
        i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,cameraResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RESULT_OK)
        {
            Bundle extras=data.getExtras();
            bmp=(Bitmap)extras.get("data");
            iv.setImageBitmap(bmp);
        }
    }
}
