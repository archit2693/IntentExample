package com.example.aj.intentexample;


import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

public class GetMethodEx extends AsyncTask<Void,Void,Void> {
    @Override
    protected Void doInBackground(Void... params) {

        BufferedReader in = null;
        String data;
        try {
            HttpClient client = new DefaultHttpClient();
            URI website = new URI("http://www.mybringback.com/");
            HttpGet request = new HttpGet();
            request.setURI(website);
            HttpResponse response = client.execute(request);
            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer("");
            String l = "";
            String Nl = System.getProperty("line.separator");
            while ((l = in.readLine()) != null) {
                sb.append(l + Nl);
            }
            in.close();
             data  = sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
        return null;
    }
}