package com.example.radhika.omnia;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.speech.tts.Voice;
import android.speech.tts.TextToSpeech;
import java.util.Locale;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Display;
import android.content.Intent;
import android.widget.EditText;
import android.util.Log;
public class LoginScreen extends ActionBarActivity {
    TextToSpeech ttsobj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        ttsobj = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener(){
            public void onInit(int status){

            }
        });
        ttsobj.setLanguage(Locale.US); //changevoice?
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_screen, menu);
        return true;
    }

    public void onButtonClick(View v)
    {
        if(v.getId() == R.id.btn_login)
        {
            EditText a = (EditText)findViewById(R.id.fld_username);
            String str = a.getText().toString();
            if(str==null)
                str =" ";
            ttsobj.speak("Hello " + str + " My name is Omnia", TextToSpeech.QUEUE_FLUSH, null);
            Log.i("THIS IS THE ", str);

            Intent i = new Intent(LoginScreen.this, Home.class);
            i.putExtra("Username", str);
            i.putExtra("ActivityFrom", "Login_screen");
            // Log.i
            // ("THIS IS THE ", str);

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
}