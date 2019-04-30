package com.example.serviceintentservice41;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class Bacon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bacon);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        Bundle applesData = getIntent().getExtras();
        if (applesData == null) {
            return;
        } else {
            String appleMessage = applesData.getString("appleMessage");
            // look for key of key/value pair maybe passed in .putExtra when Intent'ing this activity
            // cf NotificationCenter / Observe
            final EditText baconText = (EditText) findViewById(R.id.bacon_text);
            baconText.setText(appleMessage);
        }
    }
        // go to Apples activity
        public void onClick(View view)      // NB View view parameter required
        {
            Intent i = new Intent(this, Apples.class);   // create instance of Intent

            final EditText baconInput = (EditText) findViewById(R.id.bacon_input);
            String userMessage = baconInput.getText().toString();
            i.putExtra("baconMessage", userMessage);
            // Intent.putExtra d'take key/value pair


            startActivity(i);
        }


    }



