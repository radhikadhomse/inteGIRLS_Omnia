package com.example.radhika.omnia;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class CreateSubroutine extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_subroutine);
        Spinner condition_spinner = (Spinner)findViewById(R.id.condition_dropdown);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.condition_type_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        condition_spinner.setAdapter(adapter);

        Spinner task_spinner = (Spinner)findViewById(R.id.task_dropdown);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.task_options, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        task_spinner.setAdapter(adapter1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_subroutine, menu);
        return true;
    }

    public void confirmSubSave(View v){
        if(v.getId() == R.id.savebutton)
        {
//              Intent i = new Intent(CreateSubroutine.this, ConfirmSave.class);
//              startActivity(i);
            AlertDialog.Builder confirmSaveMessage = new AlertDialog.Builder(this);
            confirmSaveMessage.setMessage("Are you sure you want to save?");
            confirmSaveMessage.setCancelable(true);
            confirmSaveMessage.setTitle("Confirm save");
            confirmSaveMessage.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Toast.makeText(CreateSubroutine.this, "Saved Successfully!", Toast.LENGTH_LONG).show();
                }
            });
            confirmSaveMessage.setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id){
                    finish();
                }
            });
            AlertDialog alertDialog = confirmSaveMessage.create();
            alertDialog.show();
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