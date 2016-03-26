package com.example.aj.intentexample;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class GLExample  extends Activity{

    GLSurfaceView ourSurface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ourSurface=new GLSurfaceView(this);

        setContentView(ourSurface);
    }

    @Override
    protected void onPause() {

        super.onPause();
        ourSurface.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ourSurface.onResume();
    }
}
