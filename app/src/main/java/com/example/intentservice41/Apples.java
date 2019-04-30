package com.example.intentservice41;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Apples extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apples);

        // start up the Intent Service as an instance of the bespoke class
        Intent intentService = new Intent(this, PNJIntentService.class);
        startService(intentService);

        Bundle baconData = getIntent().getExtras();
        if (baconData == null)
        {
            return;
        }
        else
        {
            String baconMessage = baconData.getString("baconMessage");
            // look for key of key/value pair maybe passed in .putExtra when Intent'ing this activity
            // cf NotificationCenter / Observe
            final EditText appleText = (EditText) findViewById(R.id.apples_text);
            appleText.setText(baconMessage);
        }

    }

    // go to Bacon activity
    public void onClick(View view)
    {
        Intent i = new Intent(this, Bacon.class);   // create instance of Intent

        final EditText applesInput = (EditText) findViewById(R.id.applesInput);
        String userMessage = applesInput.getText().toString();
        i.putExtra("appleMessage", userMessage);
        // Intent.putExtra d'take key/value pair


        startActivity(i);                                       // use intent (cf segue)
    }
}
