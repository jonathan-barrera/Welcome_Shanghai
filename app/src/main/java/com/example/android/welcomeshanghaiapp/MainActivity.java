package com.example.android.welcomeshanghaiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the view that shows the What To See category
        TextView whatToSee = (TextView) findViewById(R.id.what_to_see);

        whatToSee.setOnClickListener(new View.OnClickListener() {
            // Code that is executed when the What To See TextView is clicked on.
            @Override
            public void onClick(View view) {
                // Intent to open the What To See activity
                Intent whatToSeeIntent = new Intent(MainActivity.this, WhatToSeeActivity.class);

                // Start the new activity
                startActivity(whatToSeeIntent);
            }
        });

        // Find the view that shows the What To See category
        TextView whatToEat = (TextView) findViewById(R.id.what_to_eat);

        whatToEat.setOnClickListener(new View.OnClickListener() {
            // Code that is executed when the What To See TextView is clicked on.
            @Override
            public void onClick(View view) {
                // Intent to open the What To See activity
                Intent whatToEatIntent = new Intent(MainActivity.this, WhatToEatActivity.class);

                // Start the new activity
                startActivity(whatToEatIntent);
            }
        });

        // Find the view that shows the What To See category
        TextView whenToGo = (TextView) findViewById(R.id.when_to_go);

        whenToGo.setOnClickListener(new View.OnClickListener() {
            // Code that is executed when the What To See TextView is clicked on.
            @Override
            public void onClick(View view) {
                // Intent to open the What To See activity
                Intent whenToGoIntent = new Intent(MainActivity.this, WhenToGoActivity.class);

                // Start the new activity
                startActivity(whenToGoIntent);
            }
        });

        // Find the view that shows the What To See category
        TextView usefulPhrases = (TextView) findViewById(R.id.useful_phrases);

        usefulPhrases.setOnClickListener(new View.OnClickListener() {
            // Code that is executed when the What To See TextView is clicked on.
            @Override
            public void onClick(View view) {
                // Intent to open the What To See activity
                Intent usefulPhrasesIntent = new Intent(MainActivity.this, UsefulPhrasesActivity.class);

                // Start the new activity
                startActivity(usefulPhrasesIntent);
            }
        });
    }
}
