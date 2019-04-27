package com.example.intents35;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Apples extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apples);
    }

    // go to Bacon activity
    public void onClick()
    {
        Intent i = new Intent(this, Bacon.class);   // create instance of Intent
        startActivity(i);                                       // use intent (cf segue)
    }
}
