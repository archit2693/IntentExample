package com.example.aj.intentexample;

import android.app.Activity;
import android.content.Entity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class HttpExample extends Activity{

    TextView httpStuff;
    HttpClient client;
    final static String URL="http://api.openweathermap.org/data/2.5/weather?zip=311001,us&appid=44db6a862fba0b067b1930da0d769e98";
    JSONObject jsonObject;


    public String returned="loading";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.httpex);
        client=new DefaultHttpClient();
        new Read().execute("coord");
        }

    public JSONObject lastTweet(String username)throws ClientProtocolException,IOException,JSONException
    {
        StringBuilder url=new StringBuilder(URL);
       // url.append(username);
        HttpGet get=new HttpGet(url.toString());
        HttpResponse response=client.execute(get);
        int status=response.getStatusLine().getStatusCode();
        if(status==200)
        {
            HttpEntity e= response.getEntity();
            String data= EntityUtils.toString(e);
            //JSONArray timeline=new JSONArray(data);
            JSONObject last=new JSONObject(data);
            return last;
        }
        return null;
    }

    public class Read extends AsyncTask<String,Integer,String>
    {

        @Override
        protected String doInBackground(String... params) {
            try {
                jsonObject=lastTweet("311001");
                return jsonObject.getString(params[0]);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            httpStuff.setText(s);
            super.onPostExecute(s);
        }

    }
}
