package com.example.radhika.omnia;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
public class AddSubroutine extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subroutine);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_subroutine, menu);
        return true;
    }

    public void backButton(View v)
    {
        if(v.getId() == R.id.back_button_1)
        {
            Intent i = new Intent(AddSubroutine.this, Home.class);
            startActivity(i);
        }
    }
    public void onButtonClick(View v) {
        if(v.getId() == R.id.create_button) {
            Intent i = new Intent(AddSubroutine.this, CreateSubroutine.class);
            startActivity(i);

        }
        else if (v.getId() == R.id.load_button){
//            Intent i = new Intent(AddSubroutine.this,CreateSubroutine.class );
//            startActivity(i);
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=0HDdjwpPM3Y"));
            startActivity(i);
            // test youtube video
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