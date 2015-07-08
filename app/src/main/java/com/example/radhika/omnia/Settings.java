package com.example.radhika.omnia;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class Settings extends ActionBarActivity {
    public static String zipcode = "";
    public static String current_weather = "weather1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    public void saveInformation(View v)
    {
        if(v.getId() == R.id.save_button1)
        {
            EditText ci = (EditText)findViewById(R.id.TFzipcode);
            zipcode = ci.getText().toString();
            getWeather(zipcode);
            TextView save = (TextView)findViewById(R.id.TVsavesuccess);
            save.setText("Save successful!");
        }
    }

    public void goBack(View v)
    {
        if(v.getId() == R.id.back_button2)
        {
            Intent i = new Intent(Settings.this, Home.class);
            i.putExtra("Weather", current_weather);
            i.putExtra("ActivityFrom", "SettingsActivity");
            startActivity(i);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void getWeather(String zd) {
        String urlStr = "http://api.openweathermap.org/data/2.5/weather?zip=" + zd + ",us&APPID=8d224fcb2fd5733ccc75508a8650b510";
        new CallAPI().execute(urlStr);

    }

    private class CallAPI extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {

            String urlString = params[0]; // URL to call

            String resultToDisplay = "";

            InputStream in = null;

            try {

                URL url = new URL(urlString);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                in = new BufferedInputStream(urlConnection.getInputStream());
                String jason = printBufferStream(in);
                String weather_description = jason.substring(jason.indexOf("description") + 14, jason.indexOf(",\"icon") - 1);
                current_weather = weather_description;
                resultToDisplay = current_weather;
                Log.i(current_weather, "THIS IS THE CURRENT WEATHER");
                //thread.sleep

            } catch (Exception e) {

                System.out.println(e.getMessage());

                return e.getMessage();

            }
            return resultToDisplay;
        }

        protected String printBufferStream(InputStream in) throws IOException {
            byte[] contents = new byte[2048];

            int bytesRead = 0;
            String strFileContents = "";
            while ((bytesRead = in.read(contents)) != -1) {
                strFileContents += new String(contents, 0, bytesRead);
            }
            //System.out.print(strFileContents);
            return strFileContents;
        }

    }
}