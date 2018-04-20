package com.example.android.musical;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ArtistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        TextView artistTextView = (TextView) findViewById(R.id.artist_title);

        String artist = getIntent().getStringExtra("EXTRA_ARTIST");
        artistTextView.setText(artist);
    }
}
